package Kotlin.AggregateOp

data class Player(val name: String, val points: Int, val winnings: Double)

fun main() {
    val players = listOf(
        Player("Алиса", 43, 989.5),
        Player ("Борис", 67, 1234.43),
        Player("Вика", 55, 1001.1),
        Player("Джанго", 99, 2221.8)
    )

    val totalPoints = players.sumOf { it.points }
    val totalWinnings = players.sumOf {it.winnings}


    println("Общее количество очков: $totalPoints")
    println("Общий выигрыш: $totalWinnings ")
}