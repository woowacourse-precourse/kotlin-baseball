package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = Game()
    val display = Display()
    display.printGameStart()

    do {
        val computer = getComputerRandomNumber()
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