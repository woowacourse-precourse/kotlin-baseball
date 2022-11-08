package baseball

import java.util.regex.Pattern

interface Player {

    fun getSelectedNumber(): String

    @Throws(IllegalArgumentException::class)
    fun setSelectedNumber(selectedNumber: String) {
    }

    companion object {
        fun validateSelectedNumber(selectedNumber: String): Boolean {
            val numberPattern = "^[1-9]*$"
            if (selectedNumber.length != 3) {
                return false
            }
            if (selectedNumber.toSet().size != 3) {
                return false
            }
            return Pattern.matches(numberPattern, selectedNumber)
        }
    }
}
