package baseball

import camp.nextstep.edu.missionutils.Randoms
import utils.Constants.GAME_START_MESSAGE

fun main() {
    val game = Game()
    println(GAME_START_MESSAGE) // todo 프린트 클래스 사용
    do {
        val computer = getComputerRandomNumber()
        println(computer)
        val restart = game.start(computer)
    } while (restart)
}

fun getComputerRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber))
            computer.add(randomNumber)
    }
    return computer
}