package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    var input = ""
    fun gameStart(){
        Computer.getCorrectRandomNumber()
        while(true){
            input = Console.readLine()
            if(checkInputValueException(input)){
                break
                throw IllegalArgumentException()
            }
        }
    }
    private fun checkInputValueException(inputValue: String) : Boolean{
        var checkExceptionFlag = false
        if(!checkInputLengthThree(inputValue) || !checkInputLengthThree(inputValue)){
            checkExceptionFlag = true
        }
        return checkExceptionFlag
    }

    private fun checkInputValueIsNumber(inputValue : String) : Boolean{
        var checkFlag = false
        inputValue.forEach {
            if(it.code in 49..57){
                checkFlag = true
            }
        }
        return checkFlag
    }

    private fun checkInputLengthThree(inputValue : String): Boolean{
        var checkFlag = false
        if(inputValue.length==3){
            checkFlag = true
        }
        return checkFlag
    }
}