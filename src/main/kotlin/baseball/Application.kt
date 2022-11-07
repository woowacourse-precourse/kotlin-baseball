package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    val baseballModel: BaseballModel = BaseballModel()
    with(baseballModel) {
        do {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()
            checkBasballNumber(userInput)
            checkBalls(userInput)
            println(getResultString())
            isEndedCheck()
        } while (!isEnded)
    }
}


