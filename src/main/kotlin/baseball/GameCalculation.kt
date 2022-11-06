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