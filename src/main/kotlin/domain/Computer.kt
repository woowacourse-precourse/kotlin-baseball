package domain

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun makeRandomList() : List<Int>{
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}