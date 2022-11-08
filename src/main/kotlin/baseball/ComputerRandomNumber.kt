package baseball

class ComputerRandomNumber {

    private var _randomNumber: String = ""
    val randomNumber: String
        get() = _randomNumber

    companion object {
        const val RANDOM_NUMBER_MIN_RANGE = 1
        const val RANDOM_NUMBER_MAX_RANGE = 9
    }
}
