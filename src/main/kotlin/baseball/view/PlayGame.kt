package baseball.view

import baseball.logic.CheckInputException

class PlayGame {
    val checkInputException = CheckInputException()

    fun getUserNum(): Int{
        print("숫자를 입력해주세요 : ")
        val input = readLine()!!
        checkInputException.inputExceptionChecker(input)
        return input.toInt()
    }

    fun printResult(resultArr: IntArray){
        if(resultArr[0] == 0 && resultArr[1] == 0)
            println("낫싱")
        else if(resultArr[0] == 0)
            println("${resultArr[1]}볼")
        else if(resultArr[1] == 0)
            println("${resultArr[0]}스트라이크")
        else
            println("${resultArr[1]}볼 ${resultArr[0]}스트라이크")
    }
}