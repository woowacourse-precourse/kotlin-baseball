package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun chooseComputerNumber(): String {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        var randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        addComputerNumber(randomNumber, computerNumber)
    }
    return computerNumber.joinToString("")
}

/* 뽑은 랜덤 숫자의 중복 여부를 확인하고 아닐 시 리스트에 추가하는 메소드  */
fun addComputerNumber(randomNumber: Int, computerNumber: MutableList<Int>) {
    if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber)
    }
}

fun printFirstStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserNumber(): String {
    val userNumber = mutableListOf<Char>()
    val userInput = Console.readLine().toString()

    // 사용자의 입력이 세 자리 수가 아닌 경우
    if (userInput.length != 3) {
        throw IllegalArgumentException("You can enter only a three-digit number")
    }

    for (index in userInput.indices) {
        // 사용자의 입력이 숫자가 아닌 경우
        if (userInput[index] < '0' || userInput[index] > '9') {
            throw IllegalArgumentException("You can enter only a number")
        }
        // 사용자의 입력이 같은 숫자를 포함하는 경우
        if (userNumber.contains(userInput[index])) {
            throw IllegalArgumentException("Each digit number must be different")
        }
        userNumber.add(userInput[index])
    }
    return userNumber.toString()
}
