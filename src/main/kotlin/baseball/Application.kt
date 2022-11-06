package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val randomValue = createRandomValue()
    val inputValue  = createInputValue()
    val compared = compareNumber(randomValue, inputValue)
    printResult(compared)
}

fun createRandomValue(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun createInputValue(): List<Int>{

    return readLine()!!
        .map { it.digitToIntOrNull() }
        .filterNotNull()
}

fun compareNumber(
    computer: List<Int>,
    user: List<Int>
): Pair<Int, Int> {
    var ball = 0
    var strike = 0
    computer.onEachIndexed { index, num ->
        if (num == user[index])
            strike += 1
        else if (user.contains(num))
            ball += 1
    }
    return Pair(ball, strike)
}

fun printResult(result: Pair<Int, Int>){
    val ball   = result.first
    val strike = result.second
    var hintMessage = ""

    if (ball != 0)
        hintMessage += "${ball}볼 "
    if (strike != 0)
        hintMessage += "${strike}스트라이크"

    if (hintMessage.isBlank()) hintMessage = "낫싱"

    println(hintMessage)
}