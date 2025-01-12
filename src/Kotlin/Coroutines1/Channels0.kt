package Kotlin.Coroutines1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.system.measureTimeMillis

class Storage {
    val text = """
        Мартышка к старости слаба глазами стала;
        А у людей она слыхала,
        Что это зло еще не так большой руки:
        Лишь стоит завести Очки.
        Очков с полдюжины себе она достала;
        Вертит Очками так и сяк:
        То к темю их прижмет, то их на хвост нанижет,
        То их понюхает, то их полижет;
        Очки не действуют никак.
        «Тьфу пропасть! — говорит она, — и тот дурак,
        Кто слушает людских всех врак;
        Всё про Очки лишь мне налгали;
        А проку на-волос нет в них».
        Мартышка тут с досады и с печали
        О камень так хватила их,
        Что только брызги засверкали.
    """.trimIndent()
}

suspend fun getList(text: String, channel: Channel<String>) {
    val lines = text.split("\n")
    for (line in lines) {
        delay(10L)
        channel.send(line)
    }
    channel.close()
}

fun main() = runBlocking {
    val storage = Storage()
    val channel = Channel<String>()
    val stringBuilder = StringBuilder()

    val elapsedTime = measureTimeMillis {
        launch { getList(storage.text, channel) }

        for (line in channel) {
            stringBuilder.append(line).append("\n")
        }
    }

    val stringResult = stringBuilder.toString().trim()
    println("Полученный текст:\n$stringResult")
    println("Время выполнения:\n$elapsedTime")
}