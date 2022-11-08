package baseball.user

import camp.nextstep.edu.missionutils.Console

fun inputUserNumber(): String {
    print("숫자를 입력해주세요 : ")

    val userInputNumber = Console.readLine()
    checkInputUserNumber(userInputNumber)

    return userInputNumber.toString()
}

fun setUpGameOver(strike: Int): String? {

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val userInputGameOverMessage = Console.readLine()

        checkInputGameOverMessage(userInputGameOverMessage)
        println(userInputGameOverMessage)

        return userInputGameOverMessage
    }
    return null
}
