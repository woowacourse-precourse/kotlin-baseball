package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = getRandomNumber()
    printGameStart()
    do {
        val userNumber = inputUserNumber()
        if (!checkInput(userNumber)) throw IllegalArgumentException()
        checkCorrect(listToString(computerNumber), userNumber)
    } while (userNumber != listToString(computerNumber))
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun getRandomNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun inputUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    return readLine().toString()
}

fun checkInput(number: String): Boolean {
    if (number.length != 3) return false
    number.forEach {
        if (it !in '1'..'9') return false
    }
    if (number.toSet().size != 3) return false
    return true
}

fun listToString(list: List<Int>): String {
    var answer = ""
    list.forEach {
        answer += it
    }
    return answer
}

fun checkCorrect(answer: String, userInput: String) {
    var strikeCount = 0
    var ballCount = 0
    userInput.forEachIndexed { index, c ->
        if (answer.contains(c) && c == answer[index]) strikeCount++
    }
    userInput.forEachIndexed { index, c ->
        if (answer.contains(c) && c != answer[index]) ballCount++
    }

    printHint(strikeCount, ballCount)
}

fun printHint(strikeCount: Int, ballCount: Int) {
    when {
        strikeCount == 0 && ballCount == 0 -> println("낫싱")
        strikeCount == 0 && ballCount in 1..3 -> println("${ballCount}볼")
        strikeCount in 1..3 && ballCount == 0 -> println("${strikeCount}스트라이크")
        strikeCount in 1..3 && ballCount in 1..3 -> println("${ballCount}볼 ${strikeCount}스트라이크")
    }
}

fun end() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val number = readLine()!!.toInt()
    when (number) {
        1 -> gameStart()
        2 -> return
        else -> throw IllegalArgumentException()
    }
}