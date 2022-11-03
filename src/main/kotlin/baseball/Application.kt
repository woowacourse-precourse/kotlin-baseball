package baseball

// 기능 목록
// 1. "숫자 야구 게임을 시작합니다." 출력, 게임 함수 실행
// 2. 임의의 수 설정
// 3. "숫자를 입력해주세요:" 출력 후, 3자리 숫자 입력 받기.
// 4. 숫자가 서로 다른 3자리 수가 아니거나 각 자릿수에 0이 있으면, IllegalArgumentException 발생 후 종료
// 5. 입력 받은 숫자와 임의의 수 3개를 비교하는 함수를 이용해 비교하고 결과 출력
// 6. 4번 기능 반복
// 7. 임의의 수와 입력 받은 수가 일치하면 기능 종료 및 재시작 여부 확인
// 8. 재시작 여부에 따라 다시 함수 실행

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    game()
}

fun game() {
    val computerNum = computerRandomNum()

    print("숫자를 입력해주세요 : ")
    val num = readLine()

    rightInput(num)

}

fun computerRandomNum(): MutableSet<Int> {
    val numSet = mutableSetOf<Int>()
    while (numSet.size<=2) {
        numSet.add((1..9).random())
    }
    return numSet
}

fun rightInput(inputStr: String?) {
    val inputSet = mutableSetOf<Char>()

    for (i in 0 until inputStr!!.length) {
        if (inputStr[i] != '0') {
            inputSet.add(inputStr[i])
        }
    }

    if (inputSet.size != 3) {
        throw IllegalArgumentException()
    }
}