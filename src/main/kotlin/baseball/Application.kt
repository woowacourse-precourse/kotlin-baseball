package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun comInput(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) computer.add(randomNumber)
    }
    return computer
}

fun userInput() : MutableList<Int> {
    val user = mutableListOf<Int>()

    while(user.size < 3) {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()!!

        if(userNumber.length == 3) {
            for(i in userNumber.indices) {
                if(userNumber[i] - '0' in 1..9) {
                    user.add(userNumber[i] - '0')
                }
            }
        } else {
            throw IllegalArgumentException()
        }

    }
    return user
}

fun compareNumber(userNumberList : List<Int>, comNumberList : List<Int>) : MutableList<Int> {
    val checkNumber : MutableList<Int> = mutableListOf()

    for(i in userNumberList.indices) {
        if(userNumberList[i] == comNumberList[i]) {
            checkNumber.add(1)
        } else if(userNumberList[i] in comNumberList && userNumberList[i] != comNumberList[i]) {
            checkNumber.add(0)
        } else {
            checkNumber.add(-1)
        }
    }
    return checkNumber
}

fun checkBallCount(ballCheckList: MutableList<Int>): MutableList<Int> {
    val checkCount : MutableList<Int> = mutableListOf(0, 0, 0)

    ballCheckList.forEach {
        when(it) {
            0 -> checkCount[0]++
            1 -> checkCount[1]++
            else -> checkCount[2]++
        }
    }
    return checkCount
}

fun gameResult(checkCount : MutableList<Int>) : String {
    var gameResultMessage = ""

    gameResultMessage = if(checkCount[1] == 3) {
        "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
    else if(checkCount[2] == 3) {
        "낫싱"
    } else {
        if(checkCount[0] != 0 && checkCount[1] == 0) {
            checkCount[0].toString() + "볼"
        } else if(checkCount[0] == 0 && checkCount[1] != 0) {
            checkCount[1].toString() + "스트라이크"
        } else {
            checkCount[0].toString() + "볼 " + checkCount[1].toString() + "스트라이크"
        }
    }
    return gameResultMessage
}

fun main() {
    val userNumbers = userInput()
//    val comNumbers = comInput()

    val comNumbers : MutableList<Int> = mutableListOf(3, 5, 6)

    val gameTest = checkBallCount(compareNumber(userNumbers, comNumbers))

    println("com : $comNumbers")
    println("user : $userNumbers")

    println(gameTest)

    println(gameResult(gameTest))

}
