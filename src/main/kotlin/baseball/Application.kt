package baseball

import camp.nextstep.edu.missionutils.Randoms

const val INPUT_LENGTH_STANDARD = 3
const val GAME_CLEAR = 3
const val USER_WANT_PLAY_AGAIN = 1
const val USER_DONT_WANT_PLAY_AGAIN = 2
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9

fun main() {
    startGameAtFirst()
}

private fun startGameAtFirst() {
    println("숫자 야구 게임을 시작합니다.")

}

private fun getRandomNumberList() {
    val randomList = mutableListOf<Int>()
    while (randomList.size < INPUT_LENGTH_STANDARD) {
        val newRandomNum = getEachRandomNumber()
        randomList.add(newRandomNum)
    }
}

private fun getEachRandomNumber(): Int {
    return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
}
