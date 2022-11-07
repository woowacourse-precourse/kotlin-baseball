package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var computerNumber = makeRandomNumber(3)
    println("랜덤숫자 : ${computerNumber}")

    while (true) {
        print("숫자를 입력해주세요 : ")
        var userInput = Console.readLine()
        println(userInput)
        checkNumberException(userInput)

        if (searchNothingCase(userInput, computerNumber)) {
            println("낫싱")
        } else {
            println("컴퓨터 숫자에 포함된 숫자가 존재")
            TODO("낫싱이 아닌 경우")
        }
    }
}

fun makeRandomNumber(length: Int): String {
    var noOverlapRandomNumber = mutableListOf<Int>()

    while (noOverlapRandomNumber.size < 3) {
        var randNum = Randoms.pickNumberInRange(1, 9)
        if (randNum !in noOverlapRandomNumber) {
            noOverlapRandomNumber.add(randNum)
        }
    }
    return noOverlapRandomNumber.joinToString("")
}

fun checkNumberException(userInput: String) {
    if (userInput.toIntOrNull() == null) {
        throw IllegalArgumentException("IllegalAccessException. 프로그램을 종료합니다.")
    } else if (userInput.length != 3) {
        throw IllegalArgumentException("IllegalAccessException. 프로그램을 종료합니다.")
    }

    var userNumber = mutableListOf<String>()
    for (i in userNumber) {
        if (i !in userNumber) {
            userNumber.add(i)
        } else {
            throw IllegalArgumentException("IllegalAccessException. 프로그램을 종료합니다.")
        }
    }
}

fun searchNothingCase(userNum: String, computerNum: String): Boolean {
    var isNothing = true
    for (i in userNum) {
        if (i in computerNum) {
            isNothing = false
        }
    }
    return isNothing
}
