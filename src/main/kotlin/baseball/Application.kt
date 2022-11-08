package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    Baseball().game()
}

class Baseball {
    private var ballCount = 0
    private var strikeCount = 0

    fun game() {
        var gameCoin = true

        while (gameCoin) {
            compareNum()
            printState(gameReplay)
            gameCoin = restartBoolean()
        }

    }


    private fun restartBoolean(): Boolean {
        val input = readLine()?.toInt()
        if ((input != 1) and (input != 2)) {
            printState(gameReplay)
        }

        return when (input) {
            1 -> true
            2 -> false
            else -> restartBoolean()
        }

    }

    private fun compareNum() {
        printState(gameStart)
        val comNum = getComNum()

        while (true) {
            printState(gameInProgress)
            val userNum = getUserNum()

            ballCount(userNum, comNum)
            strikeCount(userNum, comNum)

            if ((ballCount == 0) and (strikeCount == 0)) {
                printState(gameScoreNothing)

            } else if ((ballCount == 0) and (strikeCount > 0)) {
                printState(gameStrikeCount)

            } else if ((strikeCount == 0) and (ballCount > 0)) {
                printState(gameBallCount)

            } else {
                printState(gameSumCount)
            }
            if (strikeCount == 3) break
        }
        printState(gameEnd)
    }

    private fun getComNum(): MutableList<Int> {
        val computerNum = mutableListOf<Int>()
        while (computerNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber)
            }
        }
        return computerNum
    }

    private fun printState(state: Int) {
        when (state) {
            gameStart -> println("숫자 야구 게임을 시작합니다.")
            gameInProgress -> print("숫자를 입력해주세요 : ")
            gameBallCount -> println("${ballCount}볼")
            gameStrikeCount -> println("${strikeCount}스트라이크")
            gameSumCount -> println("${ballCount}볼 ${strikeCount}스트라이크")
            gameScoreNothing -> println("낫싱")
            gameEnd -> println("게임 종료")
            gameReplay -> println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }
    }

    private fun getUserNum(): List<Int> {
        val userNum = readLine()!!.map { it.digitToInt() }

        inputException(userNum)
        return userNum
    }

    private fun ballCount(userNum: List<Int>, comNum: List<Int>) {
        ballCount = 0

        for (element in userNum) {
            if (comNum.contains(element)) {
                ballCount++
            }
        }
    }

    private fun strikeCount(userNum: List<Int>, comNum: List<Int>) {
        strikeCount = 0

        for (index in userNum.indices) {
            if (userNum[index] == comNum[index]) {
                strikeCount++
                ballCount--
            }
        }
    }

    private fun inputException(userNum: List<Int>) {
        if (userNum.contains(0)) throw IllegalArgumentException("1 ~ 9 사이의 숫자만 입력가능합니다.")
        if (userNum.size != 3) throw IllegalArgumentException("1 ~ 9 사이의 숫자, 3개를 입력해야합니다.")
        if (userNum.distinct().size != 3) throw IllegalArgumentException("중복값이 존재합니다.")
    }

    companion object {
        const val gameStart = 0
        const val gameInProgress = 1
        const val gameBallCount = 2
        const val gameStrikeCount = 3
        const val gameSumCount = 4
        const val gameScoreNothing = 5
        const val gameEnd = 6
        const val gameReplay = 7
    }
}