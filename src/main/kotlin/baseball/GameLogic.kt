package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import org.mockito.internal.matchers.Null

class GameLogic {

    private val comNumber = mutableListOf<Int>()
    private val userNumber = mutableListOf<Int>()

    private var inputNumber = ""
    private var number = 0

    fun gameStart(){
        comNumber.clear()
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
    }
    fun comparison() : Map<String , Int>{
        val mapCnt = mutableMapOf<String , Int>()
        var ballCnt = 0
        var strikeCnt = 0

        for (i in 0 until userNumber.size) {
            if(userNumber[i]==comNumber[i]){
                strikeCnt += 1
            } else if(userNumber[i] in comNumber){
                ballCnt += 1
            }
        }
        mapCnt["strike"] = strikeCnt
        mapCnt["ball"] = ballCnt
        return mapCnt
    }
    private fun userNumToList() : Unit{
        userNumber.clear()
        var quotient = number
        var inputNum = 0
        while(quotient != 0){
            inputNum = quotient%10
            quotient /= 10
            userNumber.add(0, inputNum)
        }
        if(userNumber.distinct().size < 3){
            throw IllegalArgumentException("중복된 숫자를 입력했습니다.")
        }
    }
    fun userInput() : Unit{
        inputNumber = Console.readLine()
        if("0" in inputNumber){
            throw IllegalArgumentException("잘못된 숫자를 입력했습니다.")
        }
        if(inputNumber.length > 3 || inputNumber.length < 3){
            throw IllegalArgumentException("범위를 초과했습니다.")
        }
        try {
            number = inputNumber.toInt()
        } catch (e:Exception) {
            throw IllegalArgumentException("문자를 입력했습니다.")
        }

        userNumToList()
    }
    fun gameProgress() : Boolean{
        var ctrl = Console.readLine()
        if(ctrl == "1"){
            return true
        }
        else if(ctrl == "2"){
            return false
        }
        else{
            throw IllegalArgumentException("잘못된 키를 입력했습니다.")
        }
    }

}