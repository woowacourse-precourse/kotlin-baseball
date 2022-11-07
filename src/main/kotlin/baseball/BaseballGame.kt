package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {
    private var _opponentData: String = ""
    private val _inOutput = InOutput()

    init{
        _inOutput.printStartMessage()
        createOpponentData()
    }

    private fun createOpponentData() {
        _opponentData = ""
        while(_opponentData.length < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if(!_opponentData.contains(randomNumber.toString()))
                _opponentData += randomNumber.toString()
        }
    }

    private fun compareData(inputData: String): List<Int> {
        var ballCount = 0
        var strikeCount = 0

        for(index in _opponentData.indices) {
            if(_opponentData[index] == inputData[index]) strikeCount++
            else if(_opponentData.contains(inputData[index])) ballCount++
        }

        return listOf(ballCount, strikeCount)
    }

    private fun isGameOver(inputResult: List<Int>): Boolean {
        val strikeCount = inputResult[1]

        return strikeCount == 3
    }

    private fun gameResultString(inputResult: List<Int>): String {
        val ballCount = inputResult[0]
        val strikeCount = inputResult[1]

        var printString = ""

        if(ballCount != 0) {
            printString = if(strikeCount != 0)
                "${ballCount}볼 "
            else
                "${ballCount}볼"
        }

        if(strikeCount != 0) {
            printString += "${strikeCount}스트라이크"
        }

        if(ballCount == 0 && strikeCount == 0)
            printString = "낫싱"

        return printString
    }

    private fun continueGame(inputContinue: String): Boolean {
        return inputContinue.toInt() == 1
    }

    fun processGame(): Boolean {
        _inOutput.printInputMessage()
        val inputData = _inOutput.inputUserData()
        val inputResult = compareData(inputData)

        _inOutput.printGameResult(gameResultString(inputResult))

        if (isGameOver(inputResult)) {
            _inOutput.printEndMessage()

            createOpponentData()
            return continueGame(_inOutput.inputContinueData())
        }
        return true
    }
}