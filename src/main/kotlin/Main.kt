import day6.solution
import java.io.File

const val INPUT_FILE = "src/main/resources/day6/input.txt"

fun main() {
    val input = File(INPUT_FILE).readText()
    println("---- SOLUTION ----")
    println(solution(input))
}