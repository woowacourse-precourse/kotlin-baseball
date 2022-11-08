package baseball

import camp.nextstep.edu.missionutils.Randoms

class GamePlay {
    fun baseballGameStart() {
        val computerNum = setComputerNum()
        compareUserNumAndComputerNum(computerNum)
    }

    private fun setComputerNum(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    private fun compareUserNumAndComputerNum(computer: List<Int>) {
        val userNum = getNum()
        var ballCount = 0
        var strikeCount = 0

        userNum.forEach {
            if (computer.contains(it))
                ballCount++
        }
        for (i in 0..2) {
            if (computer[i] == userNum[i])
                strikeCount++
        }
        ballCount -= strikeCount

        PrintMessage().printResult(ballCount, strikeCount)

        if (strikeCount != 3) {
            compareUserNumAndComputerNum(computer)
        }


    }

    private fun getNum(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val tempNum = readLine()!!
        var userNum: Int = 0

        Exception().isInValidNum(tempNum)
        userNum = tempNum.toInt()

        val userNumList = mutableListOf<Int>()

        while (userNum != 0) {
            userNumList.add(userNum % 10)
            userNum /= 10
        }

        Exception().isDistinctNum(userNumList)

        return userNumList.reversed()
    }

    fun baseballGameEnd(): Boolean {
        PrintMessage().showEndMessage()

        val endNum = readLine()!!.toInt()
        Exception().isValidEndNum(endNum)

        if(endNum == 2)
            return false

        return true
    }
}