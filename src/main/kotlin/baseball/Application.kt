package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    var computer = generateComputer()
    var inputNum = getInputFormUser()
    var user = mutableListOf<Int>()
    verificationNumver(inputNum)
    user = intToList(inputNum)
    printResult(countingStrikeBall(computer, user))

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
    print("숫자를 입력해주세요 : ")
    var inputNumber = readLine()!!.toInt()
    return inputNumber
}

fun verificationNumver(inputNum: Int): Unit {
    if (inputNum !in 100..999) {
        throw IllegalArgumentException("User entered an incorrect value")
    }
}

fun countingStrikeBall(computer: List<Int>, inputNum: List<Int>): List<Int> {
    var result = mutableListOf<Int>(0, 0) //첫번째 인덱스는 스트라이크 두번째 인덱스는 볼

    for (i in 0..2) {
        if (computer[i].equals(inputNum[0])) {
            if (i == 0) {                                   //리팩토링 필요 들여쓰기 초과
                result[0]++
            }
            if (i != 0) {
                result[1]++
            }
        }
        if (computer[i].equals(inputNum[1])) {
            if (i == 1) {
                result[0]++
            }
            if (i != 1) {
                result[1]++
            }
        }
        if (computer[i].equals(inputNum[2])) {
            if (i == 2) {
                result[0]++
            }
            if (i != 2) {
                result[1]++
            }
        }
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
            println(strike.toString() + "스트라이크")
        }
    }
    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    if (strike == 0 && ball == 0) {
        println("낫싱")
    }
}
