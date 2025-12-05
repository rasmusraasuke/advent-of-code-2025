import day4.solution
import java.io.File

const val INPUT_FILE = "src/main/resources/day4/input.txt"

fun main() {
    val input = File(INPUT_FILE).readText()
    println("---- SOLUTION ----")
    println(solution(input))
}