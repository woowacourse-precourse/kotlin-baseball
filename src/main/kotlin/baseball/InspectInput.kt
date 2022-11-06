package baseball

fun inspectInputThreeNumberStatus(inputThreeNumber: String): Int {
    // "Only three digits can be entered."
    if (inputThreeNumber.length != 3) {
        throw IllegalArgumentException()
    }

    // "Non-numeric values cannot be entered."
    for (index in inputThreeNumber.indices) {
        if (inputThreeNumber[index].code !in 48 .. 57) {
            throw IllegalArgumentException()
        }
    }

    return 1
}