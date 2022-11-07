package baseball

class Baseball(private val input: Input, private val generator: Generator) {
    private val guide = Guide()
    private val computer = Computer(generator)
    private val stringToIntegerListConverter = StringToIntegerList()

    fun start() {
        guide.start()
        play()
    }

    private fun play() {
        computer.generateNumbers()

        var win = false
        while (!win) {
            guide.input()

            val userInput = input.get()

            val validators = listOf(
                StringLengthVerifier(3),
                OneToNineOnlyVerifier(),
                NoSameCharacterVerifier(),
            )
            input.validCheck(userInput, validators)

            val userInputIntegerList = stringToIntegerListConverter.convert(userInput)
            val ballsStrikes = computer.countBallsStrikes(userInputIntegerList)

            guide.ballsStrikes(ballsStrikes)

            win = computer.isWin(ballsStrikes)
        }

        gameOver()
    }

    private fun gameOver() {
        guide.gameOver()

        guide.restartOrEnd()

        val userInput = input.get()

        val validChoices = listOf("1", "2")
        val validators = listOf(
            StringLengthVerifier(1),
            ValidChoiceVerifier(validChoices),
        )
        input.validCheck(userInput, validators)

        if (userInput == "1") {
            restart()
        }
    }

    private fun restart() {}
}
