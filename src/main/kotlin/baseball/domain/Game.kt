package baseball.domain

class Game(var strike: Int = 0, var ball: Int = 0) {

    private val computerNumber = mutableListOf<Int>()

    fun compare(userNumber: List<Int>) {
        userNumber.onEachIndexed { index, number ->
            if(number == computerNumber[index]) {
                strike += 1
            } else if(userNumber.contains(number)){
                ball += 1
            }
        }
    }
}
