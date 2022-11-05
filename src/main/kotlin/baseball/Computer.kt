package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer = arrayListOf<Int>()

    fun generateAnswer() {
        answer.clear()
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }

    fun compareGuessAndAnswer(userGuess: List<Int>): Boolean {
        val strikeCount = countStrike(userGuess)
        val ballCount = countBall(userGuess)
        val result = StringBuilder()

        if (ballCount == 0 && strikeCount == 0) {
            result.append("낫싱")
            println(result.toString())
            return true
        }
        if (ballCount > 0) {
            result.append(ballCount).append("볼")
            if (strikeCount > 0) {
                result.append(' ')
            }
        }
        if (strikeCount > 0) {
            result.append(strikeCount).append("스트라이크")
        }
        if (strikeCount==3){
            result.append('\n').append("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println(result.toString())
            return false
        }
        println(result.toString())
        return true
    }

    fun countStrike(userGuess: List<Int>): Int {
        var strikeCount = 0
        for (index in 0..2) {
            if (answer[index] == userGuess[index]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun countBall(userGuess: List<Int>): Int {
        var ballCount = 0
        for (index in 0..2) {
            if (answer[index] == userGuess[index]) continue
            if (answer.contains(userGuess[index])) {
                ballCount++
            }
        }
        return ballCount
    }
}