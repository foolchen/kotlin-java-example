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

默认情况下，对于lazy属性的求值是同步的，故所有线程看到的值是相同的
如果不需要同步，则可以将LazyThreadSafetyMode.PUBLICATION当做参数传递给lazy()函数
如果确定初始化操作发生在单个线程中，则可以使用LazyThreadSafetyMode.NONE模式，该模式不会有任何线程安全相关的处理和资源开销
 */
val lazyValue: String by lazy/*(LazyThreadSafetyMode.PUBLICATION)*/ {
    println("computed!")
    "Hello,this is lazy()"
}

fun main(args: Array<String>) {

    println(lazyValue)
    println(lazyValue)
}
