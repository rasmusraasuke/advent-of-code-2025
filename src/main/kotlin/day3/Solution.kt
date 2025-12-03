package day3

fun solution(input: String): Int {
    val banks = input.split("\n")
    var totalJoltage = 0
    for (bank in banks) {
        val (fistBattery, index) = getMaxJoltage(bank)
        val (secondBattery, _) = getMaxJoltage(bank, index + 1)
        totalJoltage += "$fistBattery$secondBattery".toInt()
    }
    return totalJoltage
}

fun getMaxJoltage(bank: String, start: Int = 0): Pair<Int, Int> {
    var maxJoltageIndex = start
    var maxJoltage = bank[maxJoltageIndex].digitToInt()
    for ((index, battery) in bank.substring(start).withIndex()) {
        val batteryJoltage = battery.digitToInt()
        if (maxJoltage < batteryJoltage && (index != bank.length - 1 || start != 0)) {
            maxJoltage = batteryJoltage
            maxJoltageIndex = index
        }
    }
    return maxJoltage to maxJoltageIndex
}