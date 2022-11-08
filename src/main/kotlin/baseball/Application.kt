package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    baseballGame()
}

fun baseballGame(){
    println("숫자 야구 게임을 시작합니다.")

    var gameOnOff = 1
    while(gameOnOff == 1){
        var computer = cptChooseRandomNum()

        do{
            var user = userChooseNum()
            countForHint(computer, user)
        }while(user.toString() != computer.toString())

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameOnOff = readLine()!!.toInt()
    }
}

fun cptChooseRandomNum():List<Int>{ // 컴퓨터가 서로 다른 랜덤한 수 3개를 뽑게 하는 함수
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun userChooseNum():List<Char>{ // 사용자가 서로 다른 수 3개를 입력하게 하는 함수
    print("숫자를 입력해주세요 : ")
    val userGuessNum = readLine()!!.toList()
    val userGuessNumString = userGuessNum.toString()

    if(userGuessNumString.toIntOrNull() != null || userGuessNum.size != 3 || userGuessNum.distinct().size != 3){
        throw IllegalArgumentException()
    }

    return userGuessNum
}

fun countForHint(computer:List<Int>, user:List<Char>){ // 힌트 기능을 구현하는 함수
    var strike = 0
    var ball = 0

    for(i in 0..2){
        var userGuessNumber = user[i].toString().toInt()
        if(computer.contains(userGuessNumber) && userGuessNumber == computer[i]) strike++
        else if(computer.contains(userGuessNumber) && userGuessNumber != computer[i]) ball++
    }

    if(strike == 3) println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    else if(strike != 0 && ball != 0) println("${ball}볼 ${strike}스트라이크")
    else if(strike == 0 && ball == 0) println("낫싱")
    else if(strike != 0) println("${strike}스트라이크")
    else if(ball != 0) println("${ball}볼")
}