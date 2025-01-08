package Kotlin.Coroutines1

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Начало программы")

    val lazyJob = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Произошел ленивый запуск")
    }

    val counterJob = launch {
        for (i in 1..4) {
            println(i)
            if (i == 2) {
                lazyJob.start()
                lazyJob.join()
            }
            delay(1000L)
        }
    }

    val endProgramJob = launch {
        counterJob.join()
        println("Программа завершена")
    }

    endProgramJob.join()
}