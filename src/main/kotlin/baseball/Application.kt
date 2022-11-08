package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import org.mockito.internal.matchers.Null
import java.util.*

fun checkTrue(input : String) : Array<Int>{
    var inputNum = input.toIntOrNull()
    if(inputNum == null) throw IllegalArgumentException("숫자가 아닙니다.")
    if(inputNum<100||inputNum>=1000) throw IllegalArgumentException("세개의 숫자를 입력하여야 합니다.")

    var first = inputNum/100
    var second = (inputNum-first*100)/10
    var third = inputNum%10

    var input : Array<Int> = arrayOf(first,second,third)

    if(input[0] == 0||input[1] == 0||input[2] == 0) throw IllegalArgumentException("0이 포함되어있습니다.")
    if(input[0]== input[1])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")
    if(input[1] == input[2])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")
    if(input[2] == input[0])  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다")
    return input

    }



fun random():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while (computer.count() < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun checkCorrect(now : Int, input:Array<Int>):Int{
    for(i in 0 until 3){
        if(now == input[i]) return i
    }
    return -1
}

fun countCorrect(computer:MutableList<Int>,input:Array<Int>):MutableList<Int>{
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


fun print(strike_ball: MutableList<Int>) : Int{
    if (strike_ball[0] == 0 && strike_ball[1] == 0) {
        println("낫싱")
        return 0
    }
    else if (strike_ball[0] ==3) {
        println("3스트라이크")
        return 1
    }
    else if (strike_ball[0] == 0) {
        println("${strike_ball[1]}볼")
        return 0
    } else if (strike_ball[1] == 0) {
        println("${strike_ball[0]}스트라이크")
        return 0
    } else {
        print("${strike_ball[1]}볼 ${strike_ball[0]}스트라이크")
        return 0
    }
}

fun input(Computer: MutableList<Int>){
    while(true) {
        val input = readLine()!!.toString()
        var input_array : Array<Int> = checkTrue(input)
        val strike_ball = countCorrect(Computer, input_array)
        if (print(strike_ball) == 1) return
    }
}

//메인
fun main() {

    var Continue = 1

    while (Continue == 1) {
        val ComputerNum = random()

       input(ComputerNum)

        println("모든 수를 맞히셨습니다. 계속하려면 1, 종료하려면 2를 눌러주세요")
        var input_again = readLine()!!.toInt()
        if(input_again !=2 ||input_again !=1) throw IllegalArgumentException("1또는 2를 입력하여야 합니다.")
        if(input_again == 2) {
            Continue = 0
            println("게임종료")
        }
    }

}
