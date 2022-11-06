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

fun isInputAnswer(computerNum: Int): Boolean{

}