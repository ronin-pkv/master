package Kotlin.sort

fun main() {
    val matrix = arrayOf(
        intArrayOf(12, 7, 3, 4),
        intArrayOf(8,7,6,5),
        intArrayOf(9,1,2,11)
    )

    println("Исходная матрица: ")
    matrix.forEach { println(it.joinToString(" ")) }

    println("\nСортированная матрица: ")
    val sortedMatrix = matrix.map { it.sortedArray() }
    sortedMatrix.forEach { println(it.joinToString(" ")) }
    }
