package controller

import view.OutputView

class Controller {
    private val outputView = OutputView()

    fun game(){
        outputView.showStart()
    }
}