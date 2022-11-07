package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var oneOrTwo = 1
    while (oneOrTwo == 1) {
        playBaseBall()
        oneOrTwo = startOrEnd()
    }
}

fun startOrEnd(): Int {
    val oneOrTwo = Console.readLine()
    inputErrorCheckOneNum(oneOrTwo)
    return oneOrTwo.toInt()
}

fun inputErrorCheckOneNum(oneOrTwo: String) {
    if (oneOrTwo.toInt() !in 1..2) {
        throw IllegalArgumentException()
    }
}

fun playBaseBall() {
    val computer = randomThreeNumber()
    var result = hashMapOf<String, Int>()
    result["스트라이크"] = 0
    result["볼"] = 0
    while (result["스트라이크"] != 3) {
        result = playOneTime(computer, result)
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun playOneTime(computer: List<Int>, result: HashMap<String, Int>): HashMap<String, Int> {
    val user = playerThreeNumber()
    result.replace("스트라이크", findStrike(computer, user))
    result.replace("볼", findBall(computer, user) - result["스트라이크"]!!)
    printResult(result)
    return result
}

fun randomThreeNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playerThreeNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val playerInput = Console.readLine()
    inputErrorCheck(playerInput)
    val playerInputMutableList = playerInput.map { it.toString().toInt() }.toMutableList()
    return playerInputMutableList
}

fun inputErrorCheck(playerInput: String) {
    val playerInputMutableList = playerInput.map { it.toString().toInt() }.toMutableList()
    if (playerInputMutableList.size != 3 || playerInputMutableList.toSet().size != 3) {
        throw IllegalArgumentException()
    }

    for (index in playerInputMutableList.indices)
        if (playerInputMutableList[index] !in 1..9) {
            throw IllegalArgumentException()
        }
}

fun findStrike(computer: List<Int>, user: List<Int>): Int {
    var strikeCount = 0
    for (index in 0..2) {
        if (computer[index] == user[index])
            strikeCount++
    }
    return strikeCount
}

fun findBall(computer: List<Int>, user: List<Int>): Int {
    var ballCount = 0
    for (index in 0..2) {
        if (user[index] in computer)
            ballCount++
    }
    return ballCount
}

fun printResult(result: HashMap<String, Int>) {
    if (result["볼"] == 0 && result["스트라이크"] == 0)
        print("낫싱")
    if (result["볼"] != 0)
        print("${result["볼"]}볼 ")
    if (result["스트라이크"] != 0)
        print("${result["스트라이크"]}스트라이크")
    println("")
}