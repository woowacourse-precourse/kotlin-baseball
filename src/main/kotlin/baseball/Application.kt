package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    println(getRandomNumbers(1, 9, 3))
    validateInputString(readInputString(), 3)

}

fun getRandomNumbers(randomStartNumber: Int, randomEndNumber: Int, randomsLength: Int): List<Int> {
    return Randoms.pickUniqueNumbersInRange(randomStartNumber, randomEndNumber, randomsLength)
}

fun readInputString(): String {
    return Console.readLine()

}

fun validateInputString(inputNumbers: String, stringLengthToSpecify: Int) {
    require(inputNumbers.length == stringLengthToSpecify) { "한 자릿수를 지정한 갯수만큼 입력해주세요." }
    inputNumbers.map { number -> requireNotNull(number.digitToIntOrNull()) { "잘못된 값이 입력되어 애플리케이션이 종료됩니다." } }
}


