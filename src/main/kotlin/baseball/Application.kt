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
fun checkCorrect(now : Char, input:CharArray):Int{
    for(i in 0 until 3){
        if(now == input[i]) return i
    }
    return -1
}

fun countCorrect(computer:MutableList<Char>,input:CharArray):MutableList<Int>{
    var strike_ball = mutableListOf<Int>()
    strike_ball.add(0)
    strike_ball.add(0)

    for(i in 0 until 3){
       var same = checkCorrect(computer[i],input);
        if(same == i) strike_ball[0]++
        else if(same != -1) strike_ball[1]++
        }

    return strike_ball
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

    while (Continue == 1) {

        val input = readLine()?.toCharArray()
        if (input != null) {
            checkTrue(input)
        } else throw IllegalArgumentException("입력 값이 없습니다.");

        val ComputerNum = random()
        val ComputerChar = changeToChar(ComputerNum)
        var strike_ball = countCorrect(ComputerChar, input)

        if (strike_ball[0] == 0 && strike_ball[1] == 0) {
            print("낫싱")
        } else if (strike_ball[0] == 0) {
            print("${strike_ball[1]}볼")
        } else if (strike_ball[1] == 0) {
            print("${strike_ball[0]}스트라이크")
        } else {
            print("${strike_ball[0]}스트라이크 ${strike_ball[1]}볼")
        }


    }

}
