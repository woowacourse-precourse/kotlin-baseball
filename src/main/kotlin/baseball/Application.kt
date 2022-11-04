package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
}

fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
    val computerNumber = makeNumber()
    print(computerNumber)

//    while(true){
        print("숫자를 입력해주세요 : ")
        val inputNumber = camp.nextstep.edu.missionutils.Console.readLine()
        val ballCount = countBall(computerNumber, inputNumber)
//    }
}

fun makeNumber(): String{
    var computer = ""
    while (computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer += randomNumber
        }
    }
    return computer
}

fun countBall(computerNumber: String, inputNumber: String): Int{
    var ballCnt = 0
    for(n in computerNumber){
        if(inputNumber.contains(n)){
            ballCnt++
        }
    }
    return ballCnt
}

fun countStrike(){}
fun printResult(){}
fun isGameOver(){}