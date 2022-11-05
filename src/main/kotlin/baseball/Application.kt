package baseball

import camp.nextstep.edu.missionutils.Randoms

/*
*   1. 컴퓨터가 랜덤 100 ~ 999 사이의 숫자 생성
*   2. 사용자 숫자 입력
*   3. 볼, 스트라이크 판단
*   4. 선택한 3개의 숫자를 모두 맞히면 게임 종료
* */

fun generateRandomNumber() : MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while ( computer.size < 3 ) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun receiveUserInput() : MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()!!.toInt()

    // userInput을 분리해 리스트로 저장한다
    val userInputList: MutableList<Int> = mutableListOf()
    // 100의 자리
    val hundredth = userInput - userInput % 100
    // 10의 자리
    val tenth = userInput - hundredth - userInput % 10
    // 1의 자리
    val oneth = userInput - hundredth - tenth

    userInputList.add(hundredth / 100)
    userInputList.add(tenth / 10)
    userInputList.add(oneth)

    return userInputList
}

// 유저의 입력값과 컴퓨터의 값을 비교
fun baseballGame(userInputList: MutableList<Int>, computer: MutableList<Int>) : Boolean {
    var correct = false // user의 입력값이 컴퓨터의 값과 일치하는지 판별
    val checkNumber : MutableList<Boolean> = mutableListOf(false, false, false)

    // 1. 스트라이크 판별
    var strike = 0  // strike 갯수를 세는 변수
    for ( i in 0 .. 2 ) {
        if ( userInputList[i] == computer[i] ) {
            // 해당 자릿수를 방문했다고 표시
            checkNumber[i] = true
            strike ++
        }
    }

    // 스트라이크가 3개라면 정답으로, 루프에서 빠져나온다
    if ( strike == 3 ) {
        correct = true
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return correct
    }

    // 2. 볼 판별
    var ball = 0 // ball 갯수를 세는 변수
    for ( i  in 0 .. 2 ){
        // 해당 자릿수를 방문하지 않았을 때
        if ( checkNumber[i] == false ){
            if ( userInputList[i] in computer ) {
                ball ++
            }
        }
    }

    // user의 입력이 0 strike와 0 ball이라면, 낫싱
    if ( strike == 0 && ball == 0 ) {
        println("낫싱")
    }
    else {
        if ( ball != 0 ) {
            print("$ball"+"볼 ")
        }
        if ( strike != 0 ){
            print("$strike"+"스트라이크")
        }
        print("\n")
    }
    return correct
}



fun main() {
    //TODO("프로그램 구현")
    println("숫자 야구 게임을 시작합니다.")

    // 여기서 while값 하나 넣고 flag에 따라 게임 계속 할건지 말건지 판단
    do {
        val computer = generateRandomNumber()
        var correct = false
        var keepPlaying = 1

        do {
            var userInputList = receiveUserInput()
            correct = baseballGame(userInputList, computer)
        } while (correct != true)

        // 숫자를 다 맞췄다면,
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        keepPlaying = readLine()!!.toInt()
    } while (keepPlaying != 2)

}
