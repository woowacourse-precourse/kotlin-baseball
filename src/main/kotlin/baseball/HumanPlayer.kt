package baseball

class HumanPlayer : Player {

    private var humanSelectedNumber: String = ""

    override fun getSelectedNumber(): String {
        return humanSelectedNumber
    }

    override fun setSelectedNumber(selectedNumber: String) {
        require(Player.validateSelectedNumber(selectedNumber)) { "유효하지 않은 숫자형식입니다." }
        humanSelectedNumber = selectedNumber
    }
}
