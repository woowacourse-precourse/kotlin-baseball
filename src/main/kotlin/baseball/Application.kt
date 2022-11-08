package baseball

import camp.nextstep.edu.missionutils.Randoms

fun calculatePoint(inputNumber:Int, computerNum: MutableList<Int>):Int {
    val input0:Int = inputNumber / 100
    val input1:Int = inputNumber % 100 / 10
    val input2:Int = inputNumber % 10
    var result = 0
    if(computerNum[0] == input0) {
        result += 10
    }else if(computerNum.contains(input0)) {
        result += 1
    }
    if(computerNum[1] == input1) {
        result += 10
    }else if(computerNum.contains(input1)) {
        result += 1
    }
    if(computerNum[2] == input2) {
        result += 10
    }else if(computerNum.contains(input2)) {
        result += 1
    }
    return result
}

fun printPointAndIsGameDone(point:Int):Boolean {
    val strike:Int = point / 10
    val ball:Int = point % 10
    if(ball != 0) {
        print("${ball}볼 ")
    }
    if(strike != 0) {
        print("${strike}스트라이크")
    }

    if(ball == 0 && strike == 0) {
        println("낫싱")
    } else {
        println()
    }

    if(strike == 3) {
        return true
    }
    return false
}

fun isFinishGame():Boolean {
    val isFinish:Int = readLine()?.toInt() ?: 0
    if(isFinish == 1) {
        return false
    }
    if(isFinish == 2) {
        return true
    }
    throw IllegalArgumentException()
}

fun pickComputerNumber():MutableList<Int> {
    val computerNum:MutableList<Int> = mutableListOf()
    while(computerNum.size < 3) {
        val pickedNumber = Randoms.pickNumberInRange(1,9)
        if(computerNum.contains(pickedNumber)) continue
        else computerNum.add(pickedNumber)
    }
    return computerNum
}

fun playGame(computerNum: MutableList<Int>) {
    while(true) {
        print("숫자를 입력해주세요 : ")
        val inputNumber:Int = readLine()?.toInt()?:-1
        if(inputNumber == -1) {
            throw IllegalArgumentException()
        }
        if(inputNumber <= 100 || inputNumber >= 1000) {
            throw IllegalArgumentException()
        }
        val point:Int = calculatePoint(inputNumber, computerNum)
        if(printPointAndIsGameDone(point)) {
            return
        }
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while(true) {
        val computerNum = pickComputerNumber()
        playGame(computerNum)
        println("숫자 3개를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        if(isFinishGame()) {
            break
        }
    }

}

