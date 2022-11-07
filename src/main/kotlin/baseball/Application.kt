package baseball

import java.util.*


fun randomNum(): List<Char> {
    val tmp = mutableSetOf<Int>()
    while (tmp.size < 3) {    // Set의 특성을 이용 세 자리의 중복없는 정답생성
        tmp.add(Random().nextInt(9))
    }
    return tmp.toString().toList().filter { it.isDigit() }
}



fun main() {

    println("숫자 야구 게임을 시작합니다.")

    var gameStart = 1
    var count = 1
    while (gameStart == 1){
        try {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameStart = readLine()!!.toInt()
            ++count
            if ((gameStart != 1) and (gameStart != 2)){
                throw IllegalArgumentException("입력 오류")
            }
        }catch (e: IllegalArgumentException){
            throw IllegalArgumentException("입력 오류")
        }
    }
    println("게임 종료")

}
