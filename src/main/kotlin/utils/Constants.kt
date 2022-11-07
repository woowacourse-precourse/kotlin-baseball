package utils

object Constants {
    // Scripts
    const val ENTER_NUMBER_TEXT = "숫자를 입력해주세요 : "
    const val START_GAME_TEXT = "숫자 야구 게임을 시작합니다."
    const val RESTART_ASKING_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    const val CORRECT_AND_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    // Exceptions
    const val LENGTH_MISMATCH_EXCEPTION = "입력값의 길이가 올바르지 않습니다."
    const val NON_DIGIT_EXCEPTION = "입력값이 숫자가 아닙니다."
    const val OUT_OF_RANGE_EXCEPTION = "입력값이 올바른 범위가 아닙니다."
    const val DUPLICATED_DIGIT_EXCEPTION = "중복된 숫자가 존재합니다."
    const val WRONG_FORMAT_EXCEPTION = "잘못된 입력 형식입니다."

    // Values
    const val DIGIT_LENGTH = 3
    const val MIN_DIGIT = 1
    const val MAX_DIGIT = 9
    const val ANSWER_STRIKE = 3
    const val ANSWER_BALL = 0

    const val RESTART_LENGTH = 1
    const val YES_RESTART = "1"
    const val NO_RESTART = "2"

    const val NO_STRIKE = 0
    const val NO_BALL = 0
}