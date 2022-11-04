package baseball.model.datasource

import baseball.model.database.DataBase

class Datasource(
    private val dataBase: DataBase
) {

    fun setUserValue(num: List<Int>) = dataBase.setUserValue(num)

    fun setComputerValue(num: List<Int>) = dataBase.setComputerValue(num)

    fun getUserValue() = dataBase.getUserValue()

    fun getComputerValue() = dataBase.getComputerValue()

}