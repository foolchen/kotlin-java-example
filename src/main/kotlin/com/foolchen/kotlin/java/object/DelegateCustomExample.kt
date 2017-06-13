package com.foolchen.kotlin.java.`object`

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 通过provideDelegate操作符，可以扩展创建属性实现所委托对象的逻辑
 * 如果by右侧所使用的对象将provideDelegate定义为成员或者扩展函数，那么会调用该函数来创建属性委托实例
 *
 * @author chenchong. Created on 2017/6/13.
 */


// 定义一个代理
class SingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value!!
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (null != value && null == this.value) {
            this.value = value;
        }
    }
}

// 声明代理类的实例
object DelegatesExt {
    fun <T> singleValueVar(): ReadWriteProperty<Any?, T> = SingleValueVar()
}

// 为属性设置代理
// 从代理类的定义可知，id和address属性仅第一次赋值有效
class Student {
    var id: Int by DelegatesExt.singleValueVar<Int>()
    var name: String = "chen"
    var address: String by DelegatesExt.singleValueVar<String>()

    override fun toString(): String {
        return "id:$id | name:$name | address:$address"
    }
}

fun main(args: Array<String>) {
    val student = Student()
    student.id = 1001
    student.name = "name1"
    student.address = "Beijing"

    println(student.toString())// id:1001 | name:name1 | address:Beijing

    student.id = 1002
    student.name = "name2"
    student.address = "Shanghai"

    println(student.toString())// id:1001 | name:name2 | address:Beijing
    // 结果验证：id和address仅第一次赋值有效
}

