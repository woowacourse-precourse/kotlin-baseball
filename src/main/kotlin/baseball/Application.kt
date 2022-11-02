package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStartText()
    startBaseball()
}

fun startBaseball() {
    while (true) {
        val computerNumbers = mutableListOf<Int>()
        inputComputerNumbers(computerNumbers)
        val userNumbers = inputUserNumbers()
        checkUserNumbers(userNumbers, computerNumbers)
    }
}

fun checkUserNumbers(
    userNumbers: MutableList<Int>,
    computerNumbers: MutableList<Int>
) {
    //strike check
    val strikeCount = userNumbers.filterIndexed { idx, userNum ->
        userNum == computerNumbers[idx]
    }.size
    // ball check
    val ballCount = userNumbers.filterIndexed { idx, userNum ->
        computerNumbers.contains(userNum) &&
                userNum != computerNumbers[idx]
    }.size
    printUserCount(strikeCount, ballCount)
}

fun printUserCount(strikeCount: Int, ballCount: Int) {
    if (strikeCount == 3) {
        println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if (strikeCount > 0 && ballCount == 0) {
        println("$strikeCount 스트라이크")
    } else if (strikeCount == 0 && ballCount > 0) {
        println("$ballCount 볼")
    } else if (strikeCount == 0 && ballCount == 0) {
        println("낫싱")
    }
}

fun inputUserNumbers(): MutableList<Int> {
    val input = readLine()!!
    //예외 사항 : 정수 인지* , 길이가 3인지 , 중복된 숫자는 없는지
    val userNumbers = input.map {
        it.digitToInt()
    }.toMutableList()

    if (userNumbers.size != userNumbers.toSet().size || userNumbers.size != 3) {
        throw IllegalArgumentException()
    }

    return userNumbers
}

fun inputComputerNumbers(numbers: MutableList<Int>) {
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
}

fun gameStartText() = println("숫자 야구 게임을 시작합니다.")
