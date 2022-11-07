package baseball

const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

fun printGameStartMessage() = println(GAME_START_MESSAGE)
fun printReGameMessage() = println(RE_GAME_MESSAGE)
fun printInputMessage() = println(INPUT_MESSAGE)
fun printGameEndMessage() = println(GAME_END_MESSAGE)
