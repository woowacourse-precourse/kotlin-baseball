package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import kotlin.contracts.contract

fun main() {
    var stop = false
    println("숫자 야구 게임을 시작합니다.")
    while (!stop) {
        val computerNumbers = getRandomNumbers()
        print("숫자를 입력해주세요 : ")
        println(computerNumbers)
        stop = baseballGame(computerNumbers)
    }
}

// Randoms의 APi의 pickUniqueNumbersInRange 사용법 (.pickNumberInRange 사용하여 구현해야되서 주석 처리)
// fun getRandomNumbers(randomStartNumber: Int, randomEndNumber: Int, randomsLength: Int): List<Int> {
//    return Randoms.pickUniqueNumbersInRange(randomStartNumber, randomEndNumber, randomsLength)
// }

fun getRandomNumbers(randomStartNumber: Int = 1, randomEndNumber: Int = 9, randomsLength: Int = 3): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < randomsLength) {
        val randomNumber = Randoms.pickNumberInRange(randomStartNumber, randomEndNumber)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun readInputString(): String {
    return Console.readLine()

}

fun validateInputString(
    inputNumbers: String, stringLengthToSpecify: Int = 3, inputStartNumber: Int = 1, inputEndNumber: Int = 9
): MutableList<Int> {
    val verifiedNumbers = mutableListOf<Int>()
    val inputNumbers = inputNumbers.toCharArray()
    inputNumbers.map { number ->
        requireNotNull(
            number.digitToIntOrNull()
        ) { "잘못된 값이 입력되어 애플리케이션이 종료됩니다." }
        require(
            (inputStartNumber..inputEndNumber).contains(number.digitToInt())
        ) { "입력 가능한 수 외에 다른수가 입력되아 애플리케이션이 종료됩니다." }
        verifiedNumbers.add(number.digitToInt())
    }
    require(
        inputNumbers.size == stringLengthToSpecify
    ) { "한자릿수 ${stringLengthToSpecify}개를 입력하지 않아 애플리케이션이 종료됩니다." }
    require(
        inputNumbers.distinct().size == stringLengthToSpecify
    ) { "중복된 숫자가 입력되어 애플리케이션이 종료됩니다." }

    return verifiedNumbers
}

fun getBaseballResult(computerNumbers: MutableList<Int>, playerNumbers: MutableList<Int>): String {
    var strikeCount = 0
    var ballCount = 0
    computerNumbers.forEachIndexed { index, value ->
        if (playerNumbers[index] == value) strikeCount++
        if (playerNumbers[index] != value && playerNumbers.contains(value)) ballCount++
    }
    val strike = if (strikeCount != 0) "${strikeCount}스트라이크" else ""
    val ball = if (ballCount != 0) "${ballCount}볼 " else ""
    return if (strikeCount + ballCount != 0) ball + strike else "낫싱"
}

fun chooseToRestartOrStop(readInputString: String): Boolean {
    var stop = false
    val continueOrStop = validateInputString(
        readInputString, stringLengthToSpecify = 1, inputStartNumber = 1, inputEndNumber = 2
    )
    if (continueOrStop.first() == 2) {
        println("게임 종료")
        stop = true
    }
    return stop
}

fun baseballGame(computerNumbers: MutableList<Int>): Boolean {
    var stop: Boolean
    while (true) {
        var playerNumbers = validateInputString(readInputString())
        val baseballResult = getBaseballResult(computerNumbers, playerNumbers)
        println(baseballResult)
        if (baseballResult == "3스트라이크") {
            println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.")
            stop = chooseToRestartOrStop(readInputString())
            break
        }
    }
    return stop
}







