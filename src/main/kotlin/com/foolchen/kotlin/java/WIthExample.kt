package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */


class WithExample {

    class Person {
        fun run() {
            println("Run")
        }

        fun stop() {
            println("Stop")
        }

        fun breath(value: Int) {
            println("Breath:$value")
        }
    }
}

fun main(args: Array<String>) {
    val person = WithExample.Person()
    // 使用with操作符，对同一个对象进行多次操作
    with(person)
    {
        run()

        for (i in 1..4) {
            breath(i)
        }

        stop()
    }
}
