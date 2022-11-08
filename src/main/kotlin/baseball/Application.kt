package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    println("숫자 야구 게임을 시작합니다.")
}

fun computerNumber() : List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playerNumber() : List<Int>{
    print("숫자를 입력해주세요 :")
    val playerInput = Console.readLine()!!

    val player = mutableListOf<Int>()
    playerInput.forEach { player.add(it-'0') }

    return player
}

fun inputError() {

}

data class Score(var strike_count : Int, var ball_count : Int)
fun compareNum(computer : List<Int>, player : List<Int>) : Score{
    var strike_count : Int = 0
    var ball_count : Int = 0
    for (i in 0..2){
        if(computer[i] == player[i]) strike_count += 1
        else if(player.contains(computer[i])) ball_count += 1
    }

    return Score(strike_count, ball_count)
}

fun runningGame() {

    var computer : List<Int> = computerNumber()
    var player : List<Int> = playerNumber()

    val (strike_count, ball_count) = compareNum(computer,player)

    if( strike_count == 3) {
        // game_over()
    }else if(strike_count == 3 && ball_count == 0){
        println("낫싱")
    }else{
        if(ball_count != 0) print("$ball_count 볼")
        if(strike_count != 0) print("$strike_count 스트라이크")
        println()
    }

}