package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNumber = createRandomNumber()
    print(computerNumber)
    val userNumber = inputUserNumber()
    playBaseball(computerNumber, userNumber)
}

fun createRandomNumber(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains((randomNumber))) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val user = readLine().toString()
    if(isNumber(user)){
       return checkNumber(user)
    }
    return checkNumber(user)
}

fun checkNumber(user:String): List<Int> {
    val userNumber = user.map{ it.code - '0'.code }

    if(userNumber.size != 3){
        println("3자리 숫자만 입력 가능합니다. 다시 입력해주세요.")
        inputUserNumber()
    }
    else if(userNumber.contains(0)){
        println("0은 포함할 수 없습니다. 다시 입력해주세요.")
        inputUserNumber()
    }
    else if(userNumber.size != userNumber.distinct().count()){
        println("숫자를 중복할 수 없습니다. 다시 입력해주세요.")
        inputUserNumber()
    }
    return userNumber
}

fun isNumber(user:String): Boolean {
    return try {
        user.toInt()
        true
    } catch (e: NumberFormatException) {
        println("문자는 포함할 수 없습니다. 다시 입력해주세요.")
        inputUserNumber()
        false
    }
}

fun playBaseball(computerNumber: List<Int>, userNumber: List<Int>) {
    var countResult: MutableList<Int> = mutableListOf()
    for (i in userNumber) {
        if (computerNumber.contains(i)) {
            countResult = countBallStrike(userNumber.indexOf(i), i, computerNumber)
        }
    }
    printResult(countResult)
}

fun countBallStrike(location: Int, number: Int, computerNumber: List<Int>): MutableList<Int> {
    TODO()
}

fun printResult(countResult: MutableList<Int>) {
    TODO()
}