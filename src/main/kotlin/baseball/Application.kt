package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    printStart()
    var computer = generateComputer()
    var input = 1
    val running = 1
    var inputNum: Int = 0
    var user = mutableListOf<Int>()
    var countStrikeball = mutableListOf<Int>()
    while (input == running) {
        print("숫자를 입력해주세요 : ")
        inputNum = getInputFormUser()
        verificationNumver(inputNum)
        user = intToList(inputNum)
        countStrikeball = countingStrikeBall(computer, user)
        printResult(countStrikeball)
        if (countStrikeball[0] == 3) {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            input = getInputFormUser()
            verificationQuitNumver(input)
            computer = reGenerateComputer(input, computer)

        }
    }
}

fun reGenerateComputer(input: Int, computer: List<Int>): List<Int> {
    if (input == 1) {
        return generateComputer()
    }
    return computer
}

fun printStart(): Unit {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputer(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getInputFormUser(): Int {
    var inputNumber = readLine()!!.toInt()
    return inputNumber
}

fun verificationNumver(inputNum: Int): Unit {
    if (inputNum !in 100..999) {
        throw IllegalArgumentException("User entered an incorrect value")
    }
}

fun countingStrikeBall(computer: List<Int>, inputNum: List<Int>): MutableList<Int> {
    var result = mutableListOf<Int>(0, 0) //첫번째 인덱스는 스트라이크 두번째 인덱스는 볼

    for (i in 0..2) {
        result[0] += increaseStrike(computer, i, inputNum)

        result[1] += increaseBall(computer, i, inputNum)
    }

    return result
}

fun increaseStrike(computer: List<Int>, comIndex: Int, inputNum: List<Int>): Int {
    var result = 0
    if (computer[comIndex].equals(inputNum[comIndex])) {
        result++
    }
    return result
}

fun increaseBall(computer: List<Int>, comIndex: Int, inputNum: List<Int>): Int {
    var result = 0
    if (computer[comIndex].equals(inputNum[0]) && comIndex != 0) {
        result++
    }

    if (computer[comIndex].equals(inputNum[1]) && comIndex != 1) {
        result++
    }

    if (computer[comIndex].equals(inputNum[2]) && comIndex != 2) {
        result++
    }
    return result
}

fun intToList(num: Int): MutableList<Int> {
    var num: Int = num
    var result = mutableListOf<Int>(0, 0, 0)
    var index: Int = 2
    while (index >= 0) {
        result[index] = num % 10
        num /= 10
        index--
    }
    return result
}

//5. 구한 값을 통해 결과 출력
fun printResult(count: List<Int>): Unit {
    val strike: Int = count[0]
    val ball: Int = count[1]
    if (strike > 0 || ball > 0) {
        if (ball != 0) {
            print(ball.toString() + "볼 ")
        }
        if (strike != 0) {
            print(strike.toString() + "스트라이크")
        }
        println()
    }
    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    if (strike == 0 && ball == 0) {
        println("낫싱")
    }
}

fun verificationQuitNumver(quitNum: Int): Unit {
    if (quitNum !in 1..2) {
        throw IllegalArgumentException("User entered an incorrect value")
    }
}