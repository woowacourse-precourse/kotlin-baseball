package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

private fun setRandomNumber():String {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
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

private fun printGameResult(computer: String, user: String){
    val numberOfBall = getNumberOfBall(computer, user)
    val numberOfStrike = getNumberOfStrike(computer, user)
    when {
        numberOfBall != 0 -> {
            print(numberOfBall.toString()+"볼")
        }
        numberOfStrike != 0 -> {
            print(numberOfStrike.toString()+"스트라이크")
        }
        else -> {
            print("낫싱")
        }
    }
}
