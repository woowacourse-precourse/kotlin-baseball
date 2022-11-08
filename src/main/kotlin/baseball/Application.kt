package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var computerNum: ArrayList<Int>
lateinit var userNum: Array<Int>
var chooseStartOrEnd = 1
var strike = 0
var ball = 0
var userWin = false

fun main() {
    gameStart()

    while (chooseStartOrEnd == 1) {
        userInput()
        checkUserInputForm(userNum)

        for (eachNumber in userNum) checkStrikeOrBall(eachNumber)
        checkResult(strike, ball)
        if (userWin) askRestart()
        else printResult(strike, ball)
    }
}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    makeComputerChoose()
}

fun makeComputerChoose(): ArrayList<Int> {
    computerNum = ArrayList()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) computerNum.add(randomNumber)
    }

    return computerNum
}

fun userInput() {
    print("숫자를 입력해주세요. : ")
    userNum = splitNum(Console.readLine().toInt())
}

fun splitNum(wholeNum: Int): Array<Int> {
    val splitedNum = wholeNum.toString().chunked(1)

    return splitedNum.map { it.toInt() }.toTypedArray()
}

fun checkUserInputForm(userNumArray: Array<Int>) {
    if (userNumArray.toSet().size != 3 || userNumArray.size != 3 || userNumArray.contains(0)) {
        throw IllegalArgumentException("1~9로만 이루어진, 서로 다른 3자리의 수를 입력하세요.")
    }
}

fun checkStrikeOrBall(partOfMyNum: Int) {
    if (computerNum.contains(partOfMyNum)) {
        if (userNum.indexOf(partOfMyNum) == computerNum.indexOf(partOfMyNum)) strike += 1
        else ball += 1
    }
}

fun checkResult(s: Int, b: Int) {
    if (s == 3 && b == 0) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        userWin = true
    }
}

fun askRestart() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    chooseStartOrEnd = Console.readLine().toInt()

    if (chooseStartOrEnd == 1) makeComputerChoose()
    else if (chooseStartOrEnd != 1 && chooseStartOrEnd != 2) {
        throw IllegalArgumentException("1(새로 시작), 2(종료)만 입력할 수 있습니다.")
    }
}

fun printResult(s: Int, b: Int): String {
    lateinit var finalResult: String
    if (s > 0 && b > 0) finalResult = "%d볼 %d스트라이크".format(b, s)
    else if (s == 0 && b > 0) finalResult = "%d볼".format(b)
    else if (s > 0 && b == 0) finalResult = "%d스트라이크".format(s)
    else if (s == 0 && b == 0) finalResult = "낫싱"

    println(finalResult)
    return finalResult
}