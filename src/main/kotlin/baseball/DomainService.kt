package baseball

object DomainService {
    private val applicationService = ApplicationService
    private const val RESTART = 1
    private const val END = 2
    private const val IN_GAME = 3

    /**
     * 야구 게임을 진행하는 함수
     * */
    fun inGame(createdNumbers: List<Int>): Pair<Int, Boolean> {
        val inputNumber = applicationService.getInputNumber()
        val slicedInputNumber = applicationService.storeInputNumber(inputNumber)
        val resultOfCheckBothNumbers = sendGameResult(checkBothNumbers(createdNumbers, slicedInputNumber))
        println(resultOfCheckBothNumbers)
        if (resultOfCheckBothNumbers == "3스트라이크") {
            val gameStatusFlag = checkGameStatus(resultOfCheckBothNumbers)
            if (gameStatusFlag) {
                return RESTART to true
            }
            if (!gameStatusFlag) {
                return END to false
            }
        }
        return IN_GAME to true
    }

    /**
     * 입력받은 재시작 or 종료 상태를 리턴하는 함수
     * */
    private fun checkGameStatus(resultOfCheckBothNumbers: String): Boolean{
        val inputStatusNumber = baseball.applicationService.getStatusNumber()
        if (inputStatusNumber.toInt() == baseball.RESTART){
            return true
        }
        return false
    }

    /**
     * 입력한 숫자와 생성된 숫자를 비교하는 함수
     * */
    fun checkBothNumbers(listOfCreatedNumber: List<Int>, listOfInputNumber: List<Int>): Pair<Int, Int> {
        var ball = 0
        var strike = 0
        for (index in listOfInputNumber.indices) {
            if (listOfCreatedNumber[index] == listOfInputNumber[index]) {
                strike += 1
            }
            if ((listOfCreatedNumber.contains(listOfInputNumber[index])) and
                (listOfCreatedNumber[index] != listOfInputNumber[index])
            ) {
                ball += 1
            }
        }
        return ball to strike
    }

    /**
     * 비교 결과를 정제해 리턴하는 함수
     * */
    fun sendGameResult(resultOfGame: Pair<Int, Int>): String {
        val (ball, strike) = resultOfGame
        if ((strike == 0) and (ball == 0)) {
            return "낫싱"
        }
        if ((strike == 0) and (ball != 0)) {
            return "{$ball}볼"
        }
        if ((strike != 0) and (ball == 0)) {
            return "${strike}스트라이크"
        }
        return "${ball}볼 ${strike}스트라이크"
    }
}

