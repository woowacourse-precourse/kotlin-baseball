package baseball

import baseball.BallResult.Companion.NOTHING_STR
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {

    private val inputChecker: InputChecker = InputChecker()
    val ballResult: BallResult = BallResult(0, 0)
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
                ballResult.strikeCnt++
                return@forEachIndexed
            }
            if (computerNum.contains(number)) {
                ballResult.ballCnt++
            }
        }
    }

    fun setResultString() {
        if (ballResult.isNothing()) {
            resultString = NOTHING_STR
            return
        }
        val strikeStr = ballResult.makeStrikeStr()
        val ballStr = ballResult.makeBallStr()
        val space = ballResult.makeSpace()
        resultString = ballStr + space + strikeStr
    }

    fun isEndedCheck() {
        if (ballResult.isOut()) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val userInput = Console.readLine()
            checkEndedNumber(userInput)
            if (userInput.first().toNumber() == END) {
                isEnded = true
                return
            }
            reGame()
        }
        clearGame()
    }

    fun clearGame() {
        ballResult.clear()
        resultString = ""
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
        const val END = 2
    }

}