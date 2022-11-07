package baseball

class CountNumber {
    fun count(targetNumber: String, inputNumber: String): Boolean {
        return checkNumber(targetNumber, inputNumber)
    }

}

private fun checkNumber(targetNumber: String, inputNumber: String):Boolean {
    var ballCount = 0
    var strikeCount = 0
    inputNumber.forEachIndexed { index, input ->
        if (index == targetNumber.indexOf(input)) {
            ++strikeCount
        } else if (targetNumber.contains(input)) {
            ++ballCount
        }
    }
    return VerifyNumber().verify(strikeCount, ballCount)
}


