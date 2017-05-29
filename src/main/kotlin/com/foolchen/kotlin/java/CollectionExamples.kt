package com.foolchen.kotlin.java

/**
 * @author chenchong. Created on 2017/5/29.
 */

fun main(args: Array<String>) {
    iterateExample()
    println()
    inExample()
    println()
    filterExample()
    println()
    filterPojos()
}


// 对集合进行迭代
private fun iterateExample() {

    val items = listOf("apple", "banana", "kiwi")
    // 遍历
    for (item in items) {
        println(item)
    }

}

// 使用 in 运算符来判断集合内是否包含某个实例
private fun inExample() {

    val items = setOf("apple", "banana", "kiwi")
    var x: String = "apple";
    if (x in items) {
        println("$x 在集合中")
    }

    x = "potato"
    if (x !in items) {
        println("$x 不在集合中")
    }
    when {
        "orange" in items -> println("Orange juice")
        "apple" in items -> println("Apple is fine too.")
    }
}

// 使用lambda表达式来过滤和映射集合
private fun filterExample() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }// 根据字符串默认顺序排序
            .map { it.toUpperCase() }// 将字符串转换为大写
            .forEach { println(it) }
}

// 使用lambda表达式来对对象集合进行过滤
private fun filterPojos() {
    val persons = listOf(Person("Az", 82), Person("adjg", 27), Person("Ad", 79), Person("Dx", 27), Person("Bd", 37), Person("Kd", 47), Person("Xx", 74), Person("Zd", 37))
    persons.filter { it.name.startsWith("A", true) or it.name.startsWith("D", true) }// 名字以"A"或"D"开头，并且忽略大小写
            .sortedBy { it.age }// 按照年龄大小排序(正序)；如果需要逆序，则使用sortedByDescending
            .forEach {
                it.name = it.name.toLowerCase()
                println(it)
            }
}

// 声明一个POJO
data class Person(var name: String, val age: Int) {
    override fun toString(): String {
        return "[$name,$age]"
    }
}