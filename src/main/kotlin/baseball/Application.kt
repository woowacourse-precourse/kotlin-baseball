package baseball

import camp.nextstep.edu.missionutils.Randoms

// 경기 진행 함수
fun startGame() {
    val computerNum = randomNumber()
    while (true) {
        var playerNum = randomNumberInput()
        var result = checkResult(computerNum, playerNum)
        if (result == 1) break
    }
}

// 서로 다른 임의의 수 3개 선택 기능
fun randomNumber(): MutableList<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

// 서로 다른 3개의 숫자 입력받는 기능
fun randomNumberInput(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    var player: String = readLine()!!
    var playerNum = mutableListOf<Int>()
    exceptionHandling(player)
    for (i in 0..2)
        playerNum.add(player[i].digitToInt())
    return playerNum
}

// 잘못된 값을 입력할 경우 예외 처리 기능
fun exceptionHandling(player: String) {
    var list = player.toList()
    if (list.size != 3
        || list.distinct().size != 3
        || list.all { it !in '1'..'9' }
    )
        throw IllegalArgumentException("Wrong Input Value")
}


// 결과 확인 기능
fun checkResult(computerNum: MutableList<Int>, playerNum: MutableList<Int>): Int {
    var strikeCount = checkStrike(computerNum, playerNum)
    var ballCount = checkBall(computerNum, playerNum)
    return resultOutput(strikeCount, ballCount)

}

// 스트라이크 확인 기능
fun checkStrike(computerNum: MutableList<Int>, playerNum: MutableList<Int>): Int {
    var strikeCount = 0
    for (i in 0..2) {
        if (computerNum[i] == playerNum[i])
            strikeCount++
    }
    return strikeCount
}

// 볼 확인 기능
fun checkBall(computerNum: MutableList<Int>, playerNum: MutableList<Int>): Int {
    var ballCount = 0
    for (i in 0..2) {
        if (computerNum[i] != playerNum[i] && computerNum.contains(playerNum[i]))
            ballCount++
    }
    return ballCount
}

// 비교 결과 출력 기능
fun resultOutput(strikeCount: Int, ballCount: Int): Int {
    val message = if (strikeCount == 0 && ballCount == 0) "낫싱"
    else if (strikeCount == 0) "${ballCount}볼"
    else if (ballCount == 0) "${strikeCount}스트라이크"
    else "${ballCount}볼 ${strikeCount}스트라이크"

    print(message)

    if (strikeCount == 3) return 1
    return 0
}

// 게임 종료 선택 기능
fun endGame(): Int {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var endResult = readLine()!!
    return endResult[0].digitToInt()
}


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var result = 1
    while (result == 1) {
        startGame()
        result = endGame()
    }

}
