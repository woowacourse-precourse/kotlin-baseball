package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // 시작
    while (true) {
        // 랜덤 숫자 3개 받아오기
        val computer = randomThreeNumber()

        // 게임 진행, 3스트라이크일 경우 true 리턴
        val finishGame = gameStart(computer)


    }
}

// 게임 시작
private fun gameStart(computer: String): Boolean {
    while (true) {
        // 사용자 입력 숫자
        val userNumber = guessNumber()



    }
}

// 사용자에게 숫자 받기
private fun guessNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userNumber = Console.readLine()

    var check = true


    // 중복 숫자 체크
    val number = userNumber.toSet().joinToString("")
    // 3개가 아닐 경우 에러
    if (number.length != 3) check = false
    // 문자 체크
    for (i in number) {
        // 1~9까지만
        if (i !in '1'..'9') {
            check = false
            break
        }
    }

    // 예외처리
    if (check) return number
    throw IllegalArgumentException("숫자 입력 조건에 맞지 않음 : $number")
}

// 랜덤 3글자 추출
private fun randomThreeNumber(): String {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumber !in computer) computer.add(randomNumber)
    }

    println(computer)

    return computer.joinToString("")
}
