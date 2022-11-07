package baseball

import camp.nextstep.edu.missionutils.Console
import model.Computer
import model.User
import util.Constants
import util.Exceptions
import util.Messages


object GameController {
    // 게임에 사용할 model
    private val user = User()
    private val computer = Computer()

    // 사용자가 잘못된 값을 입력한 경우
    fun exception(userList: List<Int>) {
        if (!Exceptions.isValidRange(userList) ||
                !Exceptions.isValidSize(userList) ||
                !Exceptions.hasNotDuplicatedNumber(userList)) {
            throw IllegalArgumentException()
        }
    }

    // 스트라이크 -> 위치와 숫자가 모두 같음
    fun getStrikeCount(computer: List<Int>, user: List<Int>): Int {
        return user.filterIndexed { index, number ->
            computer[index] == number
        }.count()
    }

    // 볼 -> 위치는 다르지만 숫자가 포함
    fun getBallCount(computer: List<Int>, user: List<Int>): Int {
        var ball = 0
        // 위치와 숫자가 같은 부분 필터링
        val filterList = computer.filterIndexed { index, computerNumber ->
            user[index] != computerNumber
        }
        user.forEach { number ->
            if (filterList.contains(number)) {
                ball++
            }
        }
        return ball
    }

    // 결과에 따라 출력
    fun resultMessage(strike: Int, ball: Int): String {
        return if (strike == 0 && ball == 0) {
            Messages.NOTHING
        } else if (strike == 0) {
            "$ball" + Messages.BALL
        } else if (ball == 0) {
            "$strike" + Messages.STRIKE
        } else {
            "$ball" + Messages.BALL + " $strike" + Messages.STRIKE
        }
    }

    // 모든 숫자들을 맞추면 성공
    private fun userCorrectAnswer(strike: Int): Boolean {
        if (strike == Constants.MAX_SIZE) {
            println(Messages.SUCCESS_MESSAGE)
            return true
        }
        return false
    }

    // 야구 게임의 한 사이클을 동작하는 함수
    private fun guessTheNumber() {
        println(Messages.START_MESSAGE)
        // 랜덤한 컴퓨터 번호 생성
        computer.registerNumbersToList()
        while (true) {
            val userInput = user.input()
            user.inputConvertToList(userInput)
            // 사용자 입력에 대한 리스트 예외 확인
            exception(user.numberList)
            // 스트라이크, 볼 개수 확인
            val strikeCount = getStrikeCount(computer.randomNumberList, user.numberList)
            val ballCount = getBallCount(computer.randomNumberList, user.numberList)
            println(resultMessage(strikeCount, ballCount))
            // 모든 숫자를 맞추면 게임 종료
            if (userCorrectAnswer(strikeCount)) {
                break
            }
        }
    }

    // 전체적인 게임을 동작
    fun playGame() {
        while (true) {
            guessTheNumber()
            println(Messages.RESTART_OR_EXIT)
            if (gameExit()) {
                break
            }
        }
    }

    private fun gameExit(): Boolean {
        val status = Console.readLine()
        // 입력 값에 따른 예외처리
        Exceptions.checkValidInput(status)
        return status == "${Constants.EXIT}"
    }
}