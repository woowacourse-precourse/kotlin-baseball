package baseball

const val DUPLICATED_NUMBER = "중복된 수입니다."
const val NOT_THREE_NUMBER = "3자리 수만 입력해주세요"
const val NOT_NUMBER = "0을 제외한 숫자만 입력해 주세요"

fun inputNumberException(input: String) {
    when {
        input.toSet().size < 3 -> throw IllegalArgumentException(DUPLICATED_NUMBER)
        input.length > 3 -> throw IllegalArgumentException(NOT_THREE_NUMBER)
        isNotNumber(input) -> throw IllegalArgumentException(NOT_NUMBER)
    }
}

private fun isNotNumber(input: String) = !("[1-9]{3}".toRegex()
    .matches(input))
