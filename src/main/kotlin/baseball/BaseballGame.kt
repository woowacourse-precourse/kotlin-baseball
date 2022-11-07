package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {
    /**
     * 게임을 시작하는 함수
     */
    fun startGame(){
        println("숫자 야구 게임을 시작합니다.")
        while(true){
            processGame()
            if (getNumberForRestartGame() == 2){
                println("게임 종료.")
                break
            }
        }
    }

    /**
     *  값을 입력하고 결과를 확인하는 기능인 게임 과정을 진행하는 함수
     */
    fun processGame() {
        val computerNumberList = getComputerNumberList()
        while (true) {
            println("숫자를 입력해주세요: ")
            val userNumber = getUserNumber()
            val userNumberList = getUserNumberList(userNumber)
            println(getResultString(computerNumberList, userNumberList))
            if (getResultString(computerNumberList, userNumberList) == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }

    /**
     * 숫자를 입력받고 예외 체크 후 반환하는 함수
     */
    fun getNumberForRestartGame(): Int{
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = readLine()
        ThrowException().throwExceptionForRestartNumber(input)
        return input?.toInt()!!
    }

    /**
     * 컴퓨터의 랜덤한 숫자를 정해주고 리스트에 넣어 반환해주는 함수
     */
    fun getComputerNumberList(): MutableList<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
        return computerNumber
    }

    /**
     * 사용자로부터 입력을 받고, ThrowException 객체를 통해 예외 처리를 하는 함수
     */
    private fun getUserNumber(): Int{
        val input = readLine()
        ThrowException().throwExceptionForUserNumber(input)
        return input?.toInt()!!
    }

    /**
     * 유저의 숫자를 리스트에 넣어주고 반환하는 함수수
     */
   fun getUserNumberList(inputNumber: Int): MutableList<Int> {
        val userNumberList = mutableListOf<Int>()
        var inputNumber = inputNumber
        userNumberList.add(inputNumber / 100)
        inputNumber %= 100
        userNumberList.add(inputNumber / 10)
        inputNumber %= 10
        userNumberList.add(inputNumber / 1)
        return userNumberList
    }

    /**
     * 결과를 판단하고, 그 결과를 string 으로 반환하는 함수
     */
    fun getResultString(computerNumberList: MutableList<Int>, userNumberList: MutableList<Int>): String{
        val resultMap = mutableMapOf("볼" to 0, "스트라이크" to 0)
        var wrongCount = 0
        for (index in userNumberList.indices){
            if (computerNumberList.indexOf(userNumberList[index]) != -1)
                setResult(computerNumberList.indexOf(userNumberList[index]), index, resultMap)
            else
                wrongCount++
        }
        return decideResultString(resultMap, wrongCount)
    }

    /**
     * 각 숫자의 자릿수를 비교하여 결과에 따라 스트라이크, 볼에 1씩 추가해주는 함수
     */
    private fun setResult(indexOfComputerNumber: Int, indexOfUserNumber: Int, resultMap: MutableMap<String, Int>){
        if (indexOfComputerNumber == indexOfUserNumber)
            resultMap["스트라이크"] = resultMap["스트라이크"]?.plus(1)!!
        else
            resultMap["볼"] = resultMap["볼"]?.plus(1)!!
    }

    /**
     * 출력할 string 을 조건에 따라 결정하는 함수
     */
    private fun decideResultString(resultMap: MutableMap<String, Int>, wrongCount: Int): String{
        val string = if (wrongCount == 3)
            "낫싱"
        else if (resultMap["스트라이크"] == 0)
            "${resultMap["볼"]}볼"
        else if (resultMap["볼"] == 0)
            "${resultMap["스트라이크"]}스트라이크"
        else{
            "${resultMap["볼"]}볼 ${resultMap["스트라이크"]}스트라이크"
        }
        return string
    }
}