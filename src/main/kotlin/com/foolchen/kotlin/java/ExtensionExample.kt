package com.foolchen.kotlin.java

/**
 * 扩展函数
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    val s = " abc def ghi        "
    println(s.removeSpace())
}

// 对字符串类型进行扩展，增加了去除所有空格的方法
fun String.removeSpace(): String {
    return replace(" ", "")
}
