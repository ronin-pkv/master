package Kotlin.sort

data class Employee(val name: String, val age:Int, val salary:Double)

fun main() {
    val employees = listOf(
        Employee("Алиса", 32, 89000.00),
        Employee("Борис", 28, 121000.00),
        Employee("Владимир", 34, 66782.00),
        Employee("Галина", 45, 58000.00),
        Employee("Давид", 39, 143299.00)
    )

    println("Полный список: ")
    employees.forEach{ println(it) }

    println("Сортировка по имени:")
    employees.sortedBy { it.name }.forEach { println(it) }

    println("Сортировка по возрасту: ")
    employees.sortedBy { it.age }.forEach { println(it) }

    println("Сортировка по зарплате: ")
    employees.sortedBy { it.salary }.forEach { println(it) }
}