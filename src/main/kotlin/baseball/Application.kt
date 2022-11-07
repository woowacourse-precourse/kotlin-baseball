package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

private fun setRandomNumber(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

private fun getNumberOfStrike(computer: String, user: String): Int {
    val computerNumber: String = computer
    val userNumber: String = user
    var numberOfStrike = 0
    for(i in 0..2){
        if(computerNumber[i] == userNumber[i]){
            numberOfStrike++
        }
    }
    return numberOfStrike
}

private fun getNumberOfBall(computer: String, user: String): Int {
    val computerNumber: String = computer
    val userNumber: String = user
    var numberOfBall = 0
    for(i in 0..2){
        if(computerNumber.contains(userNumber[i]) && computerNumber[i] != userNumber[i]){
            numberOfBall++
        }
    }
    return numberOfBall
}


