package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val randomValue = createRandomValue()
    while (true) {
        val inputValue = createInputValue()
        if (!isValid(inputValue))
            throw IllegalArgumentException("입력 오류")

        val compared = compareNumber(randomValue, inputValue)
        printResult(compared)

        // 3strike일때 게임종료하고 새로운 숫자 입력받기
        // 새로운 숫자가 1 또는 2인지 확인

    }
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
    val input = readLine()
    val isDigitOnly = input!!.all {
        it.isDigit() && it.digitToInt() > 0
    }
    if (!isDigitOnly) return emptyList()

    return input
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

fun isValid(inputValue: List<Int>): Boolean{
    val isEmpty = inputValue.isEmpty()
    if (isEmpty) return false

    val listSize = inputValue.distinct().size
    return (listSize == 3)
}