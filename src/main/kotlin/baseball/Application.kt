package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.Exception
import java.lang.IllegalArgumentException

private const val GAMESTART = 1
private const val GAMEEND = 2

fun main() {
    var userChoice = GAMESTART
    println("숫자 야구 게임을 시작합니다.")

    while (userChoice == GAMESTART) {
        userChoice = entireGame()
    }

    if (userChoice != GAMEEND) throw IllegalArgumentException()
    println("게임 종료")
}

fun entireGame(): Int {
    val computerNum: List<Int> = makeRandomNum()
    val userChoice: Int //게임 재시작 여부 1 or 2

    //println(computerNum)
    playUntilCorrect(computerNum)
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    try {
        userChoice = Console.readLine().toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

    return userChoice
}

fun playUntilCorrect(computerNum: List<Int>) { //정답을 맟줄때 까지 반복하는 함수
    var userNum: List<Int>
    var ballAndStrike: List<Int>
    var untilCorrect = true

    while (untilCorrect) { // 정답을 맞출 때까지 입력과 결과 추력을 반복한다.
        userNum = inputUserNum()

        ballAndStrike = getBallAndStrike(computerNum, userNum)
        untilCorrect = printBallAndStrike(ballAndStrike)
    }

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun getBallAndStrike(
    computerNum: List<Int>,
    userNum: List<Int>
): List<Int> {
    var ballCount: Int
    var strikeCount: Int
    val countList = mutableListOf<Int>() //볼과 스트라이크 값을 담을 리스트

    ballCount = getBall(computerNum, userNum)
    strikeCount = getStrike(computerNum, userNum)

    //ballCount에는 스트라이크인 경우도 count되어 있기 때문에 strikeCount만큼 빼줘야 한다.
    ballCount -= strikeCount

    countList.add(ballCount)
    countList.add(strikeCount)

    return countList
}

fun getBall(
    computerNum: List<Int>,
    userNum: List<Int>
): Int {
    var ballCount = 0
    for (idx in userNum.indices) { //입력한 숫자 사이즈인 3번 반복한다.
        if (computerNum.contains(userNum[idx])) { //해당 숫자를 위치상관없이 포함한다면 볼카운트 1증가
            ballCount += 1
        }
    }
    return ballCount
}

fun getStrike(
    computerNum: List<Int>,
    userNum: List<Int>
): Int {
    var strikeCount = 0
    for (idx in userNum.indices) {
        if (userNum[idx] == computerNum[idx]) { //각 자리수가 정확히 일치할 때만 스트라이크 카운트 1증가
            strikeCount += 1
        }
    }
    return strikeCount
}

fun printBallAndStrike(ballAndStrike: List<Int>): Boolean {
    var ballCount = ballAndStrike[0]
    var strikeCount = ballAndStrike[1]

    if (ballAndStrike.contains(0)) { //볼과 스트라이크 중 0이 있을 때
        if (ballCount != 0) {
            println("${ballCount}볼")
        }
        if (strikeCount != 0) {
            println("${strikeCount}스트라이크")
        }
        if (ballCount == 0 && strikeCount == 0) {
            println("낫싱")
        }
    } else { //n볼 m 스트라이크인 경우 n,m>0
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }

    return strikeCount != 3 //3스트라이크인 경우 false를 리턴한다다


}

fun makeRandomNum(): List<Int> {
    val computerNum = mutableListOf<Int>()

    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return computerNum
}


fun isValidNum(answer: Int): Boolean { //사용자 입력 검사 함수
    var answerList = answer.toString().toList()

    if (!(answer is Int)) {
        return false
    }
    if (answer <= 0) {
        return false
    }
    if (answer.toString().length != 3) {
        return false
    }
    if (answerList.contains('0')) {
        return false
    }
    if (answerList.distinct().size != 3) {
        return false
    }

    return true
}

fun inputUserNum(): List<Int> { //사용자가 숫자 입력하는 함수
    var answer: Int
    val answerList = mutableListOf<Int>()
    var divideNum = 100
    print("숫자를 입력해주세요 : ")
    try {
        answer = Console.readLine()!!.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

    if (!isValidNum(answer)) throw IllegalArgumentException()

    //각 자리수를 리스트에 담는다.
    for (divideTime in 1..3) {
        answerList.add(answer / divideNum)
        answer %= divideNum
        divideNum /= 10
    }

    return answerList //List<Int>형식으로 리턴
}


