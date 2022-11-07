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
        TODO("사용자 인풋에 따른 스트라이크 볼 체크")
    }

    fun setResultString() {
        TODO("결과 값 생성")
    }

    fun isEndedCheck() {
        TODO("게임이 끝났는지 체크")
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