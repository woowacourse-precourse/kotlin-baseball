package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object ApplicationService {
    private val inputExceptionHandler = InputExceptionHandler
    private val view = View

    /**
     * 야구 게임 중 숫자를 입력받는 함수
     * */
    fun getInputNumber(): String {
        view.showInputNumber()
        val inputNumber = Console.readLine()
        inputExceptionHandler.checkInputNumber(inputNumber)
        return inputNumber
    }

    /**
     * 입력 받은 숫자를 정제해 리스트에 저장하는 함수
     * */
    fun storeInputNumber(inputNumber: String): MutableList<Int> {
        val slicedInputNumber: MutableList<Int> = mutableListOf()
        for (i in 0..2) {
            slicedInputNumber.add(inputNumber[i].digitToInt())
        }
        return slicedInputNumber
    }

    /**
     * 재시작 종료를 입력받는 함수
     * */
    fun getStatusNumber(): String {
        view.showGameEnd()
        val inputStatusNumber = Console.readLine()
        inputExceptionHandler.checkInputStatusNumber(inputStatusNumber)
        return inputStatusNumber
    }

    /**
     * 야구 게임용 랜덤한 숫자를 생성하는 함수
     * */
    fun createRandomNumber(): List<Int> {
        val createdNumber: MutableList<Int> = mutableListOf()
        while (createdNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!createdNumber.contains(randomNumber)) {
                createdNumber.add(randomNumber)
            }
        }
        return createdNumber.toList()
    }
}