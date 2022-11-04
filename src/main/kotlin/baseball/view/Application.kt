package baseball.view

import baseball.model.database.DataBase
import baseball.model.datasource.Datasource
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
            val userValue = presenter.getUserValue()
            val computerValue = presenter.getComputerValue()
            val strike = presenter.countStrike(userValue, computerValue)
            val ball = presenter.countBall(userValue, computerValue)
            resultReturn(strike, ball)
        }
    }
}


fun main() {
    val dataBase = DataBase()
    val datasource = Datasource(dataBase)
    val presenter = Presenter(datasource)
    val app = Application(presenter)

    app.baseballApp()
}
