package baseball

import camp.nextstep.edu.missionutils.Randoms
// import camp.nextstep.edu.missionutils.Console

fun make_number(): String { // 숫자생성
    val basic_list = mutableListOf<Int>()
    
    while (basic_list.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!basic_list.contains(randomNumber)) {
            basic_list.add(randomNumber)
        }
    }
    
    return basic_list.toString() // input_number이 string이니 일단 맞춰주는걸로
}

fun referee(computer : String, user : String): String { // 심판
    val answer : String // answer = "" 오류 발생
    var ball = 0
    var strike = 0
    
    for (i in 0 until user.length){ // 계산 파트
        if (user[i] == computer[i]) {
            strike += 1
        }
        else if (user[i] in computer) {
            ball += 1
        }
    }

    if (ball==0 && strike==0){ // 심판 선언 파트
        answer="낫싱"
    }
    else{
        if (ball == 0){
            answer=strike.toString()+"스트라이크"
        }else if(strike == 0){
            answer=ball.toString()+"볼"
        }else{
            answer=(ball.toString()+"볼")+" "+(strike.toString()+"스트라이크")
        }
    }

    return answer
}
fun main() {
    print("숫자를 입력해주세요 : ")
    val input_number = readLine()
    val computer_number = make_number()

    if (input_number!!.length > 3) // 예외 처리
        throw IllegalArgumentException() // throw??

    println(referee(computer_number, input_number))
}
