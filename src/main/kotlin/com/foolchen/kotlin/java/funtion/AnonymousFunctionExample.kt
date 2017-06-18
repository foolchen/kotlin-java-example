package com.foolchen.kotlin.java.funtion

/**
 * @author chenchong. Created on 2017/6/17.
 */

/*
LambdaExample中演示的lambda表达式语法缺少了"指定函数的返回类型"的能力。在多数情况下，这种能力是不必要的，因为返回类型能够自动推断出来
而如果在特拟定情况下需要显示指定返回类型，则可以使用另一种语法：匿名函数
*/

fun anonymousFuncSample() {
    // 匿名函数省略了函数名称，其他部分与常规函数的声明非常类似
    var sum = fun(x: Int, y: Int): Int = x + y
    println(sum(1, 2))

    // 也可以不指定返回类型，而由编译器自动推断出返回类型
    sum = fun(x: Int, y: Int) = x + y
    println(sum(2, 3))

    // 匿名函数的函数体可以是表达式，如上；或者是代码块，如下：
    // 如果函数体是代码块，则必须手动指定返回类型，而不能如上述的省略返回类型
    sum = fun(x: Int, y: Int): Int {
        return x + y
    }
    println(sum(3, 4))
}

fun main(args: Array<String>) {
    anonymousFuncSample()
}

/*
注意：
lambda表达式中，最后一个参数如果是函数的话，该参数可以在圆括号的参数列表之外传递
而匿名函数则只能在圆括号内传递

在省略return语句的情况下，lambda表达式的返回值将会从包含它的函数中返回，
而匿名函数将从匿名函数本身返回
*/