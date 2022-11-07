package baseball

class View {
    fun printStart():Unit
    {
    println("숫자 야구 게임을 시작합니다.")
    }

    fun printInput():Unit{
        print("숫자를 입력해주세요 : ")
    }

    fun printStartOrEnd():Unit{
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printball(ball : Int):Unit{
        print(ball.toString() + "볼 ")
    }
    fun printStrike(strike : Int):Unit{
        print(strike.toString() + "스트라이크")
    }
    fun printGameOver():Unit{
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    fun printNothing():Unit{
        println("낫싱")
    }
    fun ln():Unit{
        println()
    }



}