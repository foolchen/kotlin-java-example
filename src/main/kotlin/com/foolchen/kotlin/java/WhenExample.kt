package com.foolchen.kotlin.java

/**
 * when表达式的使用方式示例
 * 该表达式可以替代Java中的switch使用
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    val colors = listOf("Green", "Blue", "Red", "Yellow", "Orange", "Error")
    for (color in colors) {
        println(transform(color))
    }

    checkInRange(9)
    checkInRange(25)
    checkInRange(11)

    println(checkPrefix("prefix"))// true
    println(checkPrefix("Prefix"))// 由于检测时不忽略大小写，故此处为false

}

private fun transform(color: String): String {
    return when (color) {
        "Red", "red", "rEd".toUpperCase() -> "Color Red"// 也可以多个条件对应一个值
        "Green" -> "Color Green"
        "Blue" -> "Color blue"
    //"Error" -> throw IllegalArgumentException("错误的颜色:$color") // 可以在特定的条件下抛出异常
        "Error" -> "错误的颜色:$color"
        else -> "Unknown color"
    }
}

// transform方法等价于下面的方法
private fun transform2(color: String) = when (color) {
    "Red" -> "Color Red"
    "Green" -> "Color Green"
    "Blue" -> "Color blue"
    "Error" -> throw IllegalArgumentException("错误的颜色:$color")
    else -> "Unknown color"
}

// 可以使用when表达式来检查一个值是否位于指定的区间
private fun checkInRange(x: Int) {
    when (x) {
        in 1..10 -> println("$x 位于1-10之间")
        !in 10..20 -> println("$x 不位于10-20之间")
        else -> println("超出检测范围")
    }
}

// 检查一个字符串是否以prefix开头
private fun checkPrefix(x: Any): Boolean = when (x) {
    is String -> x.startsWith("prefix", false)// 判断是否以prefix字符串开头，并且不忽略大小写
    else -> false
}