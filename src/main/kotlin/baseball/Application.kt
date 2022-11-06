package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
//    val input = inputNum()
//    rightInputCheck(input)
//    val computerNum = pickRandomNums()
}

fun pickRandomNums(): MutableList<Char> {
    val computer = mutableListOf<Char>() //Changed Int to Char for better compare
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toChar()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println("computer: $computer")
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

fun checkStrikeBallNothing(inputNum: String): String {
    // 게임 종료 조건부터 체크 (3 strike)
    var pickRandomNumsResult = ""
    for (pickRandomNum in pickRandomNums()) {
        pickRandomNumsResult += pickRandomNum
    }
    if(pickRandomNumsResult == inputNum) {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }

    // 게임 종료가 아닐 경우 낫싱 -> 스트라이크 -> 볼 순으로 구분
    for(index in inputNum.indices){
        if (pickRandomNums().contains(inputNum[index])){
            var strikeNum = 0
            var ballNum = 0
            for(i in inputNum.indices){ // 스트라이크부터 먼저 체크하고 제거하기
                if (inputNum[i] == pickRandomNums()[i]) {
                    strikeNum += 1
                    pickRandomNums().removeAt(i)
                    inputNum.replace("${ inputNum[i] }","")
                }
            }
            for(j in inputNum.indices){ // 남은 것에서 볼 체크하기
                if(pickRandomNums().contains(inputNum[j])) {
                    ballNum += 1
                }
            }
            if(strikeNum != 0 && ballNum != 0){
                return "{$ballNum}볼 {$strikeNum}스트라이크"
            }
            else if(strikeNum == 0 && ballNum != 0){
                return "{$ballNum}볼"
            }
            else {
                return "{$strikeNum}스트라이크"
            }
        }
        return "낫싱"
    }
    return "숫자를 입력해주세요"
}
