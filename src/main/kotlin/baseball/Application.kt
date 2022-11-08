package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    println(setRandomNumber())
    println(getUserNumber())
}


fun getUserNumber(): String {
    val userNumber = readLine()
    if(isInvalidNumber(userNumber)) {
        throw IllegalArgumentException()
    }
    return readLine()
}


fun setRandomNumber(): List<Int> {
    val baseballNumber = mutableListOf<Int>()
    while (baseballNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!baseballNumber.contains(randomNumber)) {
            baseballNumber.add(randomNumber)
        }
    }
    return baseballNumber
}


fun isInvalidNumber(userNumber : String) : Boolean{
    val regex = Regex("^[0-9]{3}\$")
    return !regex.matches(userNumber)
}