package baseball

class NumberBaseballGame {
    private var strike = 0
    private var ball = 0

    fun resetScore() {
        strike = 0
        ball = 0
    }

    fun calculateScore(computer: List<Int>, player: List<Int>) {
        computer.forEachIndexed { i, computerNumber ->
            player.forEachIndexed { j, playerNumber ->
                if (computerNumber == playerNumber) {
                    if (i == j) {
                        strike += 1
                    } else {
                        ball += 1
                    }
                }
            }
        }
    }

    fun printResult() {
        if (strike == 0 && ball == 0) {
            println("낫싱")
        }
        if (strike == 0 && ball != 0) {
            println("${ball}볼")
        }
        if (strike != 0 && ball == 0) {
            println("${strike}스트라이크")
        }
        if (strike != 0 && ball != 0) {
            println("${ball}볼 ${strike}스트라이크")
        }
        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }
    }
}
