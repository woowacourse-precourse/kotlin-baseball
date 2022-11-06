package baseball

fun calculateBaseballAndThreeNumberStatus(answerBaseballNumber: String, inputThreeNumber: String): List<Int> {

    val countStrikeAndBall: MutableList<Int> = mutableListOf(0, 0)
    val tmp_answerBaseballNumber: CharArray = answerBaseballNumber.toCharArray()

    // 스트라이크의 개수를 센다.
    for (answerIndex in tmp_answerBaseballNumber.indices) {
        if (tmp_answerBaseballNumber[answerIndex] == inputThreeNumber[answerIndex]) {
            countStrikeAndBall[0]++
            tmp_answerBaseballNumber[answerIndex] = '-'
        }
    }

    // 볼의 개수를 센다.
    for (inputIndex in inputThreeNumber.indices) {
        if (tmp_answerBaseballNumber.contains(inputThreeNumber[inputIndex])) {
            countStrikeAndBall[1]++
            val ballIndex = tmp_answerBaseballNumber.indexOf(inputThreeNumber[inputIndex])
            tmp_answerBaseballNumber[ballIndex] = '-'
        }
    }

    return countStrikeAndBall
}

fun printBaseballStatus(baseballStatus: List<Int>) {
    when {
        baseballStatus[0] == 3 -> {
            print("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }
        baseballStatus[0] == 0 && baseballStatus[1] == 0 -> println("낫싱")
        baseballStatus[0] == 0 -> println("${baseballStatus[1]}볼")
        baseballStatus[1] == 0 -> println("${baseballStatus[0]}스트라이크")
        else -> println("${baseballStatus[1]}볼 ${baseballStatus[0]}스트라이크")
    }
}