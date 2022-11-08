package baseball

class Exception {
    fun isInvalidNumber(userNumber: String): Boolean {
        val regex = Regex("^[0-9]{3}\$")

        return !regex.matches(userNumber)
    }
}