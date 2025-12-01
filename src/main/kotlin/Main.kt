import day1.solution
import java.io.File

const val DAY_ONE_INPUT_FILE = "src/main/resources/day1/input.txt"

fun main() {
    val input = File(DAY_ONE_INPUT_FILE).readText()
    println("---- SOLUTION ----")
    println(solution(input))
}