package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        //게임 시작 문구
        println("숫자 야구 게임을 시작합니다.")

        //컴퓨터 랜덤 3자리 수 뽑기
        val computer = computerRandom()

        playerGuess(computer)

        var gameControl = replayOrQuit()

        if (gameControl == 1){
            continue
        }
        if (gameControl == 2){
            println("게임 종료")
            break
        }
    }
}

//컴퓨터 랜덤 3자리 수 뽑기
fun computerRandom() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

//player 숫자 입력
fun inputPlayer() : MutableList<Int> {
    //플레이어 3개 숫자 입력
    var playerString: MutableList<String>
    var playerInt = mutableListOf<Int>()

    //input 메서드
    var number= Console.readLine()

    playerString = number.split("").toMutableList() //입력받은 숫자 쪼개는 거 구현하고 있었음 이어서 하셈 미래의 현지~!
    playerString.removeAt(playerString.size-1)
    playerString.removeAt(0)

    for (i in (0 until playerString.size)){
        playerInt.add(playerString[i].toInt())
    }

    return playerInt
}

//스트라이크 기능 함수
fun strike(computer : MutableList<Int>, player : MutableList<Int>) : Int {
    var count = 0

    for (i in (0..2)){
        if (computer[i] == player[i]){
            count += 1
        }
    }
    return count
}

//볼 기능 함수
fun ball(computer : MutableList<Int>, player : MutableList<Int>) : Int {
    var count = 0

    for (i in (0..2)){
        for (j in (0..2)){
            count += ballcompare(i, j, computer, player)
        }
    }
    return count
}
//ballcompare 함수
fun ballcompare (i : Int, j : Int, computer: MutableList<Int>, player: MutableList<Int>) : Int {
    var count = 0
    if (computer[i] == player[j]){  //인덴트 문제 3
        count = 1
    }
    return count
}

//판단
fun judgeAndPrint (strike : Int, ball : Int) : Int {
    var control = 0

    //낫싱일 때
    if (strike == 0 && ball == 0){
        println("낫싱")
    }

    //볼만 있을 때
    if (strike == 0 && ball != 0){
        println(ball.toString() + "볼")
    }

    //스트라이크만 있을 때
    if (strike != 0 && ball == 0 ){
        //맞춰서 게임 종료
        if (strike == 3 ){
            println(strike.toString() + "스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

            control = 1
        }
        if (strike != 3){
            println(strike.toString() + "스트라이크")
        }
    }

    //볼 스트라이크 둘다 있을 때
    if (strike != 0 && ball != 0){
        println(ball.toString() + "볼 " + strike.toString() + "스트라이크")
    }

    return control
}

//사용자가 답을 맞추는 함수
fun playerGuess(computer: MutableList<Int>) {
    var strike : Int
    var ball : Int

    while (true){
        //입력
        var player = inputPlayer()

        //strike, ball 확인
        strike = strike(computer, player)
        ball = ball(computer, player) - strike

        //strike, ball 출력
        var control = judgeAndPrint(strike, ball)

        //게임 종료 및 재시작
        if (control == 0){
            continue
        }
        if (control == 1){
            break
        }
    }
}

fun replayOrQuit () : Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var gameControl = Console.readLine().toInt()

    return gameControl
}
