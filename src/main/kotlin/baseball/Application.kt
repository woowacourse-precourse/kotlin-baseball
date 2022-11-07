package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playNumberBaseballGame()
}

fun playNumberBaseballGame(){
    val answerNumberArray= makeAnswerNumber()
}

fun makeAnswerNumber():List<Int>{
    val answerNumberArray = mutableListOf<Int>()
    while (answerNumberArray.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answerNumberArray.contains(randomNumber)) {
            answerNumberArray.add(randomNumber)
        }
    }
    return answerNumberArray
}

fun checkValidNumber(num: List<Int>):Boolean{

    if(num.distinct().size != 3)
        return false

    for (n in num){
        if(n<1 || n>9)
            return false
    }
    return true
}
