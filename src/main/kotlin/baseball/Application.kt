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
    while ( computer.size < 3 ) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun receiveUserInput() : MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()!!.toInt()

    // userInput을 분리해 리스트로 저장한다
    val userInputList: MutableList<Int> = mutableListOf()
    // 100의 자리
    val hundredth = userInput - userInput % 100
    // 10의 자리
    val tenth = userInput - hundredth - userInput % 10
    // 1의 자리
    val oneth = userInput - hundredth - tenth

    userInputList.add(hundredth / 100)
    userInputList.add(tenth / 10)
    userInputList.add(oneth)

    return userInputList
}



fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = generateRandomNumber()
    var userInputList = receiveUserInput()
}
