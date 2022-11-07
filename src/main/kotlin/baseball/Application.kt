package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.security.KeyStore.TrustedCertificateEntry

fun subMain() {
    val computerNum = pickRandomNums()
    var input = inputNum()
    rightInputCheck(input)
    var result = checkStrikeBallNothing(input, computerNum)
    while (result) { // 3스트라이크가 나올 때까지 반복문
        input = inputNum()
        rightInputCheck(input)
        result = checkStrikeBallNothing(input, computerNum)
    }
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun pickRandomNums(): MutableList<String> {
    val computer = mutableListOf<String>() //Changed Char to String for better compare
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputNum(): String {
    print("숫자를 입력해주세요 : ")
    val inputNum: String = Console.readLine()!!.toString()
    for(i in inputNum.indices){
        if(inputNum[i] !in "123456789"){
            throw IllegalArgumentException("1~9사이의 값이 아닙니다.")
        }
    }
    return inputNum
}

fun rightInputCheck(num: String) {
    if (num.length != 3) {
        throw IllegalArgumentException("서로 다른 세자리 숫자를 말씀해주세요.")
    }
    // 추가적인 예외처리, 서로 다른 수를 사용자가 입력하지 않은 경우 방지
    for (i in 0 until (num.length) - 1) {
        if (num[i] == num[i + 1]) {
            throw IllegalArgumentException("서로 다른 세자리 숫자를 말씀해주세요.")
        }
    }
    if (num[0] == num[2])
        throw IllegalArgumentException("서로 다른 세자리 숫자를 말씀해주세요.")
}

fun checkStrikeBallNothing(inputNum: String, computerNum: MutableList<String>): Boolean {
    // 게임 종료 조건부터 체크 (3 strike)
    var pickRandomNumsResult = ""
    for (pickRandomNum in computerNum) {
        pickRandomNumsResult += pickRandomNum
    }
    if (pickRandomNumsResult == inputNum) {
        return false
    }

    // 게임 종료가 아닐 경우 낫싱 -> 스트라이크 -> 볼 순으로 구분
    var numForNothing: Int = 0
    for (index in inputNum.indices) {
        if (!computerNum.contains(inputNum[index].toString())) {
            numForNothing += 1
        }
    }
    if (numForNothing == 3) {
        println("낫싱")
        print("숫자를 입력해주세요 : ")
        return true
    }

    // 스트라이크 -> 볼
    val avoidList = mutableListOf<Int>(0, 1, 2)
    var ballNum = 0
    var strikeNum = 0
    for (i in inputNum.indices) { // 스트라이크부터 먼저 체크하고 제거하기
        if (inputNum[i].toString() == computerNum[i]) {
            strikeNum += 1
            avoidList.remove(i)
        }
    }
    for (j in avoidList) { // 남은 것에서 볼 체크하기
        if (computerNum.contains(inputNum[j].toString())) {
            ballNum += 1
        }
    }

    // print
    if (strikeNum != 0 && ballNum != 0) {
        println("${ballNum}볼 ${strikeNum}스트라이크")
    } else if (strikeNum == 0 && ballNum != 0) {
        println("${ballNum}볼")
    } else {
        println("${strikeNum}스트라이크")
    }
    print("숫자를 입력해주세요 : ")
    return true
}

fun gameRestartCheck(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()!!.toString()) {
        "1" -> {
            true
        }
        "2" -> {
            false
        }
        else -> {
            throw IllegalArgumentException("1 혹은 2 숫자를 입력해주세요")
        }
    }
}

fun main() {
    var flag: Boolean = true
    println("숫자 야구 게임을 시작합니다.")
    while(flag) { // 최종적으로 1과 2일 때 반복을 위한 while문
        subMain()
        flag = gameRestartCheck()
    }
}

