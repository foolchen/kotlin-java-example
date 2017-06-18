package com.foolchen.kotlin.java.funtion

/**
 * Lambda表达式和匿名函数
 * @author chenchong. Created on 2017/6/17.
 */

/*
一个lambda表达式或者匿名函数，是一个"函数字面值"（即一个未声明的函数），但立即作为表达式传递
 */

fun main(args: Array<String>) {
    val list = listOf("abc", "bc", "c")
    val max = max(list, { a, b -> a.length < b.length })
    println(max)
    // 如果一个看书接受另一个函数作为最后一个参数，则该参数可以在圆括号参数列表之外传递
    println(max(list) { a, b -> a.length < b.length })
    grammar()
}


/*
函数max是一个高阶函数，它能够接受一个函数作为第二个参数
其第二个参数是一个表达式，它本身就是一个函数，即"函数字面值"
写成函数的话相当于：
fun compare(a:String,b:String):Boolean = a.length<b.length

而此处直接传入函数的话更加灵活，具体的实现可以在传入时决定，而不需要事先定义
*/
fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection) {
        if (max == null || less(max, it)) {// 如果max < it，则将it赋值给max
            max = it
        }
    }
    return max
}

/*
lambda表达式的语法
lambda表达式总是被大括号包括，完整语法形式的参数生命放在括号内，并且有可选的类型标注
函数体跟在一个->符号之后

如果推断出该lambda表达式的返回类型不是Unit，则lambda函数体中的最后一个表达式会被视作返回值
 */
fun grammar() {
    println("Lambda grammar")
    var sum = { x: Int, y: Int -> x + y }// 此处x+y被视作返回值

    // 如果要显式的返回一个值，则可以将lambda写作如下，与上面的lambda等价
    sum = { x: Int, y: Int ->
        val result = x + y
        result
    }
    println(sum(10, 11))

    val sum2: (Int, Int) -> Int = { x, y -> x + y }
}
