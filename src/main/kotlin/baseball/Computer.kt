package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    var strike = 0
    var ball = 0
    val correctNumber = mutableListOf<Int>()
    fun getCorrectRandomNumber(){
        correctNumber.clear()
        while (correctNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!correctNumber.contains(randomNumber)) {
                correctNumber.add(randomNumber)
            }
        }
    }
    fun compareInputWithCorrectNumber(inputValue : String){
        for(i in 0 until correctNumber.size){
            if(inputValue.contains(correctNumber[i].toString())){
                if(inputValue[i].digitToInt()== correctNumber[i]){
                    strike++
                }
                else{
                    ball++
                }
            }
        }
        printCurrentScore()
    }
    fun printCurrentScore(){
        if(strike==0 && ball==0){
            println("낫싱")
        }
        else if(strike==0 && ball>0){
            println("${ball}볼")
        }
        else if(strike>0 && ball==0){
            println("${strike}스트라이크")
            if(strike==3){
                //게임 오버
            }
        }
        else if(strike>0 && ball>0){
            println("${ball}볼 ${strike}스트라이크")
        }
        strike=0
        ball=0
    }
}
