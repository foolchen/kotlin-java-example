package com.foolchen.kotlin.java

/**
 * 字符串的使用
 * @author chenchong. Created on 2017/5/30.
 */

fun main(args: Array<String>) {
    // 原生字符串，不必包含转义符
    var text = """
        for(c in "foo")
            print(c)
             """
    println(text)

    // 通过trimMargin()去除前导空格
    text = """
    “Tell me and I forget.
    &Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)”
""".trimMargin().trimMargin("&")
    println(text)
}
