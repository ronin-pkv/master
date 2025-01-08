package Kotlin.AggregateOpPart

fun main() {
    val strings = listOf("one", "two", "three")
    val charList = strings.map { it.toList() }.flatten()
    println(charList)
}