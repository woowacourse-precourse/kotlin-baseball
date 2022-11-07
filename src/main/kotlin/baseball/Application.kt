package baseball

fun main() {
    val user = User()
    val computer = Computer()
    val messageMaker = BaseballStringMaker()
    val checkParser = BaseballInputValidCheckAndConverter(BaseballGameInputConverter())
    val baseBallGame = BaseBallGameRule(user, computer, messageMaker, checkParser)
    baseBallGame.run()
}
