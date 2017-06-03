package com.foolchen.kotlin.java.`object`

/**
 * @author chenchong. Created on 2017/6/3.
 */

// 内部类的定义方式
class Outer {
    private val bar: Int = 1

    // 使用inner关键字来定义内部类
    // 以便于能够访问外部类的成员（标记为inner的类，会有一个对外部对象的引用）
    inner class Inner {
        fun foo() = bar
    }
}

// 匿名内部类
interface Listener {
    fun onDown(x: Int, y: Int)
    fun onUp(x: Int, y: Int)
}

class View {
    var listeners: MutableList<Listener> = ArrayList()
    fun addListener(listener: Listener) {
        this.listeners.add(listener)
    }

    fun addAnotherListener(listener: AnotherListener) {}
}

fun main(args: Array<String>) {
    // 内部类的调用方式
    val f = Outer().Inner().foo()
    println(f)

    // 匿名内部类的使用方式
    val v = View()
    // 使用对象表达式创建匿名内部类实例
    v.addListener(object : Listener {
        override fun onDown(x: Int, y: Int) {
        }

        override fun onUp(x: Int, y: Int) {
        }
    })

    // 对象为函数式Java接口（接口中只有单个抽象方法）的实例，可以使用带接口类型前缀
    // 的lambda表达式来创建实例
    v.addAnotherListener(AnotherListener {
        s ->
        println(s)
    })
}