package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    print("숫자 야구 게임을 시작합니다.")

    while (true) {
        game()

        println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.")

        val reGame = readLine()!!.toInt()
        if (reGame == 2) {
            break
        }
    }
}

fun game() {
    val computerNum = computerRandomNum()

    while (true) {
        print("\n숫자를 입력해주세요 : ")

        val inputNum = readLine()!!
        rightInput(inputNum)

        val strikeBall = compare(computerNum, inputNum.toInt())

        print("\n")
        if (strikeBall[1] > 0) {
            print("${strikeBall[1]}볼 ")
        }
        if (strikeBall[0] > 0) {
            print("${strikeBall[0]}스트라이크")
        }
        if (strikeBall[0] == 0 && strikeBall[1] == 0) {
            print("낫싱")
        }

        if (strikeBall[0] == 3) {
            println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}

fun computerRandomNum(): List<Int> {
    val numSet = mutableSetOf<Int>()
    while (numSet.size<=2) {
        numSet.add(pickNumberInRange(1, 9))
    }
    return numSet.toList()
}

fun rightInput(inputStr: String) {
    val inputSet = mutableSetOf<Char>()

    for (i in inputStr.indices) {
        if (inputStr[i] != '0') {
            inputSet.add(inputStr[i])
        }
    }

    if (inputSet.size != 3) {
        throw IllegalArgumentException()
    }
}

fun compare(computerNum:List<Int>, inputNum:Int): ArrayList<Int> {
    var inputNumb = inputNum
    val strikeBall = arrayListOf(0, 0)
    val inputNumList = arrayListOf<Int>()

    inputNumList.add(inputNumb/100)
    inputNumb %= 100
    inputNumList.add(inputNumb/10)
    inputNumb %= 10
    inputNumList.add(inputNumb)

    for (i in 0 until 3) {
        if (inputNumList[i] == computerNum[i]) {
            strikeBall[0] += 1
        } else if (inputNumList[i] in computerNum) {
            strikeBall[1] += 1
        }
    }
    return strikeBall
}