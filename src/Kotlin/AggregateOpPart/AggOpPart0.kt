package Kotlin.AggregateOpPart

fun main() {
    val numbers = (1..20).toList()
    val evenCount = numbers.drop(4).count { it % 2 == 0 }
    println("Количество чётных чисел: $evenCount")
}