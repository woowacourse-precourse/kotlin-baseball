package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }


}
fun k_Baseball(num : Int, comp : IntArray){
    val list = mutableListOf<Int>()
    var str = 0
    var ball = 0
    var result = 1
    for (i in 0..2){
        if (comp[i] == list[i]) str++
        else if (list[i] in comp) ball++
        else continue
    }

    while (result < 2) {
        if (str == 0 && ball == 0) str0_ball0()
        else if (str == 0) only_Ball(ball)
        else if (str == 3) Clear()
        else if (ball == 0) only_Strike(str)
        else str_ball(str, ball)
    }

}
fun str0_ball0(){
    return println("낫싱")
}

fun only_Ball(ball : Int){
    return println("${ball}볼")
}

fun only_Strike(str : Int){
    return println("${str}스트라이크")
}

fun str_ball(str : Int, ball : Int){
    println("${ball}볼 ${str}스트라이크")
}

fun Clear() : Int{
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var n : Int = readLine()!!.toInt()
    return n
}