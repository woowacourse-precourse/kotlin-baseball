package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

// 경기 진행 함수
fun startGame() {
    val computerNum = randomNumber()
    while(true){
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
    if(player.length!=3
        ||player[0].digitToInt() !in 1..9
        ||player[1].digitToInt() !in 1..9
        ||player[2].digitToInt() !in 1..9
        ||player[0]==player[1]
        ||player[1]==player[2]
        ||player[2]==player[0])
        throw IllegalArgumentException("Wrong Input Value")
}


// 결과 확인 기능
fun checkResult(computerNum: MutableList<Int>, playerNum: MutableList<Int>): Int {
    var strikeCount = checkStrike()
    var ballCount = checkBall()
    return resultOutput(strikeCount, ballCount)

}
// 스트라이크 확인 기능
fun checkStrike(): Int {

}

// 볼 확인 기능
fun checkBall(): Int {

}

// 비교 결과 출력 기능
fun resultOutput(strikeCount: Int, ballCount: Int): Int {

}

// 게임 종료 기능
fun endGame(): Int {

}


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var result = 1
    while(result == 1){
        startGame()
        result = endGame()
    }

}
