package baseball

class StringToIntegerList {
    fun convert(input: String): List<Int> {
        return input.map { it.code - '0'.code }
    }
}