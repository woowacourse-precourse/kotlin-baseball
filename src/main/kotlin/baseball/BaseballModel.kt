package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {

    private val inputChecker: InputChecker
    val ballResult: BallResult
    var computerNum: List<Int> = emptyList()
    var isEnded = false

    init {
        computerNum = makeRandomNum()
        ballResult = BallResult(strikeCnt = 0, ballCnt = 0)
        inputChecker = InputChecker()
    }

    fun calculateBalls(userInput: String) {
        checkBasballIsCorrectNumber(userInput)
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

    fun getResultString() = ballResult.makeResultString()

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

    fun clearGame() = ballResult.clear()

    fun checkEndedNumber(userInput: String) = inputChecker.checkEndedNumber(userInput)
    fun checkBasballIsCorrectNumber(userNum: String) = inputChecker.checkBasballNumber(userNum)

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