package baseball.model

class BaseballMaker (private val randomNumberGenerator: RandomNumberGenerator){
    fun makeBaseball():List<Int>{
        var baseBall = mutableListOf<Int>()
        for (index in 0..2){
            val number = randomNumberGenerator.generate()
            baseBall.add(number)
        }
        return baseBall
    }
}