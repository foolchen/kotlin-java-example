package com.foolchen.kotlin.java.funtion

/**
 * Function Literals with Receiver
 *
 * 带接收者的函数字面值
 *
 * Kotlin中可以使用指定的接收者对象来调用函数
 * 在函数体中可以直接调用接收者对象上的方法而不需要任何额外的限定符
 *
 * 这类似于扩展函数，它允许你在函数体内访问接收者对象的成员
 *
 *
 * @author chenchong. Created on 2017/6/18.
 */

fun main(args: Array<String>) {
    println(1.sum(2))
    println(5.iMod(3))

    html {
        body()
        body2()
    }
    println(int {
        sum(2, 2)

        5.iMod(3) // 最后一个表达式作为返回值
    })
}

// 此处的定义与Int类型的扩展函数类似，具体可以参考FunctionExample
val sum = fun Int.(other: Int): Int = this + other

val iMod = fun Int.(divider: Int): Int {
    if (divider == 0) {
        throw IllegalArgumentException("divider should not be zero.")
    }
    return this % divider
}

class HTML {
    fun body() {
        println("This is HTML's body.")
    }

    fun body2() {
        println("This is body2.")
    }
}


fun html(func: HTML.() -> Unit): HTML {
    val html = HTML() // 创建一个接收者对象
    html.func() // 将接收者对象传递给该lambda
    return html
}

fun int(func: Int.() -> Int): Int {
    /*val number = 123
    return number.func()*/
    return func.invoke(123)
}
