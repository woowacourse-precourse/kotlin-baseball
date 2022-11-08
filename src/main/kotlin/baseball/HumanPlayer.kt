package baseball

class HumanPlayer : Player {

    private var humanSelectedNumber: String = ""

    override fun getSelectedNumber(): String {
        return humanSelectedNumber
    }
}
