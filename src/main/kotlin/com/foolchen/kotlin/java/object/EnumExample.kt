package com.foolchen.kotlin.java.`object`

/**
 * 枚举示例
 * @author chenchong. Created on 2017/6/3.
 */

// 最基本的枚举类定义方式
// 类型安全的枚举
enum class Direction {
    NORTH, SOURCE, WEST, EAST
}

// 带有构造函数的枚举，可以对枚举进行初始化
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// 枚举常量也可以声明自己的内部类
enum class ProtocolState {

    // 该常量为ProtocolState的内部类
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

fun main(args: Array<String>) {
    // 打印枚举的所有常量
    val directions = Direction.values()
    println(directions.contentToString())

    val colors: Array<Color> = Color.values()
    println(colors.contentToString())

    // 通过EnumClass.valueOf(String)方法可以获取对应的枚举常量
    println(Color.valueOf("RED"))
    try {
        // 如果未定义过该常量，则抛出异常
        println(Color.valueOf("YELLOW")) // IllegalArgumentException
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    // 通过泛型的方式防伪枚举类中的常量
    println(enumValues<Color>().joinToString { it.name })
}