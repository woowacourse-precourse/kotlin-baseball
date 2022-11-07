package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var computerNumber = ""
var userNumber = ""

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    computerNumber = makeRandomNumber(3)
    println("랜덤숫자 : ${computerNumber}")

    while (true) {
        print("숫자를 입력해주세요 : ")
        userNumber = Console.readLine()
        println(userNumber)
        checkNumberException()

        var (isNothing, userindexIncomputerNum) = searchNothingCase()

        if (isNothing) {
            println("낫싱")
        } else {
            println("${userNumber}의 ${userindexIncomputerNum} 인덱스는 computerNumber에 존재")
            searchStrikeAndBallCase(userindexIncomputerNum)
        }
    }
}

fun makeRandomNumber(length: Int): String {
    var noOverlapRandomNumber = mutableListOf<Int>()

    while (noOverlapRandomNumber.size < length) {
        var randNum = Randoms.pickNumberInRange(1, 9)
        if (randNum !in noOverlapRandomNumber) {
            noOverlapRandomNumber.add(randNum)
        }
    }
    println("랜덤 숫자 생성 : ${noOverlapRandomNumber}")
    return noOverlapRandomNumber.joinToString("")
}

fun checkNumberException() {
    if (userNumber.toIntOrNull() == null) {
        throw IllegalArgumentException("IllegalAccessException. 숫자로 이루어지지 않았습니다.")
    } else if (userNumber.length != 3) {
        throw IllegalArgumentException("IllegalAccessException. 3개의 숫자가 아닙니다.")
    }

    var checkNumber = mutableListOf<Char>()
    for (i in userNumber) {
        if (i !in checkNumber) {
            checkNumber.add(i)
        } else {
            throw IllegalArgumentException("IllegalAccessException. 중복된 숫자가 존재합니다.")
        }
    }
}

fun searchNothingCase(): Pair<Boolean, MutableList<Int>> {
    var isNothing = true
    var userindexIncomputerNum = mutableListOf<Int>()
    for (i in userNumber.indices) {
        if (userNumber[i] in computerNumber) {
            isNothing = false
            userindexIncomputerNum.add(i)
        }
    }
    return Pair(isNothing, userindexIncomputerNum)
}

fun searchStrikeAndBallCase(userNumIndex: MutableList<Int>){
    var strike = 0
    var ball = 0
    for (i in userNumIndex){
        if (userNumber[i] == computerNumber[i]){
            strike++
        }
        else{
            ball++
        }
    }

    if (strike != 0
        && ball != 0
    ){
        println("${ball}볼 ${strike}스트라이크")
    }
    else if (strike != 0){
        println("${strike}스트라이크")
    }
    else if (ball != 0){
        println("${ball}볼")
    }

    if (strike == computerNumber.length){
        GameOverMessage()
    }
}

fun GameOverMessage(){
    println("${computerNumber.length}의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    var response = Console.readLine()

    when (response) {
        "1" -> TODO("게임 재시작")
        "2" -> return
        else -> throw IllegalArgumentException("IllegalAccessException. 잘못된 값입니다.")
    }
}


