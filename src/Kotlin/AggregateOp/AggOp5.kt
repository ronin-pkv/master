package Kotlin.AggregateOp

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val squaredNumbers = numbers.filter { it <= 3 }.map { it * it }
    println("$squaredNumbers")
}