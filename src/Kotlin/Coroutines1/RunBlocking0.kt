package Kotlin.Coroutines1

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Программа покупки продуктов")

    delay(1000L)
    println("Купить товар:\n1. Да\n2. Нет")

    val input = readLine()

    when(input) {
        "1" -> {
            val paymentJob = launch {
                println("Оплата продукта началась")
                delay(2000L)
                println("Сканирование и обработка...")
                delay(2000L)
                println("Покупка оплачена.")
            }
            paymentJob.join()
        }
        "2" -> {
            val cancelJob = launch {
                println("Отмена покупки...")
                delay(2000L)
                println("Покупка отменена.")
            }
            cancelJob.join()
        }
        else -> {
            println("Ошибка: некорректный ввод.")
        }
    }

    val goodbyeJob = launch {
        println("До свидания.")
    }
    goodbyeJob.join()
}