package baseball.view

class EndGame {
    fun printEndGameMessage(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printAskPlayAgainMessage(): Int{
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readLine()!!.toInt()
    }
}