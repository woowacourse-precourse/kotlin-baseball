package baseball.presenter

import baseball.model.datasource.Datasource
import camp.nextstep.edu.missionutils.Randoms

class Presenter(
    private val datasource: Datasource
) {

    fun setUserValue(num: List<Int>) = datasource.setUserValue(num)

    fun setComputerValue() {
        val num = getRandomNumber()
        datasource.setComputerValue(num)
    }

    fun getUserValue() = datasource.getUserValue()

    fun getComputerValue() = datasource.getComputerValue()

    private fun getRandomNumber(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

}