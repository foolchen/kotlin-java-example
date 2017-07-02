package com.foolchen.kotlin.java.funtion

/**
 * @author chenchong. Created on 2017/6/14.
 */

// 为Int类型定义扩展
// 定义了整数的除运算
infix fun Int.divide(x: Int): Int {
    return this / x
}

// 定义了一个普通的函数
// 其中s必须传入且不为空，off和len有默认值
fun read(s: String, off: Int = 0, len: Int = s.length) {
    println("off=$off,len=$len")
}

fun main(args: Array<String>) {
    // 针对一个值进行除法计算
    val number = 9
    println(number divide 2)
    println(number.divide(2))

    // 在其他参数有默认值的情况下，可以只传入不为空的参数即可
    read("123")
    // 可以选择部分参数传入，减少了重载方法
    read("456", 10)
    // 为了避免歧义，最好使用指定参数名的方式传入部分参数
    read("789", off = 11)
    read("789", len = 20)
}