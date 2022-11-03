package baseball

class Balls {

    val balls : List<Ball>

    constructor(ballList: String) {

        if(ballList.length > 3) {
            throw IllegalArgumentException("입력한 숫자야구 길이가 3보다 깁니다.")
        }

        val balls = ballList.mapIndexed { index, c -> Ball(c.toInt(), index + 1) }
        this.balls = balls
    }

    fun playGame(ballList : String) : List<String> {
        val userInput = Balls(ballList)
        val resultList = mutableListOf<String>()

        balls.forEach {
            val result = userInput.playGame(it)
            resultList.add(result)
        }
        return resultList
    }

    fun playGame(ball : Ball) : String {
        balls.forEach{
            if(!it.playGame(ball).equals("Nothing"))
                return it.playGame(ball)
        }
        return "Nothing"
    }
}