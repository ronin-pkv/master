package Kotlin.AggregateOp

fun main() {
    val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко")

    val groupedFruits = fruits
        .filter {it.length % 2 == 0}
        .groupBy { it.first().lowercaseChar() }

    println("Результат: $groupedFruits")
}