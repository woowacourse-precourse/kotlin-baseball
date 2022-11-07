package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val com = getComInput()
    println("숫자 야구 게임시작합니다")
    var exitFlag = false
    while (!exitFlag) {
        exitFlag = startBaseballGame(com)
    }
    println("게임 종료")
}

fun startBaseballGame(com: List<Int>): Boolean {

    val user = getUserInput().map { it - '0' }.toList()
    if(user.isEmpty()){
        return true
    }
    var strikeCnt = 0
    var ballCnt = 0

    for (i in user.indices) {
        when (checkBallOrStrike(i, user[i], com)) {
            "Strike" -> strikeCnt++
            "Ball" -> ballCnt++
            else -> {}
        }
    }
    when(val message = displayResult(strikeCnt, ballCnt)){
        "Nothing"->{
            println("낫싱")
        }
        "Finish"->{
            println("3 스트라이크")
            // 종료 재시작 로직 추가 필요
            return true
        }
        else -> println(message)
    }

    return false
}

fun displayResult(strikeCnt:Int, ballCnt:Int):String{
    return if(strikeCnt==0 && ballCnt==0) {
        "Nothing"
    }
    else if(strikeCnt==3) {
        "Finish"
    }
    else {
        "${ballCnt}볼 ${strikeCnt}스트라이크"
    }
}

fun checkBallOrStrike(i: Int, num: Int, com: List<Int>): String {
    for (j in com.indices) {
        return if (com[j] == num && j == i) {
            "Strike"
        } else if (com[j] == num) {
            "Ball"
        } else continue
    }
    return "Nothing"
}

fun getComInput(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInput(): String {
    print("숫자를 입력해주세요: ")
    val input = Console.readLine()
    try{
        userInputValidation(input)
    }catch (e: java.lang.IllegalArgumentException){
        return ""
    }
    return input

}

fun userInputValidation(input: String): Boolean {
    if (checkIncludeZero(input) || checkInputLength(input) || checkDuplicateNum(input)) {
        throw IllegalArgumentException()
    }
    return true
}

fun checkIncludeZero(input: String): Boolean {
    return input.contains("0")
}

fun checkInputLength(input: String): Boolean {
    return (input.length != 3)
}

fun checkDuplicateNum(input: String): Boolean {
    return (input.toList().distinct().size != 3)
}