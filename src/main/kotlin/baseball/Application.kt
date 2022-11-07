package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var computerNumber = ""
var userNumber = ""

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    computerNumber = makeRandomNumber(3)
    println("랜덤숫자 : ${computerNumber}")

    while (true) {
        print("숫자를 입력해주세요 : ")
        userNumber = Console.readLine()
        println(userNumber)
        checkNumberException()

        var (isNothing, userindexIncomputerNum) = searchNothingCase()

        if (isNothing) {
            println("낫싱")
        } else {
            println("${userNumber}의 ${userindexIncomputerNum} 인덱스는 computerNumber에 존재")
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

fun checkNumberException() {
    if (userNumber.toIntOrNull() == null) {
        throw IllegalArgumentException("IllegalAccessException. 숫자로 이루어지지 않았습니다.")
    } else if (userNumber.length != 3) {
        throw IllegalArgumentException("IllegalAccessException. 3개의 숫자가 아닙니다.")
    }

    var checkNumber = mutableListOf<Char>()
    for (i in userNumber) {
        if (i !in checkNumber) {
            checkNumber.add(i)
        } else {
            throw IllegalArgumentException("IllegalAccessException. 중복된 숫자가 존재합니다.")
        }
    }
}

fun searchNothingCase(): Pair<Boolean, MutableList<Int>> {
    var isNothing = true
    var userindexIncomputerNum = mutableListOf<Int>()
    for (i in userNumber.indices) {
        if (userNumber[i] in computerNumber) {
            isNothing = false
            userindexIncomputerNum.add(i)
        }
    }
    return Pair(isNothing, userindexIncomputerNum)
}
