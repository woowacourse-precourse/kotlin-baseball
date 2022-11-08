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
    //2. 플레이어의 입력 값을 받는다
    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")

    var playerNumsString = readLine()
    var playerNumsInt = mutableListOf<Int>()

    playerNumsString?.forEach {
        playerNumsInt.add(Character.getNumericValue(it))
    }

}

//1. 1에서 9까지의 서로 다른 임의의 수 3개를 무작위로 만들어내는 함수
fun produceRandomNums() : List<Int> {
    val range = (1..9)
    val randomNums = mutableListOf<Int>()

    for(i in 1..3)
        randomNums += range.random()

    return randomNums
}

//3. 플레이어의 입력 값에 대한 결과를 출력한다
fun getGameResult(playerNums : List<Int>, answerNums : List<Int>){

    val firstPNum = playerNums[0]
    val secondPNums = playerNums[1]
    val thirdPNums = playerNums[2]

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
    else if(strike == 3)
        println("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료")

}

