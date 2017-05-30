package com.foolchen.kotlin.java


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

/*
当一个类Comparable的类型参数T被声明为in时，它就只能出现在Comparable的成员被使用的位置
与out对应，此时Comparable<Int>可以安全的作为Comparable<Number>的子类
*/

fun copyArray(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun fixCopyArray(from: Array<out Any>, to: Array<in Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main(args: Array<String>) {
    //var list: List<Object> = List<String>()
    println(demo(SourceImpl("abc")).nextT())
    demo(ComparableImpl(number = 111.6))

    val ints: Array<Int> = arrayOf(1, 2, 3)
    val anys = Array<Any>(3, { })

    // 此处无法编译通过
    // Array<T>在T上是不型变的，故Array<Int>和Array<Any>互相不为子类型
    // 此处无法保证两个数组的互相写入和读取
    // 例如它可能会从anys中读取一个字符串并尝试写入ints
    // 此时会抛出ClassCastException异常
    // copyArray(ints, anys)

    // 此处指定了ints只能当做生产者，anys只能当做消费者
    // 并且Array<Int>为Array<Any>的子类型，此时写入无问题
    // 此处发生的情况称作 类型投影
    // 此处from和to都是受限制（投影的）数组
    fixCopyArray(ints, anys)
    println(anys.contentToString())

    // 此处无法编译通过
    // 此处指定了第二个参数只能当做消费者
    // 则在使用Array<Any>的子类时，可能会导致写入不符合的类型
    // fixCopyArray(anys, ints)
}