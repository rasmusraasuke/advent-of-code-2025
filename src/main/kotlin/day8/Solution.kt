package day8

import kotlin.math.pow
import kotlin.math.sqrt

data class BoxDistance(
    val box1: Int,
    val box2: Int,
    val distance: Double
)

data class Coordinate(val x: Double, val y: Double, val z: Double)

fun solution(input: String): Long {
    val lines = input.lines()
    val distances = mutableListOf<BoxDistance>()
    val coords = lines.map {
        it.split(",").let { p -> Coordinate(p[0].toDouble(), p[1].toDouble(), p[2].toDouble()) }
    }
    for ((i, coord1) in coords.withIndex()) {
        for ((j, coord2) in coords.subList(i+1, coords.lastIndex + 1).withIndex()) {
            val dist = sqrt((coord1.x - coord2.x).pow(2.0) + (coord1.y - coord2.y).pow(2.0) + (coord1.z - coord2.z).pow(2.0))
            distances.add(BoxDistance(i, j+i+1, dist))
        }
    }

    val sortedDistances = distances.sortedBy { it.distance }
    val circuits = mutableMapOf<Int, MutableList<Int>>()

    for (dist in sortedDistances) {
        val box1 = dist.box1
        val box2 = dist.box2
        if (circuits.containsKey(box1) && circuits.containsKey(box2)) {
            if (circuits[box1] != circuits[box2]) {
                circuits[box1]!!.addAll(circuits[box2]!!)
                for (box in circuits[box2]!!) {
                   circuits[box] = circuits[box1]!!
                }
            } else {
                continue
            }
        } else if (circuits.containsKey(box1)) {
            circuits[box1]!!.add(box2)
            circuits[box2] = circuits[box1]!!
        } else if (circuits.containsKey(box2)) {
            circuits[box2]!!.add(box1)
            circuits[box1] = circuits[box2]!!
        } else {
            val list = mutableListOf(box1, box2)
            circuits[box1] = list
            circuits[box2] = list
        }

        if (circuits[box1]!!.size == coords.size) return coords[box1].x.toLong() * coords[box2].x.toLong()
    }
    return -1
}