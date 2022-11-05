package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
}
fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
    while(true){
        BaseballGame().processGame()
        if (inputNumberForRestartGame() == 2){
            println("게임 종료.")
            break
        }

    }
}
fun inputNumberForRestartGame(): Int{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = readLine()
    ThrowException().throwExceptionForRestartNumber(input)
    return input?.toInt()!!
}





