package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    rangeSample()
    println()
    rangeSample2()
    println()
    rangeSample3()
    println()
    rangeSample4()
}

private fun rangeSample() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("x 在1到${y + 1}范围内")
    }
}

private fun rangeSample2() {
    val list = listOf("a", "b", "c", 1, 2, 3, 4, 5, 6, 7, 8, 9)
    if (3 in list) {
        println("3 在列表中")
    }

    if (15 !in 0..list.lastIndex) {
        println("15超出了列表的长度范围")
    }

    if (list.size !in list.indices) {
        println("${list.size}超出了列表的长度范围")
    }
}

// 区间迭代
private fun rangeSample3() {
    for (x in 1..5) {
        println("x的值为$x")
    }
}

// 数列迭代
private fun rangeSample4() {
    // 每次跳过1个值进行递增
    for (x in 1..10 step 2) {
        println("step 2 (1 upTo 10):x的值为$x")
    }

    // 每次跳过2个值进行递减
    for (x in 9 downTo 0 step 3) {
        println("step 3 (9 downTo 0):x的值为$x")
    }
}
