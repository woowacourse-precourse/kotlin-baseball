package baseball

class ComputerNumbers {
    private val computerNumberList: List<Int>
    init {
        computerNumberList = generate()
    }

    private fun generate():List<Int>{
        val computerNumbers = mutableListOf<Int>()
        for(i in 0 until BaseballSetting.DIGIT_NUMBER.number){
            computerNumbers.add(RandomNumberGenerator.generateNotDuplicatedNumber(computerNumbers))
        }
        return computerNumbers
    }

}