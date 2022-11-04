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

    fun countStrike(user: List<Int>, computer: List<Int>): Int {
        var strike = 0
        for (i in 0 until 3) {
            if (isSame(user[i], computer[i])) {
                strike++
            }
        }
        return strike
    }



    private fun isSame(user: Int, computer: Int) = user == computer
}