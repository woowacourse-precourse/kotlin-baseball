package baseball

import camp.nextstep.edu.missionutils.Randoms

/*
기능 목록
    1. 1에서 9까지의 서로 다른 임의의 수 3개를 무작위로 만들어낸다.
    2. 플레이어의 입력 값을 받는다.
    3. 플레이어의 입력 값에 대한 결과를 출력한다.
        3-1. 상대방(컴퓨터)가 선택한 임의의 수 3개를 모두 맞히지 못할 경우 : 낫싱
        3-2. 임의의 수 3개를 모두 맞힐 경우 : 3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료
        3-3. 숫자만 맞고 숫자의 위치는 맞지 않는 경우 : 볼
        3-4. 숫자와 숫자의 위치 모두 맞는 경우 : 스트라이크
    4. 플레이어는 수 3개를 모두 맞힐 때까지 입력할 수 있도록 한다.
    5. 수 3개를 모두 맞히면, 게임이 종료되도록 한다.
    6. 게임이 종료되면 플레이어가 재시작을 하거나, 완전히 종류할 수 있게 한다.
    7. 사용자가 잘못된 값을 입력하면, IllegalArgumentException을 발생시키고 애플리케이션을 종료시키도록 한다(예외 처리)
    8. 재시작할 경우, 서로 다른 임의의 수 3개를 다시 만들어낸다.
 */
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

    var playerNumsInt = listOf<Int>()

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
        println("$ball + 볼 + $strike + 스트라이크")

    else if(strike != 3 && ball > 0 && strike == 0)
        println("$ball + 볼")

    else if(strike != 3 && ball == 0 && strike > 0)
        println("$strike+ 스트라이크")

    else if(strike == 0 && ball == 0)
        println("낫싱")

    else if(strike == 3) {
        println(
            "3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        )
    }
}



