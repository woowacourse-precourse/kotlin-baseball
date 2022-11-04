package baseball

import camp.nextstep.edu.missionutils.*

fun main() {
    /**
     * 기능목록
     * 1. 게임 시작 문구 출력
     * 2. 랜덤한 숫자를 생성해 리스트에 저장
     * 3. 숫자 입력 문구 출력
     * 4. 숫자 입력 받음
     * 5. 예외처리 및 프로그램 종료
     * 6. 입력 받은 숫자를 잘라서 리스트에 보관
     * 7. 생성한 숫자와 입력받은 숫자가 동일한 숫자를 포함하고 있는지 확인
     * 8. 생성한 숫자와 입력받은 숫자가 동일하며 위치도 같은지 확인
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

    var flag = 1

    while (true) {
        if (flag == 1) {
            /** 랜덤한 숫자를 생성해 리스트에 저장 */
            val listOfCreatedNumber = createRandomNumber()
            flag += 1
        }
        if (flag == 2) {
            /** 숫자 입력 문구 출력 */
            print("숫자를 입력해주세요 : ")
            val inputNumber = Console.readLine()
            validateNumber(inputNumber)
            validateLength(inputNumber)

            val listOfInputNumber: MutableList<Int> = mutableListOf(3)

            for (i in 0..2) {
                listOfInputNumber.add(inputNumber[i].digitToInt())
            }
        }
    }
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

fun validateNumber(inputNumber: String) {
    val regexNumber = Regex("^[0-9]$")

    if (!regexNumber.matches(inputNumber)) {
        throw IllegalArgumentException("입력한 문자열이 숫자가 아닙니다.")
    }
}

fun validateLength(inputNumber: String) {
    val regexLength = Regex("^{3}$")

    if (!regexLength.matches(inputNumber)) {
        throw IllegalArgumentException("입력한 문자열의 길이가 3이 아닙니다.")
    }
}
