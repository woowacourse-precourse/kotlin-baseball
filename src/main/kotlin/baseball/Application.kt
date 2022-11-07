package baseball

import java.util.*


fun randomNum(): List<Char> {
    val tmp = mutableSetOf<Int>()
    while (tmp.size < 3) {    // Set의 특성을 이용 세 자리의 중복없는 정답생성
        tmp.add(Random().nextInt(9))
    }
    return tmp.toString().toList().filter { it.isDigit() }
}

fun playGame(count:Int){

    while (true) {
        var comNum = randomNum()
        if (count == 1){
            comNum = "135".toList()?.distinct()
        }
        else if (count == 2){
            comNum = "589".toList()?.distinct()
        }

        var playerNum: List<Char>? = null
        var ball = 0
        var strike = 0
        print("숫자를 입력해주세요 :")
        playerNum = readLine()?.toList()?.distinct()
        println()
        if (playerNum!!.size != 3) {
            throw IllegalArgumentException("입력 오류")
            return
        }

        comNum.forEachIndexed { index, c ->
            val p = playerNum!!.indexOf(c)
            when {
                p == index -> ++strike
                p != -1 -> ++ball
            }
        }

        if ((ball == 0) and (strike == 0)) {
            println("낫싱")
        } else if ((ball != 0) and (strike == 0)) {
            println("${ball}볼")
        } else if ((ball == 0) and (strike != 0)) {
            println("${strike}스트라이크")
            if (strike == 3) {
                return
            }
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}


fun main() {

    println("숫자 야구 게임을 시작합니다.")

    var gameStart = 1
    var count = 1
    while (gameStart == 1){
        try {
            playGame(count)
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameStart = readLine()!!.toInt()
            ++count
            if ((gameStart != 1) and (gameStart != 2)){
                throw IllegalArgumentException("입력 오류")
            }
        }catch (e: IllegalArgumentException){
            throw IllegalArgumentException("입력 오류")
        }
    }
    println("게임 종료")

}
