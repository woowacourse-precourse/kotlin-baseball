package baseball

class Ball {

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 9
    }

    val number : Int
    val position : Int

    constructor(number: Int, position: Int) {

        if(number < MIN_NUM || number > MAX_NUM) {
            throw IllegalArgumentException("1에서 9사이의 숫자여야 합니다.")
        }

        this.number = number
        this.position = position
    }

    fun playGame(user : Ball) : Result = when {
            this.equals(user) -> Result.STRIKE
            this.checkBall(user.number) -> Result.BALL
            else -> Result.NOTHING
        }


    fun checkBall(ballNum : Int) : Boolean = this.number == ballNum


    override fun equals(other: Any?): Boolean = when(other) {
        is Ball -> other.number == this.number && other.position == this.position
        else -> false
    }
}