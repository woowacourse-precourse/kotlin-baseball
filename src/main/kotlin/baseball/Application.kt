package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        playNumberBaseballGame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = Console.readLine()
        if(userInput=="1")
            continue
        else if(userInput == "2")
            break
        else
            throw IllegalArgumentException()
    }while (true)
    print("게임 종료")
}

fun playNumberBaseballGame(){
    val answerNumberArray= makeAnswerNumber()
    do {
        println("숫자를 입력해주세요 : ")
        val userInput = Console.readLine()
        val userInputArray = makeNumToList(userInput.toInt())
        if(!checkNumberValid(userInputArray))
            throw IllegalArgumentException()
        val (strike,ball) = countStrikeBall(answerNumberArray,userInputArray)
        val result = printStrikeBall(strike,ball)
        println(result)
        if(strike==3)
            break
    }while(true)
}

fun makeAnswerNumber():List<Int>{
    val answerNumberArray = mutableListOf<Int>()
    while (answerNumberArray.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answerNumberArray.contains(randomNumber)) {
            answerNumberArray.add(randomNumber)
        }
    }
    return answerNumberArray
}

fun checkNumberValid(num: List<Int>):Boolean{

    if(num.distinct().size != 3)
        return false

    for (n in num){
        if(n<1 || n>9)
            return false
    }
    return true
}

fun makeNumToList(num:Int):List<Int>{
    var n = num
    val numArray = mutableListOf<Int>()
    while(true){
        if(n==0)
            break
        numArray.add(n%10)
        n/=10
    }
    numArray.reverse()
    return numArray
}

fun countStrikeBall(answerArray:List<Int>,inputArray:List<Int>): Pair<Int,Int>{
    var strikeCnt = 0
    var ballCnt = 0
    for(input in inputArray.indices){
        if (answerArray[input]==inputArray[input])
            strikeCnt ++
        else if(answerArray.contains(inputArray[input]))
            ballCnt ++
    }
    return Pair(strikeCnt,ballCnt)
}

fun printStrikeBall(strike:Int, ball:Int): String {
    if(strike > 0 && ball > 0){
        return "${ball}볼 ${strike}스트라이크"
    } else if (strike == 0 && ball > 0){
        return "${ball}볼"
    } else if (strike > 0 && ball == 0) {
        return "${strike}스트라이크"
    }
    return "낫싱"
}
