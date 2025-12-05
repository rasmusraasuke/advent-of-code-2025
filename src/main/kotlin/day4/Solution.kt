package day4

fun solution(input: String): Int {
    val lines = input.split("\n").toMutableList()
    var accessibleRolls = 0

    var changesHappened = true
    while (changesHappened) {
        changesHappened = false

        for ((y, line) in lines.withIndex()) {
            for ((x, char) in line.withIndex()) {
                if (char == '@') {
                    val count = countSurroundingRolls(lines, x to y)
                    if (count < 4) {
                        lines[y] = lines[y].changeCharAt(x, 'x')
                        accessibleRolls++
                        changesHappened = true
                    }
                }
            }
        }
    }

    printGrid(lines)
    return accessibleRolls
}

private fun countSurroundingRolls(lines: List<String>, rollCords: Pair<Int, Int>): Int {
    val directions = arrayOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
        1 to 1,
        -1 to -1,
        1 to -1,
        -1 to 1
    )

    var count = 0
    for ((dirX, dirY) in directions) {
        val newX = rollCords.first + dirX
        val newY = rollCords.second + dirY
        if (newX in lines[0].indices && newY in lines.indices) {
            if (lines[newY][newX] == '@') {
                count++
            }
        }
    }
    return count
}

private fun String.changeCharAt(index: Int, newChar: Char): String =
    this.toCharArray().also { it[index] = newChar }.concatToString()

private fun printGrid(lines: List<String>) {
    for (line in lines) {
        println(line)
    }
    println()
    println()
}