package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.*

fun checkTrue(input : CharArray){

    if(input[0]== input[1])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")
    if(input[1] == input[2])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")
    if(input[2] == input[0])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")

    if(input.size != 3) throw IllegalArgumentException("세개의 숫자를 입력하여야 합니다.")

    var isNum = 0

    for(i in 0 until 3){
        isNum = 0
        for(j in '1' .. '9'){
            if(input[i] == j){
                isNum = 1
                break
            }
        }
        if(isNum == 0) throw IllegalArgumentException("숫자가 아닙니다.")
        if(input[i] == '0') throw IllegalArgumentException("0이 포함되어있습니다.")
    }
}

fun random():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun countCorrect(computer:MutableList<Char>,input:CharArray):MutableList<Int>{
    var homerun_strike = mutableListOf<Int>()
    homerun_strike.add(0)
    homerun_strike.add(0)

    for(i in 0 until 3){
        for(j in 0 until 3){
            if(computer[i] == input[j]){
                if(i == j){
                    homerun_strike[0]++
                }else{
                    homerun_strike[1]++
                }
            }
        }
    }
    return homerun_strike
}

fun changeToChar(get : MutableList<Int>):MutableList<Char>{
    var getToChar = mutableListOf<Char>()
    for(i in 0..2){
        getToChar[i] = (get[i]+48).toChar()
    }
    return getToChar
}


fun main() {

    var Continue = 1

    while(Continue == 1) {

        val input = readLine()?.toCharArray()
        if (input != null) {
            checkTrue(input)
        } else throw IllegalArgumentException("입력 값이 없습니다.");

        val ComputerNum = random()
        val ComputerChar = changeToChar(ComputerNum)
        countCorrect(ComputerChar, input)

    }

}
