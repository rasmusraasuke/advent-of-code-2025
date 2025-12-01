package day1

const val START = 50

fun solution(input: String): Int {
    var pointing = START
    var zeroCount = 0
    for (i in input.split("\n")) {
        val direction = i[0]
        var distance = i.substring(1).toInt()
        if (distance > 100) {
            zeroCount += Math.floorDiv(distance, 100)
            distance %= 100
        }

        val newPointing = when (direction) {
            'L' -> pointing - distance
            'R' -> pointing + distance
            else -> error("Unknown direction: $direction")
        }

        if (newPointing !in 1..<100) {
            zeroCount++
            if (newPointing < 0 && pointing == 0) zeroCount--
        }

        pointing = Math.floorMod(newPointing, 100)
    }
    return zeroCount
}