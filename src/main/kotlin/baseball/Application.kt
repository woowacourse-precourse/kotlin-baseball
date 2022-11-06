package baseball

import camp.nextstep.edu.missionutils.Randoms // API 임포트

fun make_number(): String { // 숫자생성
    val basic_list = mutableListOf<Int>()
    
    while (basic_list.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)

        if (!basic_list.contains(randomNumber)) {
            basic_list.add(randomNumber)
        }
    }
    
    return basic_list.joinToString("")
}

fun input_number() : String { // 숫자입력
    val input_number = readLine()

    println("숫자를 입력해주세요 : "+input_number)

    return input_number.toString()
}

fun referee(computer: String, user: String): String { // 심판
    val answer : String // answer = "" 오류 발생
    var ball = 0
    var strike = 0
    
    for (i in 0 until user.length){ // 계산 파트
        if (user[i] == computer[i]) {
            strike += 1
        } else if (user[i] in computer) {
            ball += 1
        }
    }

    if (ball==0 && strike==0){ // 심판 선언 파트
        answer="낫싱"
    } else{
        if (ball == 0){
            answer=strike.toString()+"스트라이크"
        }else if(strike == 0){
            answer=ball.toString()+"볼"
        }else{
            answer=(ball.toString()+"볼")+" "+(strike.toString()+"스트라이크")
        }
    }

    println(answer) // 판정 출력

    return answer
}
fun main() {
    var user_number = input_number() // 숫자 입력
    val computer_number = make_number() // 숫자 생성

    if (user_number.length > 3) { // 예외 처리
        throw IllegalArgumentException() // throw??
    }

    while (true) {
        if (referee(computer_number, user_number) == "3스트라이크") { // 게임 종료시 루프 탈출
            break
        }
        user_number = input_number() // 입력 갱신
    }

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    user_number = input_number() // 입력 갱신

    if ( user_number == "1"){ // 1일경우 다시시작
        main()
    }
    else { // 2일경우 종료
        println("게임 종료")
    }
}