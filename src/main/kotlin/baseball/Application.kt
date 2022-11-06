package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    TODO("프로그램 구현")
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
    val input = stringInput.toIntOrNull()
    var playerInput = mutableListOf<Int>()
    if (input == null || !(input in 0..999)){
        throw IllegalArgumentException("0~999의 값을 입력하지 않으셨습니다.")
    }
    if (input in 0..999){
       playerInput = changeIntToMutableListInt(input)
    }
    return playerInput
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

    //printResult(ball, strike)
    if(strike==3){
        return true
    }
    return false
}