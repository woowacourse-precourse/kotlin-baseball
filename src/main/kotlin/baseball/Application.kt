package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var randomValue = createRandomValue()
    while (true) {
        val inputValue = createInputValue()
        if (!isValid(inputValue))
            throw IllegalArgumentException("입력 오류")

        val compared = compareNumber(randomValue, inputValue)
        printResult(compared)
        val isExit = isExit(compared)
        if (isExit < 0) break
        if (isExit > 0) randomValue = createRandomValue()
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
    print("숫자를 입력해주세요: ")
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

fun isExit(compared: Pair<Int, Int>): Int{
    val isThreeStrike = (compared.second == 3)
    if (!isThreeStrike) return 0

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")

    var continueInput = ""
    continueInput = readLine()!!

    if (continueInput == "1") return 1
    if (continueInput == "2") return -1
    throw IllegalArgumentException("입력 오류")
}