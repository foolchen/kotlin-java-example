package com.foolchen.kotlin.java.`object`

/**
 * 通过委托将属性存储在Map中
 * @author chenchong. Created on 2017/6/11.
 */

class MappedUser(val map: Map<String, Any>) {
    val name: String by map
    val age: Int by map
}

class MutableMappedUser(val map: MutableMap<String, Any>) {
    var name: String by map
    var age: Int by map
}

fun main(args: Array<String>) {
    // 声明一个MappedUser，初始化时会传入一个Map
    val user = MappedUser(mapOf("name" to "John Deo", "age" to 25, "other" to true))
    // 通过定义的委托属性来从Map中取值
    println(user.name)
    println(user.age)
    // 通过map可以打印出所有的值，但是在未定义委托属性的情况下无法通过属性从Map中取值（如此处的other属性）
    println(user.map.toString())

    val mutableUser = MutableMappedUser(HashMap<String, Any>())
    // 通过委托属性赋值
    mutableUser.name = "John Deo"
    mutableUser.age = 25
    // 未定义委托属性的话可以直接通过Map.put()方法存放键值对
    mutableUser.map.put("other", false)

    // 通过定义的委托属性来从Map中取值
    println(mutableUser.name)
    println(mutableUser.age)
    // 通过map可以打印出所有的值，但是在未定义委托属性的情况下无法通过属性从Map中取值（如此处的other属性）
    println(mutableUser.map.toString())


    // 局部属性委托
    example { mutableUser }
    println(mutableUser.map.toString()) // 第一次调用时，会执行Lazy Name的赋值操作
    println(mutableUser.map.toString()) // 再次调用时，则不会执行Lazy Name的赋值操作
}

fun example(computeUser: () -> MutableMappedUser) {
    val memoizedUser by lazy(computeUser)
    memoizedUser.name = "Lazy name"
    println("Lazy Init")
}
