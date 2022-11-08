package baseball

class ComputerPlayer(private val computerSelectedNumber: ComputerRandomNumber) : Player {
    override fun getSelectedNumber(): String {
        return computerSelectedNumber.randomNumber
    }
}
