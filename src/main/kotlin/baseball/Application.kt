package baseball

import camp.nextstep.edu.missionutils.*

const val RESTART = 1
const val IN_GAME = 3
val applicationService = ApplicationService
val view = View

fun main() {
    playBaseballGame()
}

fun playBaseballGame() {
    view.showGameStart()
    var gameStatusFlag = IN_GAME
    var createdNumbers = applicationService.createRandomNumber()
    do {
        if (gameStatusFlag == RESTART) {
            createdNumbers = applicationService.createRandomNumber()
        }
        val loopFlag = DomainService.inGame(createdNumbers)
        gameStatusFlag = loopFlag.first
    } while (loopFlag.second)
}








