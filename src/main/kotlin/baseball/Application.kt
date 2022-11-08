package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    printStartMessage()
    val computerNum = getComputerNum()
    val userNum = getUserNum()
    print(getInningResult(computerNum, userNum))
}

fun printStartMessage() = "숫자 야구 게임을 시작합니다."

fun getNum() = Randoms.pickNumberInRange(0, 9)

fun addNotDuplicateNum(
        numbers: MutableList<Int>,
        number: Int
) {
    if (!numbers.contains(number)) numbers.add(number)
}

fun getComputerNum(): MutableList<Int> {
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

fun isNotDuplicate(string: String): Boolean {
    var result = true

    for (i in 1 until string.length)
        if (string[0] == string[i]) result = false

    return result
}

fun isSatisfyConditions(numbers: String): Boolean {
    return isNum(numbers) &&
            isThreeLength(numbers) &&
            isNotDuplicate(numbers)
}

fun enterNum(): String {
    print("\n숫자를 입력해주세요 : ")
    return Console.readLine()
}

fun numToList(numbers: String): MutableList<Int> {
    val result = mutableListOf<Int>()

    for (i in numbers.indices)
        result.add(numbers[i]
                .toString()
                .toInt()
        )

    return result
}

fun getUserNum(): MutableList<Int> {
    val numbers = enterNum()

    return if (isSatisfyConditions(numbers)) numToList(numbers)
        else throw IllegalArgumentException("수를 잘못 입력하였습니다.")
}

fun getStrikeCount(
        computerNum: MutableList<Int>,
        userNum: MutableList<Int>
): Int {
    var strikeCount = 0

    for (i in userNum.indices)
        if (computerNum[i] == userNum[i]) strikeCount++

    return strikeCount
}

fun getBallCount(
        computerNum: MutableList<Int>,
        userNum: MutableList<Int>
): Int{
    var ballCount = 0

    for (i in userNum.indices)
        if (computerNum.contains(userNum[i])) ballCount++

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

    return getBallStrikeMessage(ballCount, strikeCount)
}