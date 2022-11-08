package baseball

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
//    TODO("프로그램 구현")
    println("숫자 야구 게임을 시작합니다.")
    //난수 생성
    val answerNums = produceRandomNums().toList()
    //게임 결과 출력
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

//1. 1에서 9까지의 서로 다른 임의의 수 3개를 무작위로 만들어내는 함수
fun produceRandomNums() : Set<Int> {
    val range = (1..9)
    val randomNums = mutableSetOf<Int>()

    for(i in 1..3)
        randomNums.add(range.random())

    return randomNums
}

fun stringToIntList( stringNums : String ) : List<Int>{

    var playerNumsInt = mutableListOf<Int>()

    stringNums.forEach {
        playerNumsInt.add(Character.getNumericValue(it))
    }

    return playerNumsInt
}

//3. 플레이어의 입력 값에 대한 결과를 출력한다
fun countStrikeBall(answerNums : List<Int>){

    //2. 플레이어의 입력 값을 받는다

    while(true){

    print("숫자를 입력해주세요 : ")

    var playerNumsString = readLine()
    var playerNumsInt = listOf<Int>()

    playerNumsInt = playerNumsString?.let { stringToIntList(it) }!!

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


    if(strike != 3 && ball > 0 && strike > 0)
        println("$ball + 볼 + $strike + 스트라이크")
    else if(strike != 3 && ball > 0 && strike == 0)
        println("$ball + 볼")
    else if(strike != 3 && ball == 0 && strike > 0)
        println("$strike+ 스트라이크")
    else if(strike == 0 && ball == 0)
        println("낫싱")
    else if(strike == 3){
        println("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        break
    }

    }
}



