package user

import Exception.InputException
import camp.nextstep.edu.missionutils.Console

class Player {
    private val inputException = InputException()

    fun makeNumList() : List<Int>{
        val input = Console.readLine()
        inputException.checkException(input)
        var numList = mutableListOf<Int>()
        for (i in input){
            numList.add(Character.getNumericValue(i))
        }
        return numList
    }

    fun chooseRestartOrEnd(){
        val input = Console.readLine()
    }

}