package day5

fun solution(input: String): Int {
    val parts = input.split(Regex("\\n\\s*\\n"))
    val ranges = parts[0].lines()
    val ids = parts[1].lines().map { it.toLong() }
    val freshIds = mutableListOf<Pair<Long, Long>>()

    for (range in ranges) {
        val ends = range.split("-")
        val start = ends[0].toLong()
        val end = ends[1].toLong()
        freshIds.add(Pair(start, end))
    }

    var count = 0
    for (id in ids) {
        for ((start, end) in freshIds) {
            if (id in start..end) {
                count++
                break
            }
        }
    }

    return count
}