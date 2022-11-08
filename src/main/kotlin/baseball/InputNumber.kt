package baseball

import camp.nextstep.edu.missionutils.Console

class InputNumber {
    fun input(targetNumber: String) {
        showInputMessage()
        validNumber(targetNumber)
    }
}

private fun showInputMessage() {
    print(PrintText.REQUEST_INPUT)
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
        if (length != 3 || !all { it.isDigit() } || isBlank() || contains(PrintText.EXCEPTION_NUMBER)) {
            throw IllegalArgumentException(PrintText.INVALID_INPUT)
        }
    }
}



