package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun printStartMessage(){
    println("숫자 야구 게임을 시작합니다")
}

fun createComputerAnswer() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.count() < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputUserNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val input = readLine()
    return input!!.map { it.toString().toInt() }.toMutableList()
}

fun checkBall( computer : MutableList<Int>, user : MutableList<Int> ) : Int {
    var ballCount = 0
    for(i in 0..2) {
        if (user[i] == computer[(i+1)%3]){
            ballCount += 1
        }
        if (user[i] == computer[(i+2)%3]){
            ballCount += 1
        }
    }
return ballCount
}

fun checkStrike( computer : MutableList<Int>, user : MutableList<Int> ) : Int {
    var strikeCount = 0
    for(i in 0..2) {
        if (user[i] == computer[i]){
            strikeCount += 1
        }
    }
    return strikeCount
}

fun printHintMessage(ball : Int, strike : Int){
    if(ball == 0 && strike ==0){
        println("낫싱")
    }
    if(ball == 0 && strike !=0){
        println("${strike}스트라이크")
    }
    if(ball != 0 && strike ==0){
        println("${ball}볼")
    }
    if(ball != 0 && strike !=0){
        print("${ball}볼 ")
        println("${strike}스트라이크")
    }


}

fun main() {
    printStartMessage()
    val computer = createComputerAnswer()

    println(computer)

    var user = inputUserNumber()

    println(user)

    var ball = checkBall(computer,user)
    var strike = checkStrike(computer,user)

    printHintMessage(ball,strike)
}
