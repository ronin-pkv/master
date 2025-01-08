package Kotlin.AggregateOp

fun main() {
    val colorEng = listOf("red", "blue", "white")
    val colorRus = listOf("красный", "синий", "белый")

    val translation = colorEng.zip(colorRus) {eng, rus -> "Значение: $eng, Перевод: $rus"}
    println(translation)
}