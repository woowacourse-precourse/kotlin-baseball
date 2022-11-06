package baseball

class Balls {
    companion object {
        const val LIMIT_BALL_LIST_SIZE = 3
    }

    val balls : List<Ball>

    constructor(ballList: String) {

        if(ballList.length > LIMIT_BALL_LIST_SIZE) {
            throw IllegalArgumentException("입력한 숫자야구 길이가 3보다 깁니다.")
        }

        this.balls = mapBallList(ballList)
    }

    fun mapBallList(ballList: String) : List<Ball>  = ballList.mapIndexed { index, c ->  Ball(c.toInt() - '0'.toInt(), index + 1)}

    fun playGame(ballList : String) : GameResult {
        val userInput = Balls(ballList)
        val gameResult = GameResult()

        balls.forEach {
            val result = userInput.playGame(it)
            gameResult.setResult(result)
        }
        return gameResult
    }

    fun playGame(ball : Ball) : Result {
        balls.filterNot { it.playGame(ball).equals(Result.NOTHING) }
            .forEach{ return it.playGame(ball) }
        return Result.NOTHING
    }
}