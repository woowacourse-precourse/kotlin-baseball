package baseball.logic

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var number: IntArray

    init {
        number = generateRandomNum()
    }
    private fun generateRandomNum(): IntArray{
        val randomNumber = IntArray(3)
        randomNumber[0] = Randoms.pickNumberInRange(1, 9)

        for(i in 1 until 3)
            randomNumber[i] = notDuplicatedRandomPicker(randomNumber)
        return randomNumber
    }

    private fun notDuplicatedRandomPicker(randomNumber: IntArray): Int{
        while(true){
            val temp = Randoms.pickNumberInRange(1, 9)
            if (!randomNumber.contains(temp)){
                return temp
            }
        }
    }

}