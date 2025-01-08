package Kotlin.AggregateOp

fun main() {
    val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May")
    val totalChar = months.sumOf { it.length }
    println("$totalChar")
}