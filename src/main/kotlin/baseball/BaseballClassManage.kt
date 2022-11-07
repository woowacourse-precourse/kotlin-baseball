package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class NumberBaseballComputer {
    private var powerOfComputer: Boolean = true
    private val randomList = RandomGenerator().randomList()
    private var responseMessage = StringBuilder("")

    fun receiveUserMessage(message: String) {
        println("\n받은 메시지 = $message")
        validateNumber(message)
        validateRange(message)
        validateDup(message)

        val userInputList = toIntList(message.toList())
        val recorder = Recorder(submitFromComputer = randomList, submitFromUser = userInputList)

        responseMessage = StringBuilder(recorder.toString())
        if (responseMessage.toString() == "3스트라이크") {
            powerOff()
            responseMessage.append(
                "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
            )
        }
    }

    fun getResponse(): String {
        return responseMessage.toString()
    }

    fun isPoweredOn(): Boolean {
        return this.powerOfComputer
    }

    private fun validateRange(message: String) {
        if (message.length < 3 || message.length >= 4)
            throw IllegalArgumentException("the input range out of bound")
    }

    private fun validateNumber(message: String) {
        for (ch in message.toCharArray()) {
            if (ch.code < '0'.code || ch.code > '9'.code)
                throw IllegalArgumentException("string contains non-numeric characters ")
        }
    }

    private fun validateDup(message: String) {
        val charArrayMessage = message.toCharArray().distinct()
        if (charArrayMessage.size != message.length)
            throw IllegalArgumentException("string contains duplicate numbers")
    }

    private fun toIntList(charList: List<Char>): List<Int> {
        val result = mutableListOf<Int>()

        for (ch in charList) {
            result.add(ch.digitToInt())
        }

        return result
    }

    private fun powerOff() {
        this.powerOfComputer = false
    }
}

class RandomGenerator {
    fun randomList(): List<Int> {
        val randomList = mutableListOf<Int>()
        while (randomList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber)
            }
        }

        return randomList
    }
}

class Recorder(private val submitFromComputer: List<Int>, private val submitFromUser: List<Int>) {
    private val gameResultList: List<Int> = resultIntList()

    override fun toString(): String {
        if (gameResultList[2] == submitFromComputer.size)
            return "낫싱"

        val strBuilder = StringBuilder()
        if (gameResultList[1] > 0)
            strBuilder.append("${gameResultList[1]}볼 ")
        if (gameResultList[0] > 0)
            strBuilder.append("${gameResultList[0]}스트라이크")

        return strBuilder.toString()
    }

    private enum class ResultState { STRIKE, BALL, NONE }

    private fun checkNumberAt(index: Int): ResultState {
        for (i in submitFromComputer.indices) {
            if (submitFromUser[index] == submitFromComputer[i] && index == i)
                return ResultState.STRIKE
            else if (submitFromUser[index] == submitFromComputer[i])
                return ResultState.BALL
        }
        return ResultState.NONE
    }

    private fun resultIntList(): List<Int> {
        val result = IntArray(3) { 0 } /* STRIKE, BALL, NONE */

        for (index in submitFromUser.indices) {
            when (checkNumberAt(index)) {
                ResultState.STRIKE -> result[0] += 1
                ResultState.BALL -> result[1] += 1
                ResultState.NONE -> result[2] += 1
            }
        }

        return result.toList()
    }
}

class ConsoleManager {
    private var stringOfReadLine: String = ""

    fun readLine(): String {
        stringOfReadLine = Console.readLine()
        return stringOfReadLine
    }

    fun writeLine(stringMessage: String) {
        print(stringMessage)
    }
}