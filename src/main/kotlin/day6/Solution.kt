package day6

fun solution(input: String): Long {
    val lines = input.lines()
    val maxLen = lines.maxOf { it.length }
    val padded = lines.map { it.padEnd(maxLen) }
    val transposed = (0 until maxLen).map { i ->
        padded.joinToString("") { it[i].toString() }
    }

    val results = mutableListOf<Long>()

    var num = 0L
    var operation = ""
    for (value in transposed) {
        if (value.isBlank()) {
            results.add(num)
            num = 0L
        } else if (num == 0L) {
            val parts = value.trim().split(Regex("\\s+"))
            if (parts.size == 2) {
                num = parts[0].toLong()
                operation = parts[1]
            } else {
                num = value.trim().dropLast(1).toLong()
                operation = value[value.lastIndex].toString()
            }
        } else {
            when (operation) {
                "+" -> num += value.trim().toLong()
                "*" -> num *= value.trim().toLong()
            }
        }
    }
    results.add(num)

    return results.sum()
}