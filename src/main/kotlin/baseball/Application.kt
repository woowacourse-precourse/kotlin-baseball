package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    var gameStart = 1
    while(gameStart == 1){
        val computerNum = setComputerNum()
        Play(computerNum)
        gameStart = finishGame()
    }
    println("게임 종료")
}

fun setComputerNum(): MutableList<Int>{
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNum.contains(randomNumber)){
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

fun inputNum(stringInput: String): MutableList<Int>{
    val input = isInputError(stringInput, 0, 999)
    var playerInput = mutableListOf<Int>()
    playerInput = changeIntToMutableListInt(input)
    return playerInput
}

fun isInputError(stringInput: String, startRange:Int, endRange:Int): Int{
    val input = stringInput.toIntOrNull()
    if (input == null || !(input in startRange..endRange)){
        throw IllegalArgumentException("${startRange}~${endRange} 값을 입력하지 않으셨습니다.")
    }
    return input
}

fun changeIntToMutableListInt(input: Int): MutableList<Int>{
    val output = mutableListOf<Int>()
    var dividedNum = input
    while(dividedNum>0){
        output.add(dividedNum%10)
        dividedNum/=10
    }
    output.reverse()
    return output
}

fun isInputAnswer(computerNum: MutableList<Int>, playerInput: MutableList<Int>): Boolean{
    var ball = 0
    var strike = 0
    for (digit in 0..2){
        if (computerNum[digit] == playerInput[digit] ){
            strike++
        }
    }
    for (digit in 0..2){
        if(computerNum.contains(playerInput[digit])){
            ball++
        }
    }
    ball -= strike

    println(printResult(ball, strike))
    if(strike==3){
        return true
    }
    return false
}

fun printResult(ball:Int, strike:Int):String{
    var output:String =""
    if (ball>0 && strike==0){
        output = "${ball}볼"
    }
    if (ball==0 && strike>0){
        output = "${strike}스트라이크"
    }
    if (ball>0 && strike>0){
        output = "${ball}볼 ${strike}스트라이크"
    }
    if (ball==0 && strike ==0){
        output = "낫싱"
    }
    return output
}

fun finishGame(): Int {
    println(
        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    )
    val input = Console.readLine()
    return isInputError(input, 1,2)
}

fun Play(computerNum: MutableList<Int>){
    var isStrike = false
    while(!isStrike){
        val input = Console.readLine()
        val playerInput = inputNum(input)
        isStrike = isInputAnswer(computerNum, playerInput)
    }
}