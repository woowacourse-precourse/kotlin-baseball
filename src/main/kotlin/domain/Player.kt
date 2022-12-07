package domain

import Exception.InputException
import camp.nextstep.edu.missionutils.Console

class Player {
    private val inputException = InputException()

    fun makeNumList() : List<Int>{
        val input = Console.readLine()
        inputException.checkException(input)
        var numList = mutableListOf<Int>()
        for (i in input.indices){
            numList.add(Character.getNumericValue(i))
        }
        return numList
    }
}