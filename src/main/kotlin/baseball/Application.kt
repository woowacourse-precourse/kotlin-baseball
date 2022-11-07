package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startBaseBallGame()

}


private fun startBaseBallGame() {
    println("숫자 야구 게임을 시작합니다.")
    val computerRandomNumber = computerSelectThreeRandomNumber()
    println(computerRandomNumber)
}


private fun computerSelectThreeRandomNumber(): List<Int> {
    val computerList = mutableListOf<Int>()
    while (computerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerList.contains(randomNumber)) computerList.add(randomNumber)
    }
    return computerList
}