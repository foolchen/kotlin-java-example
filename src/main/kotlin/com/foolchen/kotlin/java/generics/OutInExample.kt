package com.foolchen.kotlin.java.generics


/**
 * @author chenchong. Created on 2017/5/30.
 */

abstract class Source<out T> {
    abstract fun nextT(): T
}

class SourceImpl(val text: String) : Source<String>() {
    override fun nextT(): String {
        return text
    }
}

fun demo(s: Source<String>): Source<Any> {
    val objects: Source<Any> = s
    return objects
}

/*
当一个类Source的类型参数T被声明为out时，它(T)就只能出现在Source的成员的输出位置
但这样的回报是Source<Any>可以安全的作为Source<String>的超类

Source在参数T上是协变的，或者说T是一个协变的类型参数
可以简单的认为Source是T的生产者，而不是T的消费者
*/

abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
    //abstract fun nextT(): T // 此时T只能当做参数被消费者使用，Comparable不能当做生产者输出一个T
}

class ComparableImpl(var number: Number) : Comparable<Number>() {
    override fun compareTo(other: Number): Int {
        return number.toInt() - other.toInt()
    }
}

fun demo(c: Comparable<Number>) {
    println(c.compareTo(1.0))//1.0拥有类型为Double，是Number的子类型

    val other: Comparable<Int> = c
    println(other)
}


fun main(args: Array<String>) {
    //var list: List<Object> = List<String>()
    println(demo(SourceImpl("abc")).nextT())
    demo(ComparableImpl(number = 111.6))
}