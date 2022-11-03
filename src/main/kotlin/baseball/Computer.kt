package baseball

import camp.nextstep.edu.missionutils.Randoms

object Computer {
    val correctNumber = mutableListOf<Int>()
    fun getCorrectRandomNumber(){
        correctNumber.clear()
        while (correctNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!correctNumber.contains(randomNumber)) {
                correctNumber.add(randomNumber)
            }
        }
    }
}