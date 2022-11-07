package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console as cs

fun main() {
    var guessing = true

    println("숫자 야구 게임을 시작합니다.")
    while(guessing){
        val computerNumber = createComputerNum()
        var gamePlaying = true

        while (gamePlaying){
            print("숫자를 입력해주세요:")
            val guessNumber = cs.readLine()
            isInputNumeric(guessNumber)
            val guessDigit = separateNumberIntoDigit(guessNumber)
            val countResult = countStrikeAndBall(computerNumber, guessDigit)
            val strike = countResult[0]
            val ball = countResult[1]

            gamePlaying = printScore(strike, ball)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val continueGame = cs.readLine()
        guessing = continueOrEndGame(continueGame)
    }
}


private fun createComputerNum() : List<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {  //순서대로 백의 자리, 십의 자리, 일의 자리
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return computerNum
}
private fun isInputNumeric(input:String){
    val regex = "[1-9][1-9][1-9]".toRegex()

    if(!input.matches(regex)){
        throw IllegalArgumentException("세 자리의 숫자만 입력가능합니다")
    }
}

private fun separateNumberIntoDigit(inputNum: String): List<Int>{
    val inputNumberList = inputNum.toList()
    val firstNum = inputNumberList[0].toString().toInt()
    val secondNum = inputNumberList[1].toString().toInt()
    val thirdNum = inputNumberList[2].toString().toInt()

    return listOf(firstNum,secondNum,thirdNum)
}

private fun countStrikeAndBall(computerNum:List<Int>, inputNum: List<Int>): List<Int>{
    var strike = 0
    var ball = 0

    if(computerNum.contains(inputNum[0])){
        if(computerNum[0]==inputNum[0]){
            strike += 1
        }
        if(computerNum[0]!=inputNum[0]){
            ball += 1
        }
    }

    if(computerNum.contains(inputNum[1])){
        if(computerNum[1]==inputNum[1]){
            strike += 1
        }
        if(computerNum[1]!=inputNum[1]){
            ball += 1
        }
    }

    if(computerNum.contains(inputNum[2])){
        if(computerNum[2]==inputNum[2]){
            strike += 1
        }
        if(computerNum[2]!=inputNum[2]){
            ball += 1
        }
    }
    return listOf(strike, ball)
}
private fun printScore(strike: Int, ball: Int): Boolean {
    if (strike == 0 && ball == 0) {
        println("낫싱")
    }
    if (strike > 0 && ball == 0) {
        println("${strike}스트라이크")
    }
    if (strike == 0 && ball > 0) {
        println("${ball}볼")
    }
    if (strike > 0 && ball > 0) {
        println("${ball}볼 ${strike}스트라이크")
    }

    if (strike == 3) {
        return false
    }

    return true
}
private fun continueOrEndGame(continueGame: String): Boolean {
    if (continueGame != "1" && continueGame != "2") {
        throw IllegalArgumentException("1 혹은 2만 입력가능합니다")
    }

    if (continueGame == "2") {
        return false
    }

    return true
}