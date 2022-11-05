package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers
import org.mockito.MockedStatic.Verification

fun main() {
    var computer = getComputerRandomNumber()
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        print("숫자를 입력해주세요 : ")
        val player = Console.readLine()
        if (!isCorrectNumber(player)) {
            throw IllegalArgumentException()
        }

        val strikeNum = getStrikeNum(computer, player)
        val ballNum = getBallNum(computer, player, strikeNum)
        val isGameOver = printBallNStrike(strikeNum, ballNum)

        if (isGameOver.first)
            break
        isGameOver.second?.let { newComputerNumber ->
            computer = newComputerNumber
        }
    }
}

fun getComputerRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber))
            computer.add(randomNumber)
    }
    return computer
}

fun isCorrectNumber(player: String): Boolean {
    // 1. 3자리 수가 아닐 경우 false
    if (player.length != 3)
        return false
    // 2. 1-9의 범위를 벗어난 숫자가 아닐 경우 false
    for (c in player) {
        if (c < '0' || c > '9')
            return false
    }
    // 3. 서로 다른 수를 입력하지 않았을 경우 (=중복된 수를 입력할 경우) false
    if (player[0] == player[1] || player[0] == player[1] ||
        player[1] == player[2]
    )
        return false

    return true
}

fun getStrikeNum(computer: List<Int>, player: String): Int {
    var strikeNum = 0
    for (i in computer.indices) {
        val computerNumber = computer[i]
        val playerNumber = player[i] - '0'
        if (computerNumber == playerNumber)
            strikeNum++
    }
    return strikeNum
}


fun getBallNum(computer: List<Int>, player: String, strikeNum: Int): Int {
    var ballNum = 0
    for (playerCharacter in player) {
        val playerNumber = playerCharacter - '0'
        if (computer.contains(playerNumber))
            ballNum++
    }
    return ballNum - strikeNum
}


fun printBallNStrike(strikeNum: Int, ballNum: Int): Pair<Boolean, List<Int>?> {
    var isGameOver = Pair<Boolean, List<Int>?>(false, null)
    if (strikeNum == 0 && ballNum == 0)
        println("낫싱")
    else {
        if (ballNum > 0)
            print("${ballNum}볼 ")
        if (strikeNum > 0)
            print("${strikeNum}스트라이크")
        println()

        if (strikeNum == 3)
            isGameOver = choiceGameOver()
    }

    return isGameOver
}

fun choiceGameOver(): Pair<Boolean, List<Int>?> {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> Pair(false, getComputerRandomNumber())
        "2" -> Pair(true, null)
        else -> throw IllegalArgumentException()
    }
}
