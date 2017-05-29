package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    forExamples()
    println()
    whileExamples()
    println()
    whenExamples()
}

private fun forExamples() {
    println("For examples start.")
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    println()

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    println("For examples end.")
}

private fun whileExamples() {
    println("While examples start.")
    val items = listOf("apple", "banana", "kiwi")
    val size = items.size
    var index = 0
    while (index < size) {
        println("item at $index is ${items[index]}")
        index++
    }
    println("While examples end.")
}

private fun whenExamples() {
    val items = listOf(1, 2, "Hello", 123L, "String")
    for (item in items) {
        println(describe(item))
    }
}

private fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Hello"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }