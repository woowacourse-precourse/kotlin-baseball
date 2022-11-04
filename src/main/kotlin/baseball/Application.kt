package baseball


fun main() {

    println("숫자 야구 게임을 시작합니다.")

    val computer = "123"
    while (true) {
        print("숫자를 입력해주세요 : ")
        val userInput: String = readLine()!!
        if (computer == userInput) {
            println("${3}스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
            val inputNumber: String = readLine()!!
            if (inputNumber == "1") continue
            if (inputNumber == "2") break

        }


    }



}

class BaseballGame(computer: String) {
    private val computerInput: String = computer

    fun strike(user: String): Int {
        val userInput: String = user
        var strikeCount = 0
        for (index in userInput.indices) {
            if (user[index] == computerInput[index]) strikeCount++
        }

        return strikeCount

    }


}

