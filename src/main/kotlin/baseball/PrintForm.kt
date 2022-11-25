package baseball

class PrintForm {
    fun printPlayGame() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printInputPlease() {
        print("숫자를 입력해주세요 : ")
    }

    fun printNothing() {
        println("낫싱")
    }

    fun printOnlyStrike(count : Int) {
        println("${count}스트라이크")
    }

    fun printOnlyBall(count : Int) {
        println("${count}볼")
    }

    fun printStrikeAndBall(ballCount : Int, strikeCount : Int) {
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }

    fun printWhen3Strike(count : Int) {
        println("${count}스트라이크")
        print("${count}개의 숫자를 모두 맞히셨습니다! ")
        println("게임 종료")
    }

    fun printWannaRetry() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printWrongInput() {
        println("잘못된 값이 입력되었습니다. 다시 입력해주세요.")
    }
}