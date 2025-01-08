package Kotlin.AggregateOpPart

fun main() {
    val strings = listOf("one", "two", "three", "four", "butterfly", "bulldozer")
    val longestString = strings.maxByOrNull { it.length }
    println("Самая длинная строка: $longestString")
}