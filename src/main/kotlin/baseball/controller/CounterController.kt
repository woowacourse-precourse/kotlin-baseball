package baseball.controller

import baseball.model.BaseBall

class CounterController(computerNumbers: List<Int>, playerNumbers: List<Int>) {
    private val baseBall = BaseBall(computerNumbers, playerNumbers)

    val strike = baseBall.getStrikeCount()
    val ball = baseBall.getBallCount()
}