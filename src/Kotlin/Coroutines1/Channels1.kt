package Kotlin.Coroutines1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.system.measureTimeMillis

suspend fun modifiedList(inputChannel: Channel<String>, outputChannel: Channel<String>) {
    for (line in inputChannel) {
        val firstLetter = line.firstOrNull()?.uppercaseChar()?.toString() ?: ""
        delay(10L)
        outputChannel.send(firstLetter)
    }
    outputChannel.close()
}

fun main() = runBlocking {
    val storage = Storage()
    val inputChannel = Channel<String>()
    val outputChannel = Channel<String>()

    val modifiedList = mutableListOf<String>()
    val stringBuilder = StringBuilder()

    val elapsedTime = measureTimeMillis {
        launch { getList(storage.text, inputChannel) }

        launch { modifiedList(inputChannel, outputChannel) }

        for (item in outputChannel) {
            modifiedList.add(item)
        }
    }

    val stringResult = modifiedList.joinToString(separator = "")
    println("Преобразованный список первых букв: $modifiedList")
    println("Результирующая строка: $stringResult")
    println("Время выполнения: $elapsedTime мс")
}