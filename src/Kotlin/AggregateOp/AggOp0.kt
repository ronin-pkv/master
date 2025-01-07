package Kotlin.AggregateOp

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val sum = numbers.filter { it in 3..9 }.sum()
    println("Сумма элементов от 3 до 9: $sum")
}