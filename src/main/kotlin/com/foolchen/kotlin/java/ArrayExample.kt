package com.foolchen.kotlin.java

/**
 * 数组使用示例
 * @author chenchong. Created on 2017/5/30.
 */


fun main(args: Array<String>) {
    // 使用arrayOf生成数组
    val array = arrayOf(1, 2, 3)
    println(array.contentToString())
    println()

    // 使用构造函数初始化一个数组
    val asc = Array(5, { i -> i.toString() })
    println(asc.contentToString())
}
