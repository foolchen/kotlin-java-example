package com.foolchen.kotlin.java.`object`

/**
 * @author chenchong. Created on 2017/6/4.
 */
class CompanionExample {
    // 通过companion关键字来为CompanionExample定义伴生对象
    companion object Factory {
        fun create(): CompanionExample = CompanionExample()
    }
}

class AnonymousCompanionExample {
    // 此处省略了伴生对象的名称，此时则会使用默认名称Companion
    companion object {
        fun create(): AnonymousCompanionExample = AnonymousCompanionExample()
    }
}

fun main(args: Array<String>) {
    // 伴生对象的成员可以通过仅适用类名作为限定符的方式来调用
    var ce = CompanionExample.create()
    // 也可以通过完整的限定符来调用
    ce = CompanionExample.Factory.create()

    // 匿名伴生对象的调用方式
    var ace = AnonymousCompanionExample.Companion.create()
}