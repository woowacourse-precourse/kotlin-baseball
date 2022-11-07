package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {

    private var strikeCnt = 0
    private var ballCnt = 0
    var computerNum: List<Int> = emptyList<Int>()
    var resultString = ""
    var isEnded = false

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
            val regex = Regex("[1-2]{1}")
            val userInput = Console.readLine()
            require(userInput.matches(regex)) {
                "1또는 2를 입력해 주세요."
            }
            if (userInput.first().toNumber() == 2) {
                isEnded = true
                return
            }
            reGame()
        }
        strikeCnt = 0
        ballCnt = 0
    }

    private fun reGame() {
        computerNum = makeRandomNum()
    }

    fun checkInputIsCorrect(userNum: String) {
        val regex = Regex("[0-9]{3}")
        require(userNum.matches(regex)) {
            "$userNum 3자리가 아니거나, 숫자가 아닌 값"
        }
        require(userNum.toCharArray().distinct().size == 3) {
            "$userNum 각각 다른 3자리 숫자가 아님"
        }
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