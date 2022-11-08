package baseball

enum class Message(val message: String) {
    WELCOME("숫자 야구 게임을 시작합니다."),
    REQUEST_INPUT_NUMBER("숫자를 입력해주세요 : "),
    INVALID_ANSWER("0을 제외한 서로 다른 3개의 숫자만을 입력해야 합니다."),
    FINISH("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}