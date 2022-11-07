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

        var (isNothing, userindexIncomputerNum) = searchNothingCase(userInput, computerNumber)

        if (isNothing) {
            println("낫싱")
        } else {
            println("${userInput}의 ${userindexIncomputerNum} 인덱스는 computerNumber에 존재")
            TODO("스트라이크/볼 판단")
        }
    }
}

fun makeRandomNumber(length: Int): String {
    var noOverlapRandomNumber = mutableListOf<Int>()

    while (noOverlapRandomNumber.size < length) {
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

fun searchNothingCase(userNum: String, computerNum: String): Pair<Boolean, MutableList<Int>> {
    var isNothing = true
    var userindexIncomputerNum = mutableListOf<Int>()
    for (i in userNum.indices) {
        if (userNum[i] in computerNum) {
            isNothing = false
            userindexIncomputerNum.add(i)
        }
    }
    return Pair(isNothing, userindexIncomputerNum)
}
