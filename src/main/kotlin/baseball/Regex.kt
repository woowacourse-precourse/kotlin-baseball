package baseball

class Regex {

    fun checkNumberIsContained(type: String, number: Int?, numberList: List<Int>): Boolean {
        var mReturn = false
        if (type == "User") {
            mReturn = numberList.distinct().size == numberList.size //Set 사용 검토!
        }
        if (type == "Rand") {
            mReturn = numberList.contains(number)
        }
        return mReturn
    }
}