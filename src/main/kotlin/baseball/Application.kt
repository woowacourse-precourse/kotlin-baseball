package baseball

import java.lang.IllegalArgumentException

val EXCEPTION = IllegalArgumentException()

class InputDevice {
    private fun isValidInput(input: String) {
        // input should be length 3
        if(input.length != 3) throw EXCEPTION
        // input should be composed by numbers
        for(c in input) {
            if(!c.isDigit()) throw EXCEPTION
        }
        // input digits must be placed between 1 to 9
        if(input.contains('0')) throw EXCEPTION
        // input digits must be different from each other
        val appeared = MutableList(10) {false}
        for(c in input) {
            if(appeared[c.digitToInt()]) throw EXCEPTION
            appeared[c.digitToInt()] = true
        }
    }
}

fun main() {
    TODO("프로그램 구현")
}
