package baseball.view

import baseball.presenter.Presenter

class Application(
    private val presenter: Presenter
) {
    fun baseballApp() {
        println("숫자 야구 게임을 시작합니다.")
        val start = true
        while (start) {
            val numOfUser = inputUserValue()
            presenter.setUserValue(numOfUser)
            presenter.setComputerValue()

        }
    }
}


fun main() {

    val app = Application()

    app.baseballApp()
}
