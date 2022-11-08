package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        // TODO()
        println("숫자 야구 게임을 시작합니다.")
        val userNum = getUserInput()

        if(getEndloopCondition()) break
    }
}

fun isValidateInput(userNum: String): String {
    if(userNum.length != 3) {
        throw IllegalArgumentException("3자리의 숫자를 입력해주세요")
    }
    if(userNum.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }
    if(userNum[0] == userNum[1] || userNum[0] == userNum[2] || userNum[1] == userNum[2]) {
        throw IllegalArgumentException("중복된 값이 있습니다.")
    }
    if(userNum.contains(char = '0')) {
        throw IllegalArgumentException("0은 입력할 수 없습니다.")
    }
    return userNum
}

fun getUserInput(): String {
    println("숫자를 입력해주세요 : ")
    return isValidateInput(Console.readLine())
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