package baseball

import camp.nextstep.edu.missionutils.Randoms


fun compareList(userInputToInt: List<Int>, computerList: List<Int>): Boolean {
    if (userInputToInt.equals(computerList)) {
        return true
    }
    return false

}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    println("숫자를 입력해주세요 : ")

    var userInputList = userInputToInt()
    var computerList = createComputerList()

    while (!compareList(userInputList, computerList)){

    }

    println("3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료")

}

fun createComputerList() : List<Int> {
    var computer : List<Int> = mutableListOf()
    for (i in 1..3)
        computer.plus(Randoms.pickNumberInRange(1, 9))
    return computer
}

fun userInputToInt() : List<Int> {
    var userInput : Int? = readLine()?.toInt()
    var inputs : List<Int> = emptyList()

    while (userInput!! > 0){
        var tmp = userInput % 10
        userInput /= 10
        inputs.plus(tmp)
    }

    return inputs
}
