package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
    val computerList = makeNumber()
    println(computerList.toString())

    val inputNumberList = getInput()
    println(inputNumberList.toString())
}

fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
}

fun makeNumber(): List<Int>{
    val computerList = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    return computerList
}

fun getInput(): List<Int>{
    print("숫자를 입력해주세요 : ")
    val returnNumber = mutableListOf<Int>()
    val inputNumber = Console.readLine()
    if(!checkError(inputNumber)){
        throw IllegalArgumentException("잘못된 입력입니다.")
    }

    inputNumber.toList()
    for(i in inputNumber){
        returnNumber.add(i.digitToInt())
    }
    return returnNumber
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

fun countStrike(computerNumber: String, inputNumber: String): Int{
    var strikeCnt = 0
    for(i in computerNumber.indices){
        val num = computerNumber.get(i)
        val index = inputNumber.indexOf(num)

        if(i == index){
            strikeCnt++
        }
    }
    return strikeCnt
}
fun printResult(strikeCnt: Int, ballCnt: Int){
    if(strikeCnt == 0 && ballCnt == 0){
        println("낫싱")
    }
    else if(strikeCnt == 0){
        println(ballCnt.toString() + "볼")
    }
    else if(ballCnt == 0){
        println(strikeCnt.toString() + "스트라이크")
    }
    else{
        println(ballCnt.toString() + "볼 " + strikeCnt.toString() + "스트라이크")
    }
}
fun isGameOver(){}

fun checkError(inputNumber: String): Boolean{
    for(i in inputNumber){
        if(i.digitToIntOrNull() == null){
            return false
        }
        if(i.digitToIntOrNull() == 0){
            return false
        }
    }
    if(inputNumber.length != 3){
        return false
    }
    return true
}