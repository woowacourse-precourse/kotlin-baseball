package baseball.model

import baseball.view.InputView

class Player(private val computerNumbers: List<Int>) {
    private val inputNumbers = InputView().readNumbers()
    fun guess(): HashMap<String, Int> {
        val strikeCount = findStrike()
        val ballCount = findBall() - strikeCount
        return hashMapOf(Pair("Strike",strikeCount),Pair("Ball",ballCount))
    }

    private fun findBall():Int {
        var ball = 0
        for(index in 0..2){
            if(inputNumbers[index] in computerNumbers)
                ball ++
        }
        return ball
    }

    private fun findStrike():Int{
        var strike = 0
        for (index in 0..2){
            if(inputNumbers[index] == computerNumbers[index])
                strike ++
        }
        return strike
    }

}