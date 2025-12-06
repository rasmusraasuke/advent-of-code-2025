package day6

fun solution(input: String): Long {
    val lines = input.lines()
    val symbols = lines[lines.lastIndex].trim().split(Regex("\\s+"))

    val results = mutableMapOf<Int, Long>()
    for (line in lines.take(lines.size - 1)) {
        for ((index, num) in line.trim().split(Regex("\\s+")).withIndex()) {
            val long = num.toLong()
            when (symbols[index]) {
                "+" -> results[index] = results.getOrPut(index) {0} + long
                "*" -> results[index] = results.getOrPut(index) {1} * long
            }

        }
    }

    return results.values.sum()
}