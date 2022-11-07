package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun play(){

}
fun askContinue(): Boolean{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var answer: String = Console.readLine()
    if(answer !in "12"){
        throw IllegalArgumentException("입력 값이 1 또는 2가 아닙니다.")
    }
    return answer=="1"
}

fun main() {
    var flag: Boolean = true
    println("숫자 야구 게임을 시작합니다.")
    while(flag){
        play()
        flag = askContinue()
    }
}