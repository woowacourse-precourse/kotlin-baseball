package baseball

import camp.nextstep.edu.missionutils.Randoms

class ComputerNumbers {
    private val computerNumbers: List<Int>
    init {
        computerNumbers = generate()
    }

    private fun generate():List<Int>{
        val computerNumbers = mutableListOf<Int>()
        for(i in 0 until BaseballSetting.DIGIT_NUMBER.number){
            computerNumbers.add(RandomNumberGenerator.generateNotDuplicatedNumber(computerNumbers))
        }
        return computerNumbers
    }

}