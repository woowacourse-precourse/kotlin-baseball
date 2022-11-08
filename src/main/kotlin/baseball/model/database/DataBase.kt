package baseball.model.database

class DataBase {
    private var numberOfUser = emptyList<Int>()

    private var numberOfComputer = emptyList<Int>()

    fun setUserValue(num: List<Int>) {
        numberOfUser = num
    }

    fun setComputerValue(num: List<Int>) {
        numberOfComputer = num
    }

    fun getUserValue() = numberOfUser

    fun getComputerValue() = numberOfComputer

}