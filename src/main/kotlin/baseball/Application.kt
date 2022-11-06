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

/*
* 예외 처리
* */

// 중복값이 있는지 확인하는 함수
fun <Int> hasDuplicates(arr: MutableList<Int>): Boolean {
    return arr.size != arr.distinct().count();
}

// 예외처리: 유저가 올바른 값을 입력했는지 확인
fun checkInputValidity(userInputList: MutableList<Int>) {
    // 중복 값이 있다면
    if ( hasDuplicates(userInputList) ) {
        throw IllegalArgumentException("서로 다른 세자리 수를 입력해 주세요.")
    }

    // 백의 자리가 0으로 시작하지 않는지
    if ( userInputList[0] == 0 ) {
        throw IllegalArgumentException("백의 자리는 0이 될 수 없습니다.")
    }

    // 3자리 초과의 수를 입력했다면
    if ( userInputList[0] > 10 ) {
        throw  IllegalArgumentException("100 ~ 999사이의 값을 입력해주세요. (자릿수 초과)")
    }

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
    println("숫자 야구 게임을 시작합니다.")

    // outer loop: 게임을 새로 진행할건지 판단
    do {
        val computer = generateRandomNumber()
        var correct = false // 정답을 맞추었는지 확인하는 변수
        var keepPlaying = 1 // 게임을 새로 진행하는 변수 (1 = 새로운 게임, 2 = 종료)

        // inner loop: 현재 게임에서 정답을 맞출 떄까지
        do {
            var userInputList = receiveUserInput()
            // 유저 입력값이 올바른지 확인
            checkInputValidity((userInputList))
            correct = baseballGame(userInputList, computer)
        } while (correct != true)

        // 숫자를 다 맞췄다면,
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        keepPlaying = readLine()!!.toInt()
    } while (keepPlaying != 2)

}
