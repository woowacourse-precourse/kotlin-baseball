package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

fun main() {

    var exit = false

    while(!exit) {

        val computer : List<Int> = setRandomNumber()
        val player = mutableListOf<Int>()
        var clear = false

        printStartMessage()
        println("computer: $computer")
        while(!clear) {
            getPlayerNumber(player)
            println("player: $player")
            clear = compareNumber(computer, player)
        }
        exit = getReplaySignal()
    }

    print("게임을 종료합니다.")
}


private fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

private fun setRandomNumber() : List<Int>{
    val com : MutableSet<Int> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

    while(com.size < 3) {
        val random = Randoms.pickNumberInRange(1, 9)
        com.add(random)
    }

    return com.toList()
}

private fun getPlayerNumber(player: MutableList<Int>){
    print("숫자를 입력해 주세요: ")
    val input = readLine()!!

    // 예외 처리
    if (!Pattern.matches("^[1-9]{3}$", input)
        || input.toCharArray().size != input.toCharArray().distinct().count()){
        throw IllegalArgumentException("서로 다른 수로 이루어진 세 자리 정수를 입력해 주세요.")
    }

    var num = input.toInt()
    var div = 100

    player.clear()

    for(i in 0 until 3){
        player.add(num / div)
        num %= div
        div /= 10
    }
}

private fun compareNumber(computer: List<Int>, player: List<Int>): Boolean{
    val strike = getStrikeCount(computer, player)
    val ball = getBallCount(computer, player) - strike
    var message = ""

    if (ball >= 1) {
        message = "${ball}볼 "
    }

    if (strike >= 1) {
        message += "${strike}스트라이크"
    }

    if (ball == 0 && strike == 0) {
        message = "낫싱"
    }

    println(message)

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }

    return false
}
private fun getBallCount(computer: List<Int>, player: List<Int>) : Int {
    var ball = 0

    for(i in 0 until 3){
        if(computer.contains(player[i])){
            ball += 1
        }
    }

    return ball
}

private fun getStrikeCount(computer: List<Int>, player: List<Int>) : Int{
    var strike = 0

    for(i in 0 until 3) {
        if(computer[i] == player[i]){
            strike += 1
        }
    }

    return strike
}

private fun getReplaySignal() : Boolean{
    var input = ""
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        while (true) {
            input = readLine()!!
            // 예외 처리
            if (!Pattern.matches("^[1-2]{1}$", input)) {
                println("1과 2 중 하나를 입력해 주세요.")
                continue
            }
            break
        }

        when (input.toInt()) {
            1 -> input = "false"
            2 -> input = "true"
        }

        return input.toBoolean()
}



