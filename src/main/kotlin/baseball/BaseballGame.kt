package baseball

class BaseballGame {
    fun processGame() {
        val computerNumberList = Computer().addComputerNumberToList()
        while (true) {
            println("숫자를 입력해주세요: ")
            val userNumber = inputUserNumber()
            val userNumberList = addUserNumberToList(userNumber)
            println(getResultString(computerNumberList, userNumberList))
            if (getResultString(computerNumberList, userNumberList) == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }

    /**
     * 사용자로부터 입력을 받고, ThrowException 객체를 통해 예외 처리를 하는 함수
     */
    private fun inputUserNumber(): Int{
        val input = readLine()
        ThrowException().throwExceptionForUserNumber(input)
        return input?.toInt()!!
    }

    /**
     * 유저의 숫자를 리스트에 넣어주고 반환하는 함수수
     */
   private fun addUserNumberToList(inputNumber: Int): MutableList<Int> {
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
    private fun getResultString(computerNumberList: MutableList<Int>, userNumberList: MutableList<Int>): String{
        var resultMap = mutableMapOf("볼" to 0, "스트라이크" to 0)
        var wrongCount = 0
        for (index in userNumberList.indices){
            if (computerNumberList.indexOf(userNumberList[index]) != -1)
                compareDigitOfSameNumber(computerNumberList.indexOf(userNumberList[index]), index, resultMap)
            else
                wrongCount++
        }
        return decideResultString(resultMap, wrongCount)
    }

    /**
     * 각 숫자의 자릿수를 비교하여 결과에 따라 스트라이크, 볼에 1씩 추가해주는 함수
     */
    private fun compareDigitOfSameNumber(indexOfComputerNumber: Int, indexOfUserNumber: Int, resultMap: MutableMap<String, Int>){
        if (indexOfComputerNumber == indexOfUserNumber)
            resultMap["스트라이크"] = resultMap["스트라이크"]?.plus(1)!!
        else
            resultMap["볼"] = resultMap["볼"]?.plus(1)!!
    }

    /**
     * 출력할 string 을 조건에 따라 결정하는 함수
     */
    private fun decideResultString(resultMap: MutableMap<String, Int>, wrongCount: Int): String{
        var string = ""
        if (wrongCount == 3)
            string = "낫싱"
        else if (resultMap["스트라이크"] == 0)
            string = "${resultMap["볼"]}볼"
        else if (resultMap["볼"] == 0)
            string = "${resultMap["스트라이크"]}스트라이크"
        else{
            string = "${resultMap["볼"]}볼 ${resultMap["스트라이크"]}스트라이크"
        }
        return string
    }


}