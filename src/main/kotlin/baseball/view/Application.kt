package baseball.view

import baseball.model.database.DataBase
import baseball.model.datasource.Datasource
import baseball.presenter.Presenter

class Application(
    private val presenter: Presenter
) {
    fun baseballApp() {
        startMessage()
        presenter.setRandomComputerValue()
        while (true) {
            val numberOfUser = inputUserValue()
            presenter.setUserValue(numberOfUser)
            val userValue = presenter.getUserValue()
            val computerValue = presenter.getComputerValue()
            val strike = presenter.countStrike(userValue, computerValue)
            val ball = presenter.countBall(userValue, computerValue)
            resultReturn(strike, ball)
            val complete = strike == 3
            isComplete(complete)
            val restart = restart(complete)
            if(restart == 2) {
                endMessage()
                return
            }
            if(restart == 1) {
                presenter.setRandomComputerValue()
            }
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
