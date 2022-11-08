package baseball.game

// 게임 출력 메세지
const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.\n"
const val SUCCESS_GAME_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다 ! 게임 종료\n"
const val CONTINUE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
const val END_GAME_MESSAGE = "게임을 완전히 종료합니다.\n"

const val INPUT_MESSAGE = "숫자를 입력해주세요 : "

const val OUTPUT_BALL_MESSAGE = "%d볼\n"
const val OUTPUT_STRIKE_MESSAGE = "%d스트라이크\n"
const val OUTPUT_BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n"
const val OUTPUT_NOTHING_MESSAGE = "낫싱\n"

// 게임 재시작 및 종료 상태 코드
const val GAME_ACTIVE_CODE = 1
const val RESTART_CODE = 1
const val END_CODE = 2