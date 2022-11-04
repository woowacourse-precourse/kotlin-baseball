package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
}

fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
    val computerNumber = makeNumber()
}
fun countBall(){}
fun countStrike(){}
fun printResult(){}
fun isGameOver(){}
fun makeNumber(): String{
    var computer = ""
    while (computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer += randomNumber
        }
    }

    return computer
}
