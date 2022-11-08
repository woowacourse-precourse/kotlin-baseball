package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

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
    var strikeBall = mutableListOf<Int>()
    strikeBall.add(0)
    strikeBall.add(0)
    strikeBall[0] = 0
    strikeBall[1] = 0

    for(i in 0 until 3){
       var same = checkCorrect(computer[i],input);
        if(same == i) strikeBall[0]++
        else if(same != -1) strikeBall[1]++
        }

    return strikeBall
}


fun print(strikeBall: MutableList<Int>) : Int{
    if (strikeBall[0] == 0 && strikeBall[1] == 0) {
        println("낫싱")
        return 0
    }
    else if (strikeBall[0] ==3) {
        println("3스트라이크")
        return 1
    }
    else if (strikeBall[0] == 0) {
        println("${strikeBall[1]}볼")
        return 0
    } else if (strikeBall[1] == 0) {
        println("${strikeBall[0]}스트라이크")
        return 0
    } else {
        println("${strikeBall[1]}볼 ${strikeBall[0]}스트라이크")
        return 0
    }
}

fun input(Computer: MutableList<Int>){
    while(true) {
        println("숫자를 입력해주세요")
        val input = Console.readLine()!!.toString()
        var inputArray : Array<Int> = checkTrue(input)
        val strikeBall = countCorrect(Computer, inputArray)
        if (print(strikeBall) == 1) break
    }
}

//메인
fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var continueGame = 1

    while (continueGame == 1) {
        val computerNum = random()

       input(computerNum)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var inputAgain = Console.readLine()!!.toInt()
        if(inputAgain !=2 &&inputAgain !=1) throw IllegalArgumentException("1또는 2를 입력하여야 합니다.")
        if(inputAgain == 2) {
            continueGame = 0
        }
    }

}
