package com.foolchen.kotlin.java.`object`

/**
 * @author chenchong. Created on 2017/6/4.
 */

// 定义一个单例
// 该单例的定义方式为对象声明
// 对象声明的方式：在object关键字后跟一个名称
// 该对象可以有超类
// 注意：对象声明不能在局部作用域（函数内部）定义，但是可以在其他对象中或者非内部类中声明
object DataProviderManager : BaseManager() {
    private val providers: MutableList<Provider> get() = providers

    fun registerDataProvider(provider: Provider) {
        providers.add(provider)
    }

    fun unregisterDataProvider(provider: Provider) {
        providers.remove(provider)
    }
}

class Provider

open class BaseManager

fun main(args: Array<String>) {
    // var manager = DataProviderManager() // 无法实例化

    // 单例的使用方式：可以通过对象名直接调用
    val provider = Provider()
    DataProviderManager.registerDataProvider(provider)
    DataProviderManager.unregisterDataProvider(provider)
}