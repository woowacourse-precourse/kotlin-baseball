package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        // TODO()
        println("숫자 야구 게임을 시작합니다.")

        if(getEndloopCondition()) break
    }
}


fun getEndloopCondition(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    val input = Console.readLine()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when (input) {
        "1" -> return false
        "2" -> return true
        else -> throw IllegalArgumentException("1 또는 2를 입력해주세요.")
    }
}