package baseball

import camp.nextstep.edu.missionutils.Randoms

class GameLogic {
    private val comNumber = mutableListOf<Int>()
    private val userNumber = mutableListOf<Int>()

    private var ballCount = 0
    private var strikeCount = 0
    fun gameStart(){
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
    }
    fun comparison() : Unit{
        val resultList = mutableListOf<Int>()
        for (i in 0 until userNumber.size) {
            if(userNumber[i]==comNumber[i]){
                strikeCount += 1
            } else if(userNumber[i] in comNumber){
                ballCount += 1
            }
        }
    }
    fun userNumToList(num : Int) : List<Int>{
        val userList = mutableListOf<Int>()
        var quotient = num
        var inputNum = 0
        while(quotient != 0){
            inputNum = quotient/10
            quotient %= 10
            userList.add(0,inputNum)
        }
        return userList
    }
}