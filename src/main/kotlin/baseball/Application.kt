package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

fun main() {

    val computer : List<Int> = setRandomNumber()
    val player = mutableListOf<Int>()

    printStartMessage()
    getPlayerNumber(player)
    println(player)
}

fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun setRandomNumber() : List<Int>{
    val com : MutableSet<Int> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

    while(com.size < 3) {
        val random = Randoms.pickNumberInRange(1, 9)
        com.add(random)
    }

    return com.toList()
}

fun getPlayerNumber(player: MutableList<Int>){
    print("숫자를 입력해 주세요: ")
    val input = readLine()!!

    // 예외 처리
    if (!Pattern.matches("^[1-9]{3}$", input) || input.toCharArray().size != input.toCharArray().distinct().count()){
        throw IllegalArgumentException("서로 다른 수로 이루어진 세 자리 정수를 입력해 주세요.")
    }

    var num = input.toInt()
    var div = 100

    for(i in 0 until 3){
        player.add(num / div)
        num %= div
        div /= 10
    }
}


