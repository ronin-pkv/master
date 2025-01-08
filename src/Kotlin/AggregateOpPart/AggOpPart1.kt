package Kotlin.AggregateOpPart

fun main() {
    val numbers = (1..20).toList()
    val sumFirstSeven = numbers.take(7).sum()
    println("Сумма первых 7 чисел списка: $sumFirstSeven")
}