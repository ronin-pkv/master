package Kotlin.sort

fun isSawTooth(array: IntArray): Boolean {
    for (i in 1 until array.size - 1) {
        val left = array[i - 1]
        val right = array[i + 1]
        val current = array[i]

        if (!((current < left && current < right) || (current > left && current > right))) {
            return false
        }
    }
    return true
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(12, 7, 31, 4),
        intArrayOf(8, 7, 16, 5),
        intArrayOf(9, 1, 21, 11)
    )

    println("Исходная матрица: ")
    matrix.forEach { println(it.joinToString(" ")) }

    val sawToothArray = matrix.filter { isSawTooth(it) }
    println("\nПилообразные массивы (${sawToothArray.size}): ")
    sawToothArray.forEach { println(it.joinToString(" ")) }
}