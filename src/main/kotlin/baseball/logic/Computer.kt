package baseball.logic

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var number: IntArray

    init {
        number = generateRandomNum()
    }
    private fun generateRandomNum(): IntArray{
        val randomNumber = IntArray(3)
        for(i in 0 until 3)
            randomNumber[i] = Randoms.pickNumberInRange(1, 9)
        return randomNumber
    }
}