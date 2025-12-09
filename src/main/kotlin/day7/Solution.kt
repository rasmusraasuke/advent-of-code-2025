package day7

fun solution(input: String): Long {
    val matrix = input.lines().map { line -> line. map { it.toString() }.toMutableList()}

    for ((i, line) in matrix.withIndex()) {
        if (i == 0) {
            val pos = line.indexOfFirst { it == "S" }
            matrix[1][pos] = "1"
        } else if (i != matrix.lastIndex) {
            val indexes = line.mapIndexedNotNull { index, c ->
                if (c != "." && c != "^") index else null
            }
            for (index in indexes) {
                when (matrix[i + 1][index]) {
                    "." -> matrix[i + 1][index] = line[index]
                    "^" -> {
                        // Left side
                        var leftSum = line[index].toLong() + (line[index - 1].toLongOrNull() ?: 0)
                        if (index - 2 >= 0 && matrix[i + 1][index - 2] == "^") {
                            leftSum += line[index - 2].toLongOrNull() ?: 0
                        }
                        matrix[i + 1][index - 1] = leftSum.toString()

                        // Right side
                        var rightSum = line[index].toLong() + (line[index + 1].toLongOrNull() ?: 0)
                        if (index + 2 <= line.lastIndex && matrix[i + 1][index + 2] == "^") {
                            rightSum += line[index + 2].toLongOrNull() ?: 0
                        }
                        matrix[i + 1][index + 1] = rightSum.toString()
                    }
                }
            }
        }
    }
    return matrix.last().sumOf { s -> s.toLongOrNull() ?: 0 }
}
