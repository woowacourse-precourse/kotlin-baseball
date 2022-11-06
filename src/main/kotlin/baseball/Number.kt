package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Number {
    fun getComputerNum(): String {
        val computerNumList = mutableListOf<Int>()
        var computerNum = ""

        while (computerNumList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber)
            }
        }

        computerNumList.forEach {
            computerNum = computerNum.plus(it)
        }

        return computerNum
    }

    fun getPlayerNum(): String {
        print("숫자를 입력해주세요 : ")
        var playerNum = Console.readLine()
        checkNum(playerNum)
        return playerNum
    }
}