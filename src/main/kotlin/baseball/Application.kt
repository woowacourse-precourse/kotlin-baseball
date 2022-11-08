package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


data class Score(var ball:Int = 0, var strike:Int = 0){

    fun reset(){
        ball = 0
        strike = 0
    }

    fun addBall(){
        ball++
    }

    fun addStrike(){
        strike++
    }

    private fun isNothing(): Boolean {
        return ball == 0 && strike == 0
    }

    fun isCleared(): Boolean {
        return strike == 3
    }

    override fun toString(): String =
        when {
            this.isNothing() -> "낫싱"
            this.isCleared() -> "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
            else -> "${ball}볼 ${strike}스트라이크"
        }


}

class Computer {
    private val computer = mutableListOf<Int>()
    private var computerMap = mutableMapOf<Char, Int>()

    fun createComputerMap(){
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
                computerMap[(randomNumber+48).toChar()] = computer.size-1
            }
        }
    }

    fun containsKey(c:Char): Boolean {
        return computerMap.containsKey(c)
    }

    fun checkComputerMap(c:Char, i:Int): Boolean {
        return computerMap[c] == i
    }




}

abstract class InputString{
    open lateinit var inputRegex: Regex
    lateinit var inputString: String

    open fun enterInput() {
        inputString = Console.readLine()
        checkValidation()
    }

    private fun checkValidation(){
        if(!inputRegex.matches(inputString)){
            throw IllegalArgumentException()
        }
    }

}


class InputNumber : InputString() {
    override var inputRegex = Regex("[1-9]{3}")

    override fun enterInput(){
        print("숫자를 입력해주세요 : ")
        super.enterInput()
    }
}

class InputOption : InputString() {
    override var inputRegex = Regex("[1-2]")

}


class GameObject(){

    private val score:Score = Score()
    private var computer = Computer()

    private val inputNumber = InputNumber()
    private val inputOption = InputOption()


    fun playGame(){

        computer.createComputerMap()

        while(clearGame()){

            score.reset()
            inputNumber.enterInput()

            for ((idx, c) in inputNumber.inputString.withIndex()){
                checkElementAddScore(c, idx)

            }


            println(score.toString())

        }




    }

    fun clearGame(): Boolean {
        if (score.isCleared()) {
            inputOption.enterInput()
            if (inputOption.inputString == "1") {
                computer = Computer()
                computer.createComputerMap()
                return true
            } else {
                return false
            }
        }
        return true
    }






    private fun checkElementAddScore(c:Char, idx:Int){
        if(computer.containsKey(c)){
            if(computer.checkComputerMap(c,idx)){
                score.addStrike()
            }else{
                score.addBall()
            }
        }
    }


}


fun main() {
    val game = GameObject()
    game.playGame()

}
