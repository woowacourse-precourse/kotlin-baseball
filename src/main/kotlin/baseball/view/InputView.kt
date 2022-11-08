package baseball.view

object InputView {
    fun inputExpectingNumber(): List<Int> {
        println("숫자를 입력해주세요 : ")
        return readln().map { Character.getNumericValue(it) }
    }

    fun inputGameStatus() : Int  {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readln().toInt()
    }
}
