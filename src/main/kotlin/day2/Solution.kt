package day2

fun solution(input: String): Long {
    val ranges = input.split(",")
    var result: Long = 0
    for (range in ranges) {
        val parts = range.split("-")
        val start = parts[0].toLong()
        val end = parts[1].toLong()
        for (i in start..end) {
            val str = i.toString()
            val len = str.length
            if (len == 1) continue
            for (j in 2..len) {
                if (len % j == 0) {
                    val partSize = len / j
                    val chunks = str.chunked(partSize)
                    if (chunks.distinct().size == 1) {
                        result += i
                        break
                    }
                }
            }
        }
    }
    return result
}