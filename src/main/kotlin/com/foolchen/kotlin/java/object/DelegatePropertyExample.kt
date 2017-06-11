package com.foolchen.kotlin.java.`object`

import kotlin.reflect.KProperty

/**
 * 委托属性演示
 * @author chenchong. Created on 2017/6/11.
 */

class Example {
    var text: String by Delegate()
}

class Delegate {
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example：感谢将'${property.name}'委托给我！'"
    }

    operator fun setValue(example: Example, property: KProperty<*>, s: String) {
        println("$s 已经被赋值给$example 中的${property.name}")
    }
}

fun main(args: Array<String>) {
    val e = Example()
    println(e.text)
    e.text = "尝试赋值"
    println(e.text)
}

/*
属性的get()和set()方法会被委托给Delegate的getValue()和setValue()方法
当从委托到Delegate的实例的p读取时，将调用Delegate中的getValue()函数；需要给委托到Delegate的实例的p赋值时，会调用Delegate的setValue()方法

如果想不通过getValue()，而是想获取text的原值应该怎么处理？
 */