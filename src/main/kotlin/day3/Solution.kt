package day3

fun solution(input: String): Long {
    val banks = input.split("\n")
    var totalJoltage: Long = 0
    for (bank in banks) {
        var bankJoltage = ""
        var lastIndex = -1
        for (i in 11 downTo 0) {
            val (joltage, index) = getMaxJoltage(bank.substring(lastIndex + 1, bank.length - i))
            bankJoltage += joltage
            lastIndex += index + 1
        }
        totalJoltage += bankJoltage.toLong()
    }
    return totalJoltage
}

fun getMaxJoltage(bank: String): Pair<Int, Int> {
    var maxJoltageIndex = 0
    var maxJoltage = bank[maxJoltageIndex].digitToInt()
    for ((index, battery) in bank.withIndex()) {
        val batteryJoltage = battery.digitToInt()
        if (maxJoltage < batteryJoltage) {
            maxJoltage = batteryJoltage
            maxJoltageIndex = index
        }
    }
    return maxJoltage to maxJoltageIndex
}