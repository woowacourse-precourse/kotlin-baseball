package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
}

class Computer() {
    private val _computerNumbers = mutableListOf<Int>()
    val computerNumbers: List<Int> get() = _computerNumbers

    fun createComputerNumbers() {
        _computerNumbers.clear()
        while (_computerNumbers.size < 3) {
            val randomNumber: Int = createNumberInRange()
            if (isNumberRepeated(randomNumber)) {
                _computerNumbers.add(randomNumber)
            }
        }
    }

    private fun createNumberInRange(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }

    private fun isNumberRepeated(randomNumber: Int): Boolean {
        return (!_computerNumbers.contains(randomNumber))
    }
}

class Printer() {
    fun showStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun showInputMessage() {
        print("숫자를 입력해주세요 : ")
    }

    fun showStrikeMessage(strikeCount: Int) {
        println("${strikeCount}스트라이크")
    }

    fun showBallMessage(ballCount: Int) {
        println("${ballCount}볼")
    }

    fun showNothingMessage() {
        println("낫싱")
    }

    fun showBallStrikeMessage(ballCount: Int, strikeCount: Int) {
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }

    fun showEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}