package baseball

import camp.nextstep.edu.missionutils.*

const val RESTART = 0
const val END = 2
const val INPUT_RESTART = 1
const val IN_GAME = 3

fun main() {
    /**
     * 기능목록
     * 1. 게임 시작 문구 출력
     * 2. 랜덤한 숫자를 생성해 리스트에 저장
     * 3. 숫자 입력 문구 출력
     * 4. 숫자 입력 받음
     * 5. 예외처리 및 프로그램 종료
     * 6. 입력 받은 숫자를 잘라서 리스트에 보관
     * 7. 생성한 숫자와 입력받은 숫자가 동일하며 위치도 같은지 확인
     * 8. 생성한 숫자와 입력받은 숫자가 동일한 숫자를 포함하고 있는지 확인
     * 9. 확인 결과 출력
     * 10. 확인 결과가 3스트라이크 아닐경우 3번으로 돌아감
     * 11. 3스트라이크면 게임종료 텍스트 출력 및 게임 재시작 혹은 종료 출력
     * 12. 예외처리 및 프로그램 종료
     * 13. 재시작을 누르면 2번으로 복귀
     * 14. 종료를 누르면 프로그램 종료
     * */

    /**
     * 예외처리 리스트
     * 1. 숫자로만 구성되어야 함
     * 2. 길이는 3
     * 3. 모두 다른 숫자여야 함
     * */

    /** 게임 시작 문구 출력 */
    println("숫자 야구 게임을 시작합니다.")

    var gameStatusFlag = IN_GAME
    var listOfCreatedNumber = createRandomNumber()

    while (true) {
        if (gameStatusFlag == RESTART) {
            /** 랜덤한 숫자를 생성해 리스트에 저장 */
            listOfCreatedNumber = createRandomNumber()
            gameStatusFlag = IN_GAME
        }
        if (gameStatusFlag == IN_GAME) {
            /** 숫자 입력 문구 출력 */
            print("숫자를 입력해주세요 : ")

            /** 숫자 입력 받음 */
            val inputNumber = Console.readLine()

            /** 예외처리 및 프로그램 종료 */
            validateNumber(inputNumber)
            validateLength(inputNumber)
            validateRepeat(inputNumber)

            /** 입력 받은 숫자를 잘라서 리스트에 보관 */
            val listOfInputNumber: MutableList<Int> = mutableListOf()
            for (i in 0..2) {
                listOfInputNumber.add(inputNumber[i].digitToInt())
            }
            println()

            /**
             * 생성한 숫자와 입력받은 숫자가 동일하며 위치도 같은지 확인
             * 생성한 숫자와 입력받은 숫자가 동일한 숫자를 포함하고 있는지 확인
             * */
            val resultOfCheckBothNumbers = checkBothNumbers(listOfCreatedNumber, listOfInputNumber)

            /** 확인 결과 출력 */
            println(resultOfCheckBothNumbers)

            /**
             * 확인 결과가 3스트라이크 아닐경우 3번으로 돌아감
             * 3스트라이크면 게임종료 텍스트 출력 및 게임 재시작 혹은 종료 출력
             * 예외처리 및 프로그램 종료
             * 재시작을 누르면 2번으로 복귀
             * 종료를 누르면 프로그램 종료
             * */
            gameStatusFlag = checkGameStatus(resultOfCheckBothNumbers)
        }
        if (gameStatusFlag == END) {
            break
        }
        if (gameStatusFlag == INPUT_RESTART) {
            gameStatusFlag = RESTART
        }
    }
    println("게임 종료")
}

fun checkGameStatus(resultOfCheckBothNumbers: String): Int {
    if (resultOfCheckBothNumbers == "3스트라이크") {
        println("3개의 숫자를 모두 맞히셨습니다. 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputStatusNumber = Console.readLine()
        validateStatusNumber(inputStatusNumber)
        return inputStatusNumber.toInt()
    }
    return IN_GAME
}

fun createRandomNumber(): List<Int> {
    val listOfCreatedNumber: MutableList<Int> = mutableListOf()
    while (listOfCreatedNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!listOfCreatedNumber.contains(randomNumber)) {
            listOfCreatedNumber.add(randomNumber)
        }
    }
    return listOfCreatedNumber.toList()
}

fun validateStatusNumber(inputStatusNumber: String) {
    if (!inputStatusNumber.all { it.isDigit() }) {
        throw IllegalArgumentException("입력한 문자열이 숫자가 아닙니다.")
    }
    if (inputStatusNumber.length > 1) {
        throw IllegalArgumentException("입력한 문자열의 길이가 1보다 큽니다.")
    }
}

fun validateNumber(inputNumber: String) {
    if (!inputNumber.all { it.isDigit() }) {
        throw IllegalArgumentException("입력한 문자열이 숫자가 아닙니다.")
    }
}

fun validateLength(inputNumber: String) {
    if (inputNumber.length != 3) {
        throw IllegalArgumentException("입력한 문자열의 길이가 3이 아닙니다.")
    }
}

fun validateRepeat(inputNumber: String) {
    if ((inputNumber[0] == inputNumber[1]) or
        (inputNumber[1] == inputNumber[2]) or
        (inputNumber[0] == inputNumber[2])
    ) {
        throw java.lang.IllegalArgumentException("입력한 문자열에 중복이 있습니다.")
    }
}

fun checkBothNumbers(listOfCreatedNumber: List<Int>, listOfInputNumber: List<Int>): String {
    var result = ""
    var ball = 0
    var strike = 0

    for (index in listOfInputNumber.indices) {
        if (listOfCreatedNumber[index] == listOfInputNumber[index]) {
            strike += 1
        }
        if ((listOfCreatedNumber.contains(listOfInputNumber[index])) and
            (listOfCreatedNumber[index] != listOfInputNumber[index])
        ) {
            ball += 1
        }
    }

    if ((strike == 0) and (ball == 0)) {
        result += "낫싱"
        return result
    }
    if ((strike == 0) and (ball != 0)) {
        result += ball.toString() + "볼"
        return result
    }
    if ((strike != 0) and (ball == 0)) {
        result += strike.toString() + "스트라이크"
        return result
    }
    result += ball.toString() + "볼" + " " + strike.toString() + "스트라이크"
    return result
}
