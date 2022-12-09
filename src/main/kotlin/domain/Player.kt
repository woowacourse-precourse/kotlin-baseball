package domain

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

    fun compareList(computer : List<Int>, playerList : List<Int>) : Pair<Int, Int>{
        var strike = 0
        var ball = 0
        for ((index, num) in playerList.withIndex()){
            if (computer.contains(num) && computer[index] == playerList[index]){
                strike++
            }
            else if(computer.contains(num) && computer[index] != playerList[index]) {
                ball++
            }
        }
        return Pair(strike, ball)
    }

}