package baseball

class User {
    var strike: Int =0
    var ball: Int = 0
    var inputData: Int = 1
    var inputNum: Int = 123

    fun intputToList(): MutableList<Int> {
        var num: Int = inputNum
        var result = mutableListOf<Int>(0, 0, 0)
        var index: Int = 2
        while (index >= 0) {
            result[index] = num % 10
            num /= 10
            index--
        }
        return result
    }
}

