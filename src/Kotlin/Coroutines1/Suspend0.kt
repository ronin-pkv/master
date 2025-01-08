package Kotlin.Coroutines1

import kotlinx.coroutines.*

data class Person(val name: String, val age: Int)

data class Weather(val city: String, val description: String, val temp: Double)

suspend fun <T> downloadData(list: List<T>): List<T> {
    println("Начинается загрузка данных...")
    delay(1000L)
    println("Данные загружены: $list")
    return list
}

fun main() = runBlocking {
    val personList = listOf(
        Person("Добрыня", 35),
        Person("Алёша", 28),
        Person("Илья", 41),
        Person("Ярополк", 31)
    )

    val weatherList = listOf(
        Weather("Москва", "Пасмурно", -12.4),
        Weather("Краснодар","Солнечно",6.7),
        Weather("Тбилиси", "Дождливо", 4.3)
    )

    val randomNumbers = List(10) { (1..100).random() }

    println("Загрузка данных началась...")

    val loadedPersonList = async { downloadData(personList) }
    val loadedWeatherList = async { downloadData(weatherList) }
    val loadedRandomNumbers = async { downloadData(randomNumbers) }

    val finalPersons = loadedPersonList.await()
    val finalWeather = loadedWeatherList.await()
    val finalNumbers = loadedRandomNumbers.await()

    println("\nВсе данные загружены:")
    println("Список Person: $finalPersons")
    println("Список Weather: $finalWeather")
    println("Список случайных чисел: $finalNumbers")

    println("\nПрограмма завершена")

}