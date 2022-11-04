package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}


private fun createComputerNum() : List<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {  //순서대로 백의 자리, 십의 자리, 일의 자리
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return computerNum
}
private fun isInputNumeric(input:String){
    val regex = "[1-9][1-9][1-9]".toRegex()

    if(!input.matches(regex)){
        throw IllegalArgumentException("세 자리의 숫자만 입력가능합니다")
    }
}

private fun separateNumberIntoDigit(inputNum: String): List<Int>{
    val inputNumberList = inputNum.toList()
    val firstNum = inputNumberList[0].toString().toInt()
    val secondNum = inputNumberList[1].toString().toInt()
    val thirdNum = inputNumberList[2].toString().toInt()

    return listOf(firstNum,secondNum,thirdNum)
}

private fun countStrikeAndBall(computerNum:List<Int>, inputNum: List<Int>): List<Int>{
    var strike = 0
    var ball = 0

    if(computerNum.contains(inputNum[0])){
        if(computerNum[0]==inputNum[0]){
            strike += 1
        }
        if(computerNum[0]!=inputNum[0]){
            ball += 1
        }
    }

    if(computerNum.contains(inputNum[1])){
        if(computerNum[1]==inputNum[1]){
            strike += 1
        }
        if(computerNum[1]!=inputNum[1]){
            ball += 1
        }
    }

    if(computerNum.contains(inputNum[2])){
        if(computerNum[2]==inputNum[2]){
            strike += 1
        }
        if(computerNum[2]!=inputNum[2]){
            ball += 1
        }
    }
    return listOf(strike, ball)
}