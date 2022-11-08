package baseball.game

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Provider {

    fun pickRandomNumber(): String {
        val computer = mutableListOf<Int>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        return computer.joinToString("")
    }

    fun readLine(): String {
        return Console.readLine().also {
            println(it)
        }
    }
}