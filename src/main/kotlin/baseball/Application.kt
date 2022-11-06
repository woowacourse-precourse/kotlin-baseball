package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {
    var computerRandomNumber = createComputerRandomNumber()
    println("숫자 야구 게임을 시작합니다.")
    while (true) {

    }
}

fun createComputerRandomNumber(): String {

    val computerNumStringList = mutableListOf<String>()

    while (computerNumStringList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumStringList.contains(randomNumber.toString())) {
            computerNumStringList.add(randomNumber.toString())
        }
    }
    return computerNumStringList
            .joinToString("")
}

fun inputUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userInputNumber = Console.readLine()
    return userInputNumber.toString()
}

fun checkInputUserNumber(userInputNumber: String?) {
    val checkOverlapInputNumber = mutableListOf<String>()

    //중복체크
    userInputNumber ?: throw IllegalArgumentException()

    for (userInputNumberWord in userInputNumber) checkOverlapInputNumber.add(userInputNumberWord.toString())

    if (checkOverlapInputNumber.distinct().size != 3) throw IllegalArgumentException()

}

