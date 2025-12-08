package day7

fun solution(input: String): Int {
    val lines = input.lines().toMutableList()
    var timesSplit = 0

    for ((i, line) in lines.withIndex()) {
        if (line.contains("S")) {
            val pos = line.indexOfFirst { it == 'S' }
            lines[i+1] = lines[i+1].replaceAt(pos, '|')
        } else if (line.contains("|") && i != lines.lastIndex) {
            val indexes = line.mapIndexedNotNull { index, c ->
                if (c == '|') index else null
            }
            for (index in indexes) {
                when (lines[i+1][index]) {
                    '.' -> lines[i+1] = lines[i+1].replaceAt(index, '|')
                    '^' -> {
                        lines[i+1] = lines[i+1].replaceAt(index - 1, '|')
                        lines[i+1] = lines[i+1].replaceAt(index + 1, '|')
                        timesSplit++
                    }
                }
            }

        }
        println(line)
    }
    return timesSplit
}

fun String.replaceAt(index: Int, ch: Char): String {
    return StringBuilder(this).also { it[index] = ch }.toString()
}
