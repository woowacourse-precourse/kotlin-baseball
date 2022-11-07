package baseball

import camp.nextstep.edu.missionutils.Randoms

const val NUM_DIGITS = 3

fun main() {
    var isRunningGame = true

    // while(isRunningGame) {
        playGame()

        // 재시작 여부 묻는 코드 추가 예정
    // }
}

fun playGame() {
    val computerNumberList = makeRandomNumberList()
    val playerNumberList = readLine()?.let { getPlayerNumberList(it) }
}

fun getPlayerNumberList(input: String): MutableList<Int> {

    checkExceptionOnNumbers(input)

    val userNumberList = mutableListOf<Int>()
    for(digit in 0 until NUM_DIGITS) {
        userNumberList.add(input[digit].digitToInt())
    }

    return userNumberList
}

fun makeRandomNumberList(): MutableList<Int> {
    val randomNumberList = mutableListOf<Int>()

    while(randomNumberList.size < NUM_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!randomNumberList.contains(randomNumber)) {
            randomNumberList.add(randomNumber)
        }
    }

    return randomNumberList
}
