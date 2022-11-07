package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printFirstStartMessage()
    do {
        startBaseballGame()
    } while (restartOrQuit())
}

fun startBaseballGame() {
    val answer = chooseComputerNumber()
    while (true) {
        var userNumber = getUserNumber()
        var result = compareWithAnswer(answer, userNumber)
        printHint(result)
        if (result.first == 3) {
            printGameOver()
            return
        }
    }
}

fun chooseComputerNumber(): String {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        var randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        addComputerNumber(randomNumber, computerNumber)
    }
    return computerNumber.joinToString("")
}

/* 뽑은 랜덤 숫자의 중복 여부를 확인하고 아닐 시 리스트에 추가하는 메소드  */
fun addComputerNumber(randomNumber: Int, computerNumber: MutableList<Int>) {
    if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber)
    }
}

fun printFirstStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userInput = Console.readLine().toString()
    val userNumber = mutableListOf<Char>()

    // 사용자의 입력이 세 자리 수가 아닌 경우
    if (userInput.length != 3) {
        throw IllegalArgumentException("You can enter only a three-digit number")
    }

    for (index in userInput.indices) {
        // 사용자의 입력이 숫자가 아닌 경우
        if (userInput[index] < '0' || userInput[index] > '9') {
            throw IllegalArgumentException("You can enter only a number")
        }
        // 사용자의 입력이 같은 숫자를 포함하는 경우
        if (userNumber.contains(userInput[index])) {
            throw IllegalArgumentException("Each digit number must be different")
        }
        userNumber.add(userInput[index])
    }
    return userNumber.toString()
}

fun compareWithAnswer(answer: String, userNumber: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (index in userNumber.indices) {
        if (userNumber[index] == answer[index]) {
            strike++
            continue
        }
        if (answer.contains(userNumber[index])) {
            ball++
        }
    }
    return Pair(strike, ball)
}

fun printHint(result: Pair<Int, Int>) {
    val strike = result.first
    val ball = result.second

    if (strike == 0 && ball == 0) {
        println("낫싱")
        return
    }

    if (strike == 0) {
        println("${ball}볼")
        return
    }

    if (ball == 0) {
        println("${strike}스트라이크")
        return
    }

    println("${ball}볼 ${strike}스트라이크")
}

fun printGameOver() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun restartOrQuit(): Boolean {
    val inputNumber = Console.readLine().toInt()
    if (inputNumber != 1 && inputNumber != 2) {
        throw IllegalArgumentException("You can only enter 1 or 2")
    }
    if (inputNumber == 1) {
        return true
    }
    println("게임 종료")
    return false
}