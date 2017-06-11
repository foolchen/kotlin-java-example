package com.foolchen.kotlin.java.`object`

/**
 * 标准委托
 * @author chenchong. Created on 2017/6/11.
 */

/*
延迟属性lazy
lazy()可以接受一个lambda，并返回一个Lazy<T>实例的函数，返回的实例可以作为实现延迟属性的委托
第一次调用get()方法时会执行已传递给lazy()的lambda表达式，并记录结果，后续调用get()方法时则只返回
上次记录的结果
如此处，第一次调用lazyValue会执行lambda表达式，第二次则只会返回"Hello,this is lazy()"
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello,this is lazy()"
}

fun main(args: Array<String>) {

    println(lazyValue)
    println(lazyValue)
}
