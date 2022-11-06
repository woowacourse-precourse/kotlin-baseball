package baseball.src


fun printHintMessage(ball: Int, strike: Int) {
    if (strike == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    if (ball == 0 && strike == 0) {
        println("낫싱")
    }
    if (ball == 0 && strike != 0 && strike != 3) {
        println("${strike}스트라이크")
    }
    if (ball != 0 && strike == 0) {
        println("${ball}볼")
    }
    if (ball != 0 && strike != 0) {
        print("${ball}볼 ")
        println("${strike}스트라이크")
    }

}