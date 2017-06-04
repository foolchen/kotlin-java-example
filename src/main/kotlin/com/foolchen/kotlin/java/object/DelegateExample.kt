package com.foolchen.kotlin.java.`object`

/**
 * 代理模式示例,此处的演示可以与Java中的实现进行比较[DelegateExample]
 * @sample DelegateExample
 * @author chenchong. Created on 2017/6/4.
 */

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println(x)
    }
}

/*
“Derived 的超类型列表中的 by-子句表示 b 将会在 Derived 中内部存储。
并且编译器将生成转发给 b 的所有 Base 的方法。”
*/
class Derived(b: Base) : Base by b

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print()
}