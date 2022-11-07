package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var randomValue = createRandomValue()
    while (true) {
        when (playBaseBall(randomValue)){
            "EXIT" -> break
            "FAIL" -> continue
            "SUCCESS" -> randomValue = createRandomValue()
        }
    }
}
fun playBaseBall(randomValue: List<Int>): String{
    val inputValue = createInputValue()
    val compared = compareNumber(randomValue, inputValue)
    printResult(compared)
    return getGameResult(compared)
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

fun createInputValue(): List<Int> {
    print("숫자를 입력해주세요: ")
    val input = readLine()

    if (isValid(input!!))
        return input.map { it.digitToInt() }

    throw IllegalArgumentException("입력값이 서로 다른 3자리의 수가 아니므로 게임을 종료합니다.")
}

fun compareNumber(computer: List<Int>, user: List<Int>): Pair<Int, Int> {
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

fun printResult(result: Pair<Int, Int>) {
    val ball = result.first
    val strike = result.second
    var hintMessage = ""

    if (ball != 0)
        hintMessage += "${ball}볼 "
    if (strike != 0)
        hintMessage += "${strike}스트라이크"

    if (hintMessage.isBlank())
        hintMessage = "낫싱"

    println(hintMessage)
}

fun isValid(input: String): Boolean {
    val distinctList = input.toMutableList().distinct()
    val isDigitValid = input.all {
        it.isDigit() && it.digitToInt() > 0
    }
    val isSizeValid = (distinctList.size == 3 && input.length == 3)
    return (isDigitValid && isSizeValid)
}

fun getGameResult(compared: Pair<Int, Int>): String {
    val isThreeStrike = (compared.second == 3)
    if (!isThreeStrike) return "FAIL"

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")

    when(readLine()!!){
        "1" -> return "SUCCESS"
        "2" -> return "EXIT"
    }
    throw IllegalArgumentException("재시작이나 종료를 위해 1또는 2를 입력해주어야 합니다.")
}