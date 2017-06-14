package com.foolchen.kotlin.java.funtion

/**
 * 可变参数
 * @author chenchong. Created on 2017/6/14.
 */

// 定义函数，将不定长度的T类型元素数组转换为集合
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    result += ts
    return result
}


// 只有一个参数可以标注为vararg，如果可变长度的参数不是签名中的最后一个参数，则可以使用"命名参数语法"来传递后面的参数
fun <T> anotherAsList(vararg ts: T, anotherT: T): List<T> {
    val result = ArrayList<T>()
    result += ts
    result += anotherT
    return result
}

fun main(args: Array<String>) {
    val list = asList(1, 2, 3)
    println(list.toString())

    // 此处可变参数不是签名中的最后一个参数，则anotherT使用指定参数名（命名参数语法）来传递值
    val anotherList = anotherAsList(1, 2, 3, anotherT = 99)
    println(anotherList.toString())

    // 此处实现了数组的扩展
    val array = arrayOf(1, 2, 3)
    val lastList = asList(-1, 0, *array, 4, 5, 6)
    println("size = ${lastList.size}, elements = $lastList")// size = 8, elements = [-1, 0, 1, 2, 3, 4, 5, 6]
}
