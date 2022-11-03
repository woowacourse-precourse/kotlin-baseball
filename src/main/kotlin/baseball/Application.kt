package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val computerNumList = computerNum()
    println("숫자 야구 게임을 시작합니다.")

    ballCount(readNum(), computerNumList)


}

fun readNum(): MutableList<String> {
        print("숫자를 입력하세요 : ")
        val computerNumList = computerNum()
        val number = readLine()!!
        val numberArray = number.split("") as MutableList<String>
        val newArray = mutableListOf<String>()
        numberArray.removeAt(0)
        numberArray.removeAt(numberArray.size - 1)

        if (number.length != 3) {
            throw IllegalArgumentException()
        }

        for (i in 0..2) {
            if (newArray.contains(numberArray[i])) {
                throw IllegalArgumentException()
            }
            newArray.add(numberArray[i])
        }
       return newArray
}

fun computerNum(): MutableList<String> {
    val computer = mutableListOf<String>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun ballCount(playerList: MutableList<String>, computerList: MutableList<String>){

    var ball = 0
    var strike = 0

    for (i in 0..2) {
        if (playerList[i] == computerList[i]) {
            strike++
        }
        else if (playerList[i].contains(computerList[i])) {
            ball++
        }
    }


    if (strike == 0 && ball == 0) {
        println("낫싱")
    }
    else if (ball == 0) {
        println("${strike}스트라이크")
    }
    else if (strike == 0) {
        println("${ball}볼")
    }
    else println("${strike}스트라이크 ${ball}볼")


//    return strike.toString()
}