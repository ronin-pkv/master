package Kotlin.Coroutines1

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun getRandomList(size: Int): List<Int> {
    return List(size) { Random.nextInt(0, 100) }
}

fun getRandomList(size: Int, isChar: Boolean): List<Any> {
    return if (isChar) {
        List(size) { Random.nextInt(65, 91).toChar() }
    } else {
        List(size) {Random.nextInt(0, 100)}
    }
}

suspend fun <T> unpack(list: List<T>): Int {
    println("Начинается распаковка списка: $list")
    var count = 0
    for (element in list) {
        delay(1000L)
        println(element)
        count++
    }
    delay(1000L)
    println("Распаковка завершена. Элементов в списке: $count")
    return count
}

fun <T> concatenate(list1: List<T>, list2: List<T>): Pair<Int, MutableList<T>> {
        val combinedList = mutableListOf<T>().apply {
            addAll(list1)
            addAll(list2)
        }
        return Pair(combinedList.size, combinedList)
}

fun main() = runBlocking {
        println("Программа началась")

        val elapsedTime = measureTimeMillis {
            val randomNumbers = getRandomList(10)
            val randomChars = getRandomList(10, isChar = true)

            val defferedNumbers = async { unpack(randomNumbers) }
            val defferedChars = async { unpack(randomChars) }

            val countNumbers = defferedNumbers.await()
            val countChars = defferedChars.await()

            println("Общий размер распакованных списков: ${countNumbers + countChars}")

            val (totalSize, concatenatedList) = concatenate(randomNumbers, randomChars)
            println("Объединённый список: $concatenatedList")
            println("Общий размер объединённого списка: $totalSize")
        }

        println("Программа завершена. Общее время выполнения: $elapsedTime мс")
}
