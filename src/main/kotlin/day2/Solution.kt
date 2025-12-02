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
            if (len % 2 == 0 && str.take(len/2) == str.substring(len/2)) {
                result += i
            }
        }
    }
    return result
}