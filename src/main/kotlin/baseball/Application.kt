package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


var is_continue : Int = 1
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while(is_continue == 1){
        startGame()

    }
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

fun inputError(player: Array<Int>) {
    if (player.contains(0) || player.toSet().size != 3 || player.size != 3) {
        throw IllegalArgumentException("올바른 값을 입력하세요")
    }
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

fun startGame() {
    var computer : List<Int> = computerNumber()
    runningGame(computer)
}
fun runningGame(computer : List<Int>) {
    var player : List<Int> = playerNumber()
    inputError(player)
    var (strike_count, ball_count) = compareNum(computer,player)

    if( strike_count == 3) {
        gameOver()
    }else if(strike_count == 0 && ball_count == 0){
        println("낫싱")
        runningGame(computer)
    }else{
        if(ball_count != 0) print("${ball_count}볼")
        if(strike_count != 0) print("${strike_count}스트라이크")
        println()
        runningGame(computer)
    }

}

fun gameOver() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    is_continue = Console.readLine()!!.toInt()

}
