package Kotlin.AggregateOpPart

data class Product(val name: String, val quantity: Int)

fun main() {
    val products = listOf(
        Product("Яблоки", 34),
        Product("Бананы", 54),
        Product("Манго", 22),
        Product("Виноград", 19),
        Product("Авокадо Хасс", 11)
    )
    val totalQuantity = products.map { it.quantity }.fold(0) {acc, quantity -> acc + quantity}
    println("Общее количество продуктов: $totalQuantity")
}