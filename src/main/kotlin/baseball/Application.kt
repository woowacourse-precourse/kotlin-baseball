package baseball


fun main() {

    println("숫자 야구 게임을 시작합니다.")

    var gameStart = 1
    var count = 1
    while (gameStart == 1){
        try {
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
