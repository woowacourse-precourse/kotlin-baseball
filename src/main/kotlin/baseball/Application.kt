package baseball

import baseball.controller.BaseballController

/*var computerNumber = ""
var userNumber = ""
var isPlay = true*/

fun main() {
    var baseballController = BaseballController()
    baseballController.gameStart()
    //GameStart()

}
/*
fun GameStart() {
    println("숫자 야구 게임을 시작합니다.")
    computerNumber = makeRandomNumber(3)

    while (true) {
        if (!isPlay) {
            break
        }
        getPlayerNumber()

        var (isNothing, userindexIncomputerNum) = searchNothingCase()

        if (!isNothing) {
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

    return noOverlapRandomNumber.joinToString("")
}

fun getPlayerNumber() {
    print("숫자를 입력해주세요 : ")
    userNumber = Console.readLine()
    println(userNumber)
    checkNumberException()
}

fun checkNumberException() {
    if (userNumber.toIntOrNull() == null) {
        throw IllegalArgumentException()
    } else if (userNumber.length != 3) {
        throw IllegalArgumentException()
    }

    var checkNumber = mutableListOf<Char>()
    for (i in userNumber) {
        if (i !in checkNumber) {
            checkNumber.add(i)
        } else {
            throw IllegalArgumentException()
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
    if (isNothing) {
        println("낫싱")
    }
    return Pair(isNothing, userindexIncomputerNum)
}

fun searchStrikeAndBallCase(userNumIndex: MutableList<Int>) {
    var strike = 0
    var ball = 0
    for (i in userNumIndex) {
        if (userNumber[i] == computerNumber[i]) {
            strike++
        } else {
            ball++
        }
    }

    if (strike != 0
        && ball != 0
    ) {
        println("${ball}볼 ${strike}스트라이크")
    } else if (strike != 0) {
        println("${strike}스트라이크")
    } else if (ball != 0) {
        println("${ball}볼")
    }

    if (strike == computerNumber.length) {
        GameOverMessage()
    }
}

fun GameOverMessage() {
    println("${computerNumber.length}의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    var response = Console.readLine()
    println("${response}")

    when (response) {
        "1" -> GameStart()
        "2" -> isPlay = false
        else -> throw IllegalArgumentException()
    }
}*/


