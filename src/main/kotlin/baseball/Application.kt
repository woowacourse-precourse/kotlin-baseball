package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
}
fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
    while(true){
        BaseballGame().processGame()
        if (getNumberForRestartGame() == 2){
            println("게임 종료.")
            break
        }

    }
}

/**
 * 숫자를 입력받고 예외 체크 후 반환하는 함수
 */
fun getNumberForRestartGame(): Int{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = readLine()
    ThrowException().throwExceptionForRestartNumber(input)
    return input?.toInt()!!
}





