package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    val colors = listOf("Green", "Blue", "Red", "Yellow", "Orange", "Error")
    for (color in colors) {
        println(transform(color))
    }
}

private fun transform(color: String): String {
    return when (color) {
        "Red" -> "Color Red"
        "Green" -> "Color Green"
        "Blue" -> "Color blue"
        "Error" -> throw IllegalArgumentException("错误的颜色:$color")
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