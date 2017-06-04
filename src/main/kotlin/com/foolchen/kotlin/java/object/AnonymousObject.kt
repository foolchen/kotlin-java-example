package com.foolchen.kotlin.java.`object`

/**
 * @author chenchong. Created on 2017/6/4.
 */


class AClazz {
    // 私有函数，此时返回的对象类型为实际定义的匿名对象类型（此处为String）
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，此处返回的对象类型为Any
    // 此时无法调用定义的x
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun run() {
        var foo = foo()
        println(foo.x)
        println("私有函数返回的匿名对象类型：${foo.javaClass}")

        var publicFoo = publicFoo()
        // publicFoo.x // 此处无法调用x
        println("公有函数返回的匿名对象类型：${publicFoo.javaClass}")
    }
}

fun main(args: Array<String>) {
    AClazz().run()
}

/*
原文描述如下：

“匿名对象可以用作只在本地和私有作用域中声明的类型。
如果你使用匿名对象作为公有函数的 返回类型或者用作公有属性的类型，
那么该函数或属性的实际类型 会是匿名对象声明的超类型，
如果你没有声明任何超类型，就会是 Any。在匿名对象 中添加的成员将无法访问。”
*/