package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    val baseballModel: BaseballModel = BaseballModel()
    with(baseballModel) {
        do {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()
            checkInputIsCorrect(userInput)
            checkBalls(userInput)
            setResultString()
            // 결과 값을 출력한다.
            isEndedCheck()
        } while (/* 끝났는지 체크 */)
    }
}


