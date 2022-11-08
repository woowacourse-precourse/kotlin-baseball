package baseball

import baseball.process.BaseballGameProcessor

fun main() {
    val baseballGameProcessor = BaseballGameProcessor(User(), Computer())
    baseballGameProcessor.processBaseballGame()
}
