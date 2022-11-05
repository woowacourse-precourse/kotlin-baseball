package baseball

import camp.nextstep.edu.missionutils.Randoms

/*
*   1. 컴퓨터가 랜덤 100 ~ 999 사이의 숫자 생성
*   2. 사용자 숫자 입력
*   3. 볼, 스트라이크 판단
*   4. 선택한 3개의 숫자를 모두 맞히면 게임 종료
* */

fun generateRandomNumber() : MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return computer
}


fun main() {
    //TODO("프로그램 구현")
}
