package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine

// 기능 목록
// 1. "숫자 야구 게임을 시작합니다." 출력, 게임 함수 실행
// 2. 임의의 수 설정
// 3. "숫자를 입력해주세요:" 출력 후, 3자리 숫자 입력 받기.
// 4. 숫자가 서로 다른 3자리 수가 아니거나 각 자릿수에 0이 있으면, IllegalArgumentException 발생 후 종료
// 5. 입력 받은 숫자와 임의의 수 3개를 비교하는 함수를 이용해 비교하고 결과 출력
// 6. 3개의 숫자 다 맞출 때까지 반복 후 게임 종료
// 7. 재시작 여부 확인 후 게임 재시작 또는 종료

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