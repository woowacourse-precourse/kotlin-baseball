package model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun makeRandomNumber(): String {
        var com: String

        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        com = "${computer[0]}${computer[1]}${computer[2]}"

        return com
    }
}