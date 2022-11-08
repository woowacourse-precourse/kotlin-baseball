package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    printStartMessage()
    playNumBaseball()
}

fun printStartMessage() = "숫자 야구 게임을 시작합니다."

fun getNum() = Randoms.pickNumberInRange(0, 9)

fun addNotDuplicateNum(
        numbers: MutableList<Int>,
        number: Int
) {
    if (!numbers.contains(number)) numbers.add(number)
}

fun getComputerNumbers(): MutableList<Int> {
    val numbers = mutableListOf<Int>()

    while (numbers.size != 3) {
        val number = getNum()
        addNotDuplicateNum(numbers, number)
    }

    return numbers
}

fun isNum(string: String): Boolean {
    return try {
        string.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun isThreeLength(string: String) = string.length == 3

fun addSameCharCount(char1: Char, char2: Char) = if (char1 == char2) 1 else 0

fun isNotDuplicate(string: String): Boolean {
    var result = true

    for (i in string.indices){
        var charCount = 0

        for (j in i until string.length)
            charCount += addSameCharCount(string[i], string[j])
        if (charCount > 1){
            result = false
            break
        }
    }

    return result
}

fun isSatisfyConditions(numbers: String): Boolean {
    return isNum(numbers) &&
            isThreeLength(numbers) &&
            isNotDuplicate(numbers)
}

fun enterNumbers(): String {
    print("\n숫자를 입력해주세요 : ")
    return Console.readLine()
}

fun numbersToList(numbers: String): MutableList<Int> {
    val result = mutableListOf<Int>()

    for (i in numbers.indices)
        result.add(numbers[i]
                .toString()
                .toInt()
        )

    return result
}

fun getUserNumbers(): MutableList<Int> {
    val numbers = enterNumbers()

    return if (isSatisfyConditions(numbers)) numbersToList(numbers)
        else throw IllegalArgumentException("수를 잘못 입력하였습니다.")
}

fun addStrikeCount(computerNum: Int, userNum: Int): Int = if (computerNum == userNum) 1 else 0

fun getStrikeCount(
        computerNumbers: MutableList<Int>,
        userNumbers: MutableList<Int>
): Int {
    var strikeCount = 0

    for (i in userNumbers.indices)
        strikeCount += addStrikeCount(computerNumbers[i], userNumbers[i])

    return strikeCount
}

fun addBallCount(
        computerNumbers: MutableList<Int>,
        userNum: Int
): Int = if (computerNumbers.contains(userNum)) 1 else 0

fun getBallCount(
        computerNumbers: MutableList<Int>,
        userNumbers: MutableList<Int>
): Int{
    var ballCount = 0

    for (i in userNumbers.indices)
        ballCount += addBallCount(computerNumbers, userNumbers[i])

    return ballCount
}

fun getBallStrikeMessage(ballCount: Int, strikeCount: Int): String {
    return if (ballCount > 0 && strikeCount > 0)
        "${ballCount}볼 ${strikeCount}스트라이크"
    else if (ballCount > 0)
        "${ballCount}볼"
    else if (strikeCount > 0)
        "${strikeCount}스트라이크"
    else "낫싱"
}

fun getInningResult(
        computerNum: MutableList<Int>,
        userNum: MutableList<Int>
): String {
    val strikeCount = getStrikeCount(computerNum, userNum)
    // 볼 카운트에 스트라이크가 포함되므로, 중복되는 스트라이크 카운트를 한 번 빼준다.
    val ballCount = getBallCount(computerNum, userNum) - strikeCount

    print(getBallStrikeMessage(ballCount, strikeCount))

    return getBallStrikeMessage(ballCount, strikeCount)
}

fun playNumBaseball() {
    val computerNum = getComputerNumbers()
    var userNum = getUserNumbers()
    var inningResult = getInningResult(computerNum, userNum)

    while (inningResult != "3스트라이크"){
        userNum = getUserNumbers()
        inningResult = getInningResult(computerNum, userNum)
        if (inningResult == "3스트라이크") break
    }
    print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}