package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStart()
    return
}

private fun gameStart() {
    while (true) {
        playNumBaseBall()
    }
}

private fun playNumBaseBall() {
    var com: String = makeRandomNumber()
    println(com)
}

private fun makeRandomNumber(): String {
    var com: String

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    com = "${computer[0]}${computer[1]}${computer[2]}"

    return com
}
