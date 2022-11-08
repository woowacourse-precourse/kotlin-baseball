package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}

fun playGame() {
    val answer = getComputerNumber()
    println(answer)
    startGuessing(answer)
}

// 컴퓨터의 랜덤 숫자 생성
fun getComputerNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun startGuessing(answer: String) {
    var input = getUserNumber()
    while(input != answer){
        printHint(input, answer)
        input = getUserNumber()
    }
    gameOver()
}

fun getUserNumber(): String {
    print("숫자를 입력해주세요: ")
    val input = readLine()!!

    // 3자리 수가 아닌 경우
    if (input.length != 3)
        throw IllegalArgumentException()

    // 1~9까지의 범위를 벗어난 경우
    for (item in input) {
        if (item.digitToInt() !in 1..9)
            throw IllegalArgumentException()
    }

    // 서로 다른 수가 아닌 경우
    if(input[0] == input[1] || input[0] == input[2] || input[1] == input[2])
        throw IllegalArgumentException()

    return input
}

// 스트라이크, 볼, 낫싱 결과 출력
fun printHint(input: String, answer: String) {
    var strike = 0
    var ball = 0

    for(i in answer.indices){
        if(input[i] == answer[i]) strike++
        else if(input.contains(answer[i])) ball++
    }

    if (strike != 0 && ball != 0) {
        println("${ball}볼 ${strike}스트라이크")
    } else {
        if (strike != 0) println("${strike}스트라이크")
        else if (ball != 0) println("${ball}볼")
        else println("낫싱") // 같은 숫자가 아예 없으면 낫싱
    }
}

fun gameOver() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when(readLine()!!.toInt()) {
        1 -> playGame() // 새로운 랜덤 숫자 생성
        2 -> return // 완전히 종료
        else -> throw IllegalArgumentException()
    }
}
