package baseball

fun main() {
    Game(
        gamePrinter = Printer(),
        computer = Computer(),
        user = User(),
        referee = Referee()
    ).play()
}
