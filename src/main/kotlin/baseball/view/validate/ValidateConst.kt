package baseball.view.validate

enum class ErrorMessage(val message: String) {
    BASEBALL_NUMBERS_FORM("1부터 9까지의 숫자를 3개 입력해주세요."),
    DUPLICATE_BASEBALL_NUMBERS("숫자의 중복이 없도록 입력해주세요."),
    RESTART_NUMBER("1 또는 2의 숫자를 하나만 입력해주세요")
}