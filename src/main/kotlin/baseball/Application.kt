package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val input = inputNum()
    rightInputCheck(input)
    val computerNum = pickRandomNums()
    val result = checkStrikeBallNothing(input, computerNum)
    while(result)
    {
        val input = inputNum()
        val result = checkStrikeBallNothing(input, computerNum)
    }
    println("result: $result")
}

fun pickRandomNums(): MutableList<String> {
    val computer = mutableListOf<String>() //Changed Char to String for better compare
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return computer
}

fun inputNum(): String {
    val inputNum: String = Console.readLine()
    return inputNum
}

fun rightInputCheck(num: String) {
    val inputNum = num
    if (num.length != 3){
        throw IllegalArgumentException("세자리 숫자를 말씀해주세요.")
    }
    println("length check success")
}

fun checkStrikeBallNothing(inputNum: String, computerNum: MutableList<String>): Boolean {
    // 게임 종료 조건부터 체크 (3 strike)
    var pickRandomNumsResult = ""
    for (pickRandomNum in computerNum) {
        pickRandomNumsResult += pickRandomNum
    }
    if(pickRandomNumsResult == inputNum) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        gameRestartCheck(inputNum())
        return false
    }

    // 게임 종료가 아닐 경우 낫싱 -> 스트라이크 -> 볼 순으로 구분
    for (index in inputNum.indices) {
        if (computerNum.contains(inputNum[index].toString())) {
            var strikeNum = 0
            var ballNum = 0
            for (i in inputNum.indices) { // 스트라이크부터 먼저 체크하고 제거하기
                if (inputNum[i].toString() == computerNum[i]) {
                    strikeNum += 1
                    computerNum.removeAt(i)
                    inputNum.replace("${inputNum[i]}", "")
                }
            }
            for (j in inputNum.indices) { // 남은 것에서 볼 체크하기
                if (computerNum.contains(inputNum[j].toString())) {
                    ballNum += 1
                }
            }
            if (strikeNum != 0 && ballNum != 0) {
                println("${ballNum}볼 ${strikeNum}스트라이크")
//                    return "${ballNum}볼 ${strikeNum}스트라이크"
            } else if (strikeNum == 0 && ballNum != 0) {
                println("${ballNum}볼")
//                    return "${ballNum}볼"
            } else {
                println("${strikeNum}스트라이크")
//                    return "${strikeNum}스트라이크"
            }
        }
        println("낫싱")
//            return "낫싱"
    }
    println("숫자를 입력해주세요")
    // return "숫자를 입력해주세요"
    return true
}

fun gameRestartCheck(selectionNum: String){
    when (selectionNum) {
        "1" -> {
            main()
        }
        "2" -> {
            throw SecurityException()
        }
        else -> {
            throw IllegalArgumentException("1 혹은 2 숫자를 입력해주세요")
        }
    }
}
