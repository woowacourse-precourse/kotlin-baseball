package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")

    val playerNumber = readNum()
    val computerNumber = computerNum()
    println(playerNumber.toString())
    computerNumber
    println(computerNumber)





}

fun readNum(): MutableList<String> {
    val number = readLine()!!
    val numberArray = number.split("") as MutableList<String>
    val newArray = mutableListOf<String>()
    numberArray.removeAt(0)
    numberArray.removeAt(numberArray.size - 1)

    if (number.length != 3) {
        throw IllegalArgumentException()
    }
    for(i in 0..2) {
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