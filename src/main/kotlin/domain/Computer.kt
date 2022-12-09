package domain

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun makeRandomList() : List<Int>{
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
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

    fun validateGameEnd(strike : Int) : Boolean = (strike == 3)
}