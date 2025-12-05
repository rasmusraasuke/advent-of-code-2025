package day5

import kotlin.math.max

fun solution(input: String): Long {
    val parts = input.split(Regex("\\n\\s*\\n"))
    val ranges = parts[0].lines()
    val freshIds = mutableListOf<Pair<Long, Long>>()

    for (range in ranges) {
        val ends = range.split("-")
        val start = ends[0].toLong()
        val end = ends[1].toLong()
        freshIds.add(Pair(start, end))
    }

    freshIds.sortWith(Comparator { a, b -> a.first.compareTo(b.first) })
    val result = mutableListOf(freshIds[0])

    for (cur in freshIds.subList(1, freshIds.size)) {
       val last = result.last()
       if (cur.first <= last.second) {
           result[result.lastIndex] = last.first to max(last.second, cur.second)
       } else {
           result.add(cur)
       }
    }

    var freshIdCount: Long = 0
    for ((start, end) in result) {
        freshIdCount += (end - start) + 1
    }

    return freshIdCount
}