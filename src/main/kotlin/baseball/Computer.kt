package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var computerList = mutableListOf<Int>()
    fun makeComputerList(): MutableList<Int> {
        while (computerList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber)
            }
        }
        return computerList
    }
}