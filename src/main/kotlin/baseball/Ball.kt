package baseball

class Ball {

    var number : Int
    var position : Int

    constructor(number: Int, position: Int) {

        if(number < 1 || number > 9) {
            throw IllegalArgumentException("1에서 9사이의 숫자여야 합니다.")
        }
        this.number = number
        this.position = position
    }

    fun playGame(user : Ball) : String {
        when {
            this.equals(user) -> {
                return "Strike"
            }

            this.checkBall(user.number) -> {
                return "Ball"
            }

            else -> return "Nothing"
        }
    }

    fun checkBall(ballNum : Int) : Boolean = this.number == ballNum


    override fun equals(other: Any?): Boolean {
        if(other is Ball) return other.number == this.number && other.position == this.position
        return false
    }
}