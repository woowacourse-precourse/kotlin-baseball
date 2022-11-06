package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

const val NEW_GAME = 1
const val EXIT = 2
val EXCEPTION = IllegalArgumentException()

class InputDevice {
    var userNumber = MutableList(3) {0}

    fun execute() {
        initVariable()
        getInput()
    }
    private fun getInput() {
        println("숫자를 입력해주세요: ")
        val input = Console.readLine()
        isValidInput(input)
        for(index in 0..2) {
            userNumber[index] = input[index].digitToInt()
        }
    }
    private fun initVariable() {
        userNumber = MutableList(3) {0}
    }
    private fun isValidInput(input: String) {
        // input should be length 3
        if(input.length != 3) throw EXCEPTION
        // input should be composed by numbers
        for(c in input) {
            if(!c.isDigit()) throw EXCEPTION
        }
        // input digits must be placed between 1 to 9
        if(input.contains('0')) throw EXCEPTION
        // input digits must be different from each other
        val appeared = MutableList(10) {false}
        for(c in input) {
            if(appeared[c.digitToInt()]) throw EXCEPTION
            appeared[c.digitToInt()] = true
        }
    }
}

class GameDevice {
    private var numberOfStrikes = 0
    private var numberOfBalls = 0

    fun execute(userNumber: List<Int>, computerNumber: List<Int>) {
        initVariable()
        calculateResult(userNumber, computerNumber)
        printResult()
    }
    private fun initVariable() {
        numberOfBalls = 0
        numberOfStrikes = 0
    }
    private fun calculateResult(userNumber: List<Int>, computerNumber: List<Int>) {
        val appeared = MutableList(10) {false}
        for(c in computerNumber) {
            appeared[c] = true
        }
        for (i in 0..2) {
            if (computerNumber[i] == userNumber[i]) {
                numberOfStrikes += 1
            }
            else if(appeared[userNumber[i]]) {
                numberOfBalls += 1
            }
        }
    }
    private fun printResult() {
        if (numberOfBalls != 0 && numberOfStrikes != 0) {
            println("${numberOfBalls}볼 ${numberOfStrikes}스트라이크")
        } else if (numberOfBalls != 0) {
            println("${numberOfBalls}볼")
        } else if (numberOfStrikes != 0) {
            println("${numberOfStrikes}스트라이크")
        } else {
            println("낫싱")
        }
    }
    fun isOver(): Boolean {
        return numberOfStrikes == 3
    }
}

class TerminateDevice {
    private var userInput = 0
    private fun getInput() {

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 ${NEW_GAME}, 종료하려면 ${EXIT}를 입력하세요")
        val input = Console.readLine().toInt()
        if (input == NEW_GAME || input == EXIT) {
            userInput = input
        }
        else {
            throw EXCEPTION
        }
    }
}

fun main() {
    TODO("프로그램 구현")
}
