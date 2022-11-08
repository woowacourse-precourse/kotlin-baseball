package baseball

import baseball.domain.Computer
import baseball.domain.Player
import baseball.util.RandomGenerate

fun main() {
    val computer = Computer(RandomGenerate())
    val player = Player()
    BaseballGame(computer, player).run()
}
