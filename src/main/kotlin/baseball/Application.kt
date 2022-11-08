package baseball

import camp.nextstep.edu.missionutils.Randoms

const val NUM_DIGITS = 3

const val WORD_BALL = "볼"
const val WORD_STRIKE = "스트라이크"
const val WORD_NOTHING = "낫싱"
const val WORD_RESTART_GAME = "1"
const val WORD_END_GAME = "2"

const val STRING_START_GAME = "숫자 야구 게임을 시작합니다."
const val STRING_INPUT_NUMBER = "숫자를 입력해주세요 : "
const val STRING_WIN_GAME = "${NUM_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val STRING_ASK_RESTART = "게임을 새로 시작하려면 ${WORD_RESTART_GAME}, 종료하려면 ${WORD_END_GAME}를 입력하세요."
const val STRING_END_GAME = "게임을 종료합니다.."

fun main() {
    var isRunning = true

    println(STRING_START_GAME)
    while (isRunning) {
        playGame()
        isRunning = isRestart()
    }

    println(STRING_END_GAME)
}

fun playGame() {
    val computerNumbers = makeRandomNumbers()
    var result = Pair(0, 0)

    while (result.first != NUM_DIGITS) {
        print(STRING_INPUT_NUMBER)
        val playerNumbers = readLine()?.let { getPlayerNumbers(it) }
        result = getResult(computerNumbers, playerNumbers!!)
        printResult(result)
    }
}

fun getResult(
    computerNumberList: MutableList<Int>,
    playerNumberList: MutableList<Int>
): Pair<Int, Int> {

    val numberOfStrike = playerNumberList.count {
        playerNumberList.indexOf(it) == computerNumberList.indexOf(it)
    }
    val numberOfBall = playerNumberList.count {
        computerNumberList.contains(it)
    } - numberOfStrike

    return Pair(numberOfStrike, numberOfBall)
}

fun getPlayerNumbers(input: String): MutableList<Int> {

    checkExceptionOnNumbers(input)

    val userNumbers = mutableListOf<Int>()
    for (digit in 0 until NUM_DIGITS) {
        userNumbers.add(input[digit].digitToInt())
    }

    return userNumbers
}

fun makeRandomNumbers(): MutableList<Int> {
    val randomNumbers = mutableListOf<Int>()

    while (randomNumbers.size < NUM_DIGITS) {
        val number = Randoms.pickNumberInRange(1, 9)
        if (!randomNumbers.contains(number)) {
            randomNumbers.add(number)
        }
    }

    return randomNumbers
}

fun printResult(result: Pair<Int, Int>) {
    if (result.first == NUM_DIGITS) {
        println("${NUM_DIGITS}${WORD_STRIKE}")
        println(STRING_WIN_GAME)
        return
    }

    if (result.second != 0) {
        print("${result.second}${WORD_BALL} ")
    }
    if (result.first != 0) {
        print("${result.first}${WORD_STRIKE}")
    }
    if (result.first + result.second == 0) {
        print(WORD_NOTHING)
    }
    println()
}

fun isRestart(): Boolean {
    println(STRING_ASK_RESTART)

    return when (readLine()) {
        WORD_RESTART_GAME -> true
        WORD_END_GAME -> false
        else -> throw IllegalArgumentException("종료 선택 옵션에 없는 명령어를 입력하였습니다.")
    }
}
