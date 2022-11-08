package baseball

fun inspectInputThreeNumberStatus(inputThreeNumber: String): Int {
    // "Only three digits can be entered."
    if (inputThreeNumber.length != 3) {
        throw IllegalArgumentException()
    }

    // "Non-numeric values cannot be entered."
    for (index in inputThreeNumber.indices) {
        if (inputThreeNumber[index].code !in 49..57) {
            throw IllegalArgumentException()
        }

        if(inputThreeNumber.count { it == inputThreeNumber[index] } > 1) {
            throw IllegalArgumentException()
        }
    }

    return 1
}

fun inspectInputGoAndStopStatus(inputGoAndStopStatus: String): Int {
    // "Only 1 or 2 can be entered."
    if (inputGoAndStopStatus.length == 1) return 1
    else if (inputGoAndStopStatus.length == 2) return 1

    throw IllegalArgumentException()
}