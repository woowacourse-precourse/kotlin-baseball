package baseball

import camp.nextstep.edu.missionutils.Randoms
import org.mockito.internal.matchers.Null

var ballCnt = 0
var strikeCnt = 0
class GameLogic {
    private val comNumber = mutableListOf<Int>()
    private val userNumber = mutableListOf<Int>()

    private var inputNumber = ""
    var number = 0

    fun gameStart(){
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
    }
    fun comparison() : Unit{
        strikeCnt = 0
        ballCnt = 0
        println("userNumber : $userNumber comNumber : $comNumber")
        for (i in 0 until userNumber.size) {
            if(userNumber[i]==comNumber[i]){
                strikeCnt += 1
            } else if(userNumber[i] in comNumber){
                ballCnt += 1
            }
        }
    }
    fun userNumToList(num : Int) : List<Int>{
        userNumber.clear()
        var quotient = num
        var inputNum = 0
        while(quotient != 0){
            inputNum = quotient%10
            quotient /= 10
            userNumber.add(0,inputNum)
        }
        return userNumber
    }
    fun userInput() : Unit{
        inputNumber = readln()
        number = inputNumber.toInt()
    }
}