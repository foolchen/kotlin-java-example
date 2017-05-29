package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {

    val s: String by lazy {
        val s = "abc"
        s + "cde"
    }

    println(s)
}
