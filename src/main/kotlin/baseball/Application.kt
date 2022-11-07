package baseball

import camp.nextstep.edu.missionutils.Randoms
import utils.Constants.GAME_START_MESSAGE

fun main() {
    val game = Game()
    var restart = true
    println(GAME_START_MESSAGE) // todo 프린트 클래스 사용
    while (restart) {
        val computer = getComputerRandomNumber()
        println(computer)
        restart = game.start(computer)
    }
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