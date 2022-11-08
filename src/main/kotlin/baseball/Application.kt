package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        // TODO()
        println("숫자 야구 게임을 시작합니다.")
        val computerNum = getComputerInput()
        startGame(computerNum)
        if(getEndloopCondition()) break
    }
}

fun startGame(computerNum: String) {
    while(true){
        val userNum = getUserInput()
        val strike = getStrike(computerNum, userNum)
        val ball = getBall(computerNum, userNum)
        printScore(strike, ball)
        if(strike == 3) break
    }
}

fun printScore(strike: Int, ball: Int) {
    when{
        strike == 3 -> println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        ball == 0 && strike == 0 -> println("낫싱")
        ball != 0 && strike == 0 -> println("${ball}볼")
        ball == 0 && strike != 0 -> println("${strike}스트라이크")
        else -> println("${ball}볼 ${strike}스트라이크")
    }
}

fun getBall(computerNum: String, userNum: String): Int {
    var ball = 0
    for(i in 0..2){
        if (computerNum.contains(char = userNum[i]) && computerNum[i] != userNum[i]) ball++
    }
    return ball
}

fun getStrike(computerNum: String, userNum: String): Int {
    var strike = 0
    for(i in 0..2){
        if(computerNum[i] == userNum[i]) strike++
    }
    return strike
}

fun getComputerInput(): String {
    var ComputeNum = ""
    while(ComputeNum.length < 3){
        val num = Randoms.pickNumberInRange(1, 9)
        if(!ComputeNum.contains(num.toString())) ComputeNum.plus(num.toString())
    }
    return ComputeNum
}

fun isValidateInput(userNum: String): String {
    if(userNum.length != 3) {
        throw IllegalArgumentException("3자리의 숫자를 입력해주세요")
    }
    if(userNum.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }
    if(userNum[0] == userNum[1] || userNum[0] == userNum[2] || userNum[1] == userNum[2]) {
        throw IllegalArgumentException("중복된 값이 있습니다.")
    }
    if(userNum.contains(char = '0')) {
        throw IllegalArgumentException("0은 입력할 수 없습니다.")
    }
    return userNum
}

fun getUserInput(): String {
    println("숫자를 입력해주세요 : ")
    return isValidateInput(Console.readLine())
}

fun getEndloopCondition(): Boolean {
    val input = Console.readLine()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when (input) {
        "1" -> return false
        "2" -> return true
        else -> throw IllegalArgumentException("1 또는 2를 입력해주세요.")
    }
}