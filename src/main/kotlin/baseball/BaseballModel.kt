package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {

    var strikeCnt = 0
    var ballCnt = 0
    private var computerNum: List<Int> = emptyList<Int>()
    var resultString = ""
    var isEnded = false
    val inputChecker: InputChecker = InputChecker()

    init {
        computerNum = makeRandomNum()
    }

    fun checkBalls(userInput: String) {
        userInput.forEachIndexed { idx, numStr ->
            val number = numStr.toNumber()
            if (number == computerNum[idx]) {
                strikeCnt++
                return@forEachIndexed
            }
            if (computerNum.contains(number)) {
                ballCnt++
            }
        }
    }

    fun setResultString() {
        if (strikeCnt == 0 && ballCnt == 0) {
            resultString = NOTHING_STR
            return
        }

        val strikeStr = if (strikeCnt > 0) "$strikeCnt" + STRIKE_STR else ""
        val ballStr = if (ballCnt > 0) "$ballCnt$BALL_STR " else ""
        resultString = "$ballStr$strikeStr"
    }

    fun isEndedCheck() {
        if (strikeCnt == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val userInput = Console.readLine()
            checkEndedNumber(userInput)
            if (userInput.first().toNumber() == 2) {
                isEnded = true
                return
            }
            reGame()
        }
        strikeCnt = 0
        ballCnt = 0
    }

    fun checkEndedNumber(userInput: String) = inputChecker.checkEndedNumber(userInput)
    fun checkBasballNumber(userNum: String) = inputChecker.checkBasballNumber(userNum)

    private fun reGame() {
        computerNum = makeRandomNum()
    }


    /** 3개의 각각 다른 랜덤 값 생성한다. */
    fun makeRandomNum(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.toList()
    }

    private fun Char.toNumber() = this.code - '0'.code

    companion object {
        const val STRIKE_STR = "스트라이크"
        const val BALL_STR = "볼"
        const val NOTHING_STR = "낫싱"
    }

}