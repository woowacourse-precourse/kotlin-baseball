package controller

import view.InputView
import view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun game(){
        outputView.showStart()
        inputView.showInput()
    }
}