package baseball

class Exception {
    fun isInValidNum(userNum: String) {
        val regex = Regex("^[1-9]{3}\$")
        if (!regex.matches(userNum))
            throw IllegalArgumentException("유효한 3자리 숫자가 아닙니다.")
    }

    fun isDistinctNum(numList: List<Int>) {
        if (numList.distinct().size != 3)
            throw IllegalArgumentException("중복되는 숫자 존재")
    }

    fun isValidEndNum(num : String){
        val regex = Regex("^[1-2]\$")
        if(!regex.matches(num))
            throw IllegalArgumentException("1 또는 2의 숫자가 아닙니다.")
    }
}