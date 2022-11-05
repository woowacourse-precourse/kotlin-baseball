package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playNumberBaseball()
}

fun playNumberBaseball() {
    val answerNumber = createRandomAnswerNumber()
}

fun createRandomAnswerNumber(): Int {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
    return randomNumbers[0] * 100 + randomNumbers[1] * 10 + randomNumbers[2]
}
