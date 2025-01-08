package Kotlin.AggregateOp

fun main() {
    val strings = listOf("one", "two", "three")
    val reversedStrings = strings.map { it.reversed() }
    println("$reversedStrings")
}