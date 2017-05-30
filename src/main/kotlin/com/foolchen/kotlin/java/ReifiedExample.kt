package com.foolchen.kotlin.java

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

/**
 * 泛型示例,其中使用了Gson
 * @author chenchong. Created on 2017/5/30.
 */
class ReifiedExample {

    data class Person(@SerializedName("name") var name: String, @SerializedName("age") var age: Int)
}

val SINGLE: String = "{\"name\":\"Kotlin\",\"age\":2}"
val SEVERAL: String = "[{\"name\":\"Kotlin1\",\"age\":2},{\"name\":\"Kotlin2\",\"age\":3},{\"name\":\"Kotlin3\",\"age\":4},{\"name\":\"Kotlin4\",\"age\":5}]"

fun main(args: Array<String>) {
    val person = Gson().fromJson<ReifiedExample.Person>(SINGLE, ReifiedExample.Person::class.java)
    println(person)
    println()
    // 此处获取List的类型
    val type = object : TypeToken<List<Person>>() {}.type
    val persons = Gson().fromJson<List<ReifiedExample.Person>>(SEVERAL, type)
    println(persons)
    println()
    // 另一种方式实现解析
    val otherPerson = Gson().fromJson<Person>(SINGLE)
    val otherPersons = Gson().toArray<List<Person>>(SEVERAL)

    println("other person : $otherPerson \nother persons : $otherPersons")

}

// 以下两个函数为内联函数，会在使用时直接嵌入到调用处（可以理解为批量替换）
// 能够提高程序的执行效率（没有了方法的调用时间）
// 但是会增加生成的代码量（将函数直接替换到了调用处，而不是调用方法）
// 故一般会对一些简单的处理进行内联，而如果是复杂的函数则不要使用内联

// 该方法是对Gson.fromJson的扩展
inline fun <reified T : Any> Gson.fromJson(json: String): T = this.fromJson(json, T::class.java)

// 该方法实现了对数组进行解析的扩展
// 在Java中未实现泛型化的数组解析
inline fun <reified T : Any> Gson.toArray(json: String): T = this.fromJson(json, object : TypeToken<T>() {}.type)