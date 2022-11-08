package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val answerNums = produceRandomNums().toList()
    countStrikeBall(answerNums)

    while (decisionEndGame() == 1){
        val secondAnswer = produceRandomNums().toList()
        countStrikeBall(secondAnswer)
    }

}

fun decisionEndGame() : Int? {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val decisionInt = readLine()?.toInt()
    return decisionInt
}

fun produceRandomNums() : Set<Int> {
    val computer = mutableSetOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun stringToIntList( stringNums : String ) : List<Int>{

    var playerNumsInt = mutableListOf<Int>()

    stringNums.forEach {
        playerNumsInt.add(Character.getNumericValue(it))
    }

    return playerNumsInt
}

fun getInputIntegerError(playerNums : String) : Boolean{
    val intergerChar = '1'..'9'
    return playerNums.all{
        it in intergerChar
    }
}

fun getInputLenError(playerNums: String){
    if(playerNums.length > 3){
        throw IllegalArgumentException("3개의 숫자만 입력해주세요(현재 3개 초과의 숫자 입력)")
    }
    else if(playerNums.length < 3){
        throw IllegalArgumentException("3개의 숫자만 입력해주세요(현재 3개 미만의 숫자 입력")
    }
}

fun getInputDuplicateError(playerNums: List<Int>){
    if(playerNums.distinct().size < 3){
        throw IllegalArgumentException("서로 다른 수를 입력해주세요.")
    }
}

fun countStrikeBall(answerNums : List<Int>){

    var inputIsInteger = false

    while(true){

    print("숫자를 입력해주세요 : ")

    var playerNumsString = readLine()
    if (playerNumsString != null) {
        inputIsInteger = getInputIntegerError(playerNumsString)
    }
    if (inputIsInteger == false){
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }
    if (playerNumsString != null) {
        getInputLenError(playerNumsString)
    }

    var playerNumsInt = listOf<Int>(0,0,0)

    playerNumsInt = playerNumsString?.let { stringToIntList(it) }!!

    getInputDuplicateError(playerNumsInt)

    val firstPNum = playerNumsInt[0]
    val secondPNums = playerNumsInt[1]
    val thirdPNums = playerNumsInt[2]

    var strike = 0; var ball = 0;

        if(answerNums[0] == firstPNum)
            strike += 1
        else if(answerNums[1] == firstPNum || answerNums[2] == firstPNum)
            ball += 1

        if(answerNums[1] == secondPNums)
            strike += 1
        else if(answerNums[0] == secondPNums || answerNums[2] == secondPNums)
            ball += 1

        if(answerNums[2] == thirdPNums)
            strike += 1
        else if(answerNums[0] == thirdPNums || answerNums[1] == thirdPNums)
            ball += 1

        printStrikeBall(strike, ball)
        if(strike == 3) break
    }
}

fun printStrikeBall(strike : Int, ball : Int){
    if(strike != 3 && ball > 0 && strike > 0)
        println("${ball}볼 ${strike}스트라이크")

    else if(strike != 3 && ball > 0 && strike == 0)
        println("${ball}볼")

    else if(strike != 3 && ball == 0 && strike > 0)
        println("${strike}스트라이크")

    else if(strike == 0 && ball == 0)
        println("낫싱")

    else if(strike == 3) {
        println(
            "3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        )
    }
}



