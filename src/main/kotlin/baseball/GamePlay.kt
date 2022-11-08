package baseball

import camp.nextstep.edu.missionutils.Randoms

class GamePlay {
    fun baseballGameStart() {
        val computerNum = setComputerNum()
        var isGameOver = false

        while (!isGameOver) {
            print("숫자를 입력해주세요 : ")
            val userNum = readLine()!!
            val userNumList = getUserNumAndReturnList(userNum)
            isGameOver = compareUserNumAndComputerNum(computerNum, userNumList)
        }

        baseballGameEnd()

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

     fun compareUserNumAndComputerNum(computer: List<Int>, user: List<Int>): Boolean {
        var ballCount = 0
        var strikeCount = 0

        user.forEach {
            if (computer.contains(it))
                ballCount++
        }
        for (i in 0..2) {
            if (computer[i] == user[i])
                strikeCount++
        }
        ballCount -= strikeCount
        println(computer)

        println(PrintMessage().printResult(ballCount, strikeCount))

        if (strikeCount == 3) {
            return true
        }

        return false

    }

    fun getUserNumAndReturnList(num : String): List<Int> {
        var userNum: Int = 0

        Exception().isInValidNum(num)
        userNum = num.toInt()

        val userNumList = mutableListOf<Int>()

        while (userNum != 0) {
            userNumList.add(userNum % 10)
            userNum /= 10
        }

        Exception().isDistinctNum(userNumList)

        return userNumList.reversed()
    }

    private fun baseballGameEnd() {
        PrintMessage().showEndMessage()

        val endNum = readLine()!!
        Exception().isValidEndNum(endNum)

        if (endNum == "1")
            baseballGameStart()
    }
}