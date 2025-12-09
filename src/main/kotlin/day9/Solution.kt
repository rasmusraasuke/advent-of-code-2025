package day9

import kotlin.math.abs

fun solution(input: String): Long {
    val coords = input.lines().map { line ->
        val (a, b) = line.split(",")
        a.toLong() to b.toLong()
    }
    println(coords)
    var maxArea = 0L
    for ((i, coord1) in coords.withIndex()) {
        for (coord2 in coords.drop(i+1)) {
            val xSide = (abs(coord1.first - coord2.first) + 1)
            val ySide = (abs(coord1.second - coord2.second) + 1)
            val area = xSide * ySide
            if (maxArea < area) maxArea = area

        }
    }
    return maxArea
}