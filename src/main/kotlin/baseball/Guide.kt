package baseball

class Guide {
    fun start() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun input() {
        print("숫자를 입력해주세요 : ")
    }

    fun ballsStrikes(ballsStrikes: BallsStrikes) {
        if (ballsStrikes.balls == 0 && ballsStrikes.strikes == 0) {
            println("낫싱")
            return
        }

        var output = ""
        if (ballsStrikes.balls > 0) {
            output += "${ballsStrikes.balls}볼 "
        }

        if (ballsStrikes.strikes > 0) {
            output += "${ballsStrikes.strikes}스트라이크"
        }

        println(output.trim())
    }

    fun gameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun restartOrEnd() {}
}