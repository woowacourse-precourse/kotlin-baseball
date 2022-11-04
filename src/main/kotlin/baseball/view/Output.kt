package baseball.view

fun resultReturn(strike: Int, ball: Int) {
    if(isNothing(strike, ball)) {
        println("낫싱")
        return
    }
    if(ball != 0) {
        println("${ball}볼")
    }
    if(strike != 0) {
        println("${strike}스트라이크")
    }
}

private fun isNothing(strike: Int, ball: Int):Boolean {
    if (strike == 0 && ball == 0) {
        return true
    }
    return false
}

