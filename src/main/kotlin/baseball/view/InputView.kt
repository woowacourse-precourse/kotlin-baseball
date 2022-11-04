package baseball.view

object InputView {
    fun inputExpectingNumber(): List<Int> {
        println("숫자를 입력해주세요 : ")
        return readln().split("").map { it.toInt() }
    }

    fun inputRestartingDecideNumber()  {
        TODO("입력한 숫자에 따라서 재시작, 종료 결정하는 함수 새어")
    }
}
