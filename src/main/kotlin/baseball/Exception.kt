package baseball

class Exception {
    fun isInValidNum(userNum: String) {
        val regex = Regex("^[1-9]{3}\$")
        if (!regex.matches(userNum))
            throw IllegalArgumentException("Error")
    }

    fun isDistinctNum(numList: List<Int>) {
        if (numList.distinct().size != 3)
            throw IllegalArgumentException("중복되는 숫자 존재")
    }
}