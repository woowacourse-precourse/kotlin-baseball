package baseball.view

object InputView {
    private const val NUMBER_SIZE = 3

    fun inputExpectingNumber(): List<Int> {
        println("숫자를 입력해주세요 : ")
        return readln().map { Character.getNumericValue(it) }.checkNumber()
    }

    fun inputGameStatus(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readln().toInt()
    }

    private fun List<Int>.checkNumber(): List<Int> {
        require(this.size == NUMBER_SIZE && this.distinct().count() == NUMBER_SIZE) { "서로 다른 3개의 숫자를 입력해야합니다." }
        return this
    }
}


