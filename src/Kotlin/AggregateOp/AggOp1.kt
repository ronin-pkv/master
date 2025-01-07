package Kotlin.AggregateOp

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    val result = numbers.fold("") { acc, num -> acc + num }
    println("Результат: $result")
}