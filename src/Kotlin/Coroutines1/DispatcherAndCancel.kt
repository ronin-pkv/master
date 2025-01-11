package Kotlin.Coroutines1

import kotlinx.coroutines.*
import kotlin.random.Random

data class Person1(val name: String, val salary: Int)

class PersonManager {
    private val personList = mutableListOf<Person1>()

    fun addPerson(person: Person1) {
        personList.add(person)
    }

    fun getPersonList(): List<Person1> = personList
}

val resultList = mutableMapOf<Person1, Int>()

suspend fun addPassword(personManager: PersonManager) {
    for (person in personManager.getPersonList()) {
        delay(500L)
        val password = Random.nextInt(100000, 999999)
        resultList[person] = password
        println("Пароль добавлен для сотрудника: ${person.name}")
    }
}

suspend fun readDataPersonList(personManager: PersonManager) {
    println("\nСписок сотрудников:")
    for ((person, password) in resultList) {
        delay(1000L)
        println("Сотрудник: ${person.name}, Зарплата: ${person.salary}, Пароль: $password")
    }
}

fun main() = runBlocking {
    println("Программа работы с базой данных сотрудников")

    val personManager = PersonManager()

    while (true) {
        delay(1000L)
        println("Добавить сотрудника: \n1. Да\n2. Прочитать базу данных")
        when (readLine()?.trim()) {
            "1" -> {
                var name: String
                while (true) {
                    println("Введите имя сотрудника:")
                    name = readLine()?.trim().orEmpty()
                    if (name.matches(Regex("^[a-zA-Zа-яА-Я]+$"))) {
                        break
                    } else {
                        println("Введите имя без цифр.")
                    }
                }

                var salary: Int? = null
                while (salary == null) {
                    println("Введите зарплату сотрудника:")
                    salary = readLine()?.toIntOrNull()
                    if (salary == null) {
                        println("Некорректный ввод. Попробуйте снова.")
                    }
                }

                val person = Person1(name, salary)
                personManager.addPerson(person)
                println("Сотрудник добавлен: $person")
            }

            "2" -> {
                val job = launch {
                    addPassword(personManager)
                }
                job.join()
                readDataPersonList(personManager)
                break
            }

            else -> {
                println("Некорректный ввод, выберите 1 или 2.")
            }
        }
    }

    val job1 = launch {
        addPassword(personManager)
    }

    val job2 = launch {
        while (isActive) {
            println("Введите 0 для отмены работы:")
            val input = readLine()?.trim()
            if (input == "0") {
                job1.cancelAndJoin()
                println("Завершение работы")
                break
            }
        }
    }

    job1.join()
    job2.join()
    println("Программа завершена")
}
