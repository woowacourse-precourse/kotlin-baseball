package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    val baseballModel: BaseballModel = BaseballModel()
    println("숫자 야구 게임을 시작합니다.")
    with(baseballModel) {
        do {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()
            calculateBalls(userInput)
            println(getResultString())
            isEndedCheck()
        } while (!isEnded)
    }
}


