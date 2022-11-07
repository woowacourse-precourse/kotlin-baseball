package baseball

import camp.nextstep.edu.missionutils.Console

class InputNumber {
    fun input(targetNumber: String) {
        showInputMessage()
        validNumber(targetNumber)
    }
}

private fun showInputMessage() {
    print("숫자를 입력해주세요: ")
}

private fun validNumber(targetNumber: String) {
    while (true) {
        if (CountNumber().count(targetNumber, enterNumber())) {
            break
        }
    }
}

private fun enterNumber(): String {
    return Console.readLine().trim().apply {
        if (length != 3 || !all { it.isDigit() } || isBlank() || contains("0")) {
            throw IllegalArgumentException("올바르지 않은 입력값입니다.")
        }
    }
}



