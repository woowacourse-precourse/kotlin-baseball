package baseball.view.io

enum class OutputMessage(val message: String) {
    INPUT_NUMBERS("숫자를 입력해주세요 : "),
    THREE_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    QUESTION_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_START("숫자 야구 게임을 시작합니다.")
}