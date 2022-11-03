package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    var input = ""
    fun gameStart(){
        Computer.getCorrectRandomNumber()
        while(true){
            input = Console.readLine()
        }
    }
}