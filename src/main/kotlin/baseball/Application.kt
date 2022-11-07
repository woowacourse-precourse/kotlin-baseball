package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {

    // 시작
    while (true) {
        // 랜덤 숫자 3개 받아오기
        val computer = randomThreeNumber()

        // 게임 진행
        val finish = gameStart(computer)

        // 게임 시작 or 종료
        if (restartOrFinish(finish)) break
    }
}

// 게임 시작 or 종료
private fun restartOrFinish(finish: Boolean): Boolean {
    if (!finish) return false

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (val choice = Console.readLine()) {
        "1" -> false
        "2" -> true
        else -> throw IllegalArgumentException("게임 새로 시작, 종료 조건에 맞지 않음 : $choice")
    }
}


// 게임 시작
private fun gameStart(computer: String): Boolean {
    while (true) {
        // 추측 숫자
        val number = guessNumber()

        // 사용자에게 받은 숫자 체크(볼, 스트라이크, 예외사항)
        val (ball, strike) = userNumberCheck(number, computer)

        // 사용자 넘버 결과 출력
        println(userNumberCheckResult(ball, strike))

        //  스트라이크 3개면 종료
        if (strike == 3) return true
    }
}

// 넘버 체크 결과 출력
private fun userNumberCheckResult(ball: Int, strike: Int): String {
    // 아무것도 해당 없을 경우, 볼 카운트, 스트라이크 카운트
    val resultArray = mutableListOf<String>()
    if (ball == 0 && strike == 0) resultArray.add("낫싱")
    if (ball != 0) resultArray.add("${ball}볼")
    if (strike != 0) resultArray.add("${strike}스트라이크")
    // 예외
    if (resultArray.size == 0) throw IllegalArgumentException("undefined error")

    return resultArray.joinToString(" ")
}

// 사용자에게 받은 숫자 체크(볼, 스트라이크, 예외사항)
private fun userNumberCheck(number: String, computer: String): Pair<Int, Int> {
    var ball = 0    // 볼 카운트
    var strike = 0  // 스트라이크 카운트
    for (i in 0 until 3) {
        if (number[i] == computer[i]) strike += 1
        if (number[i] != computer[i] && number[i].toString() in computer) ball += 1
    }
    return Pair(ball, strike)
}

// 숫자 맞추기
private fun guessNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userNumber = Console.readLine()
    // 중복 숫자 체크
    val number = userNumber.toSet().joinToString("")

    var check = true

    // 3개가 아닐 경우 에러
    if (number.length != 3) check = false
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
    val computer = mutableSetOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        computer.add(randomNumber)
    }

    println(computer)

    return computer.joinToString("")
}
