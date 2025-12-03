import day3.solution
import java.io.File

const val DAY_ONE_INPUT_FILE = "src/main/resources/day1/input.txt"
const val DAY_TWO_INPUT_FILE = "src/main/resources/day2/input.txt"
const val DAY_THREE_INPUT_FILE = "src/main/resources/day3/input.txt"

fun main() {
    val input = File(DAY_THREE_INPUT_FILE).readText()
    println("---- SOLUTION ----")
    println(solution(input))
}