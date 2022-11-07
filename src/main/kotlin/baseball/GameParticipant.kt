package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

interface Participant {
    fun input(): Any
}

class User : Participant {
    override fun input(): Any = Console.readLine()
}

class Computer : Participant {
    private fun computerRandomChoiceNumber(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    override fun input(): Any {
        return computerRandomChoiceNumber()
    }
}