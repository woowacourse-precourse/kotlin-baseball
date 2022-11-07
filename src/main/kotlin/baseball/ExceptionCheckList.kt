package baseball

fun isInteger(input: String) {
    try {
        input.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.")
    }
}