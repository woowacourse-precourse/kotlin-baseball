package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun getRandomNumber(): String { // 랜덤으로 숫자를 뽑아 3자리 수 문자형으로 반환해주는 함수
    var randomNum = ""
    var num = 0
    while (randomNum.length < 3) {
        num = Randoms.pickNumberInRange(1, 9) // 1~9까지
        if (!randomNum.contains(num.toString())) {
            randomNum += num.toString()
        }
    }
    return randomNum
}

fun inputNumber(): String { // 잘못 입력했을 시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
    /* 잘못 입력한경우
    1. 같은 숫자 두번 이상 입력
    2. 숫자 외 입력
    3. 길이가 3이 되지 않을때
    */
    var num_list = mutableListOf<String>()
    var onlynum = mutableListOf<Int>()

    print("숫자를 입력해주세요 : ")
    var user = readLine()

    for (num in 0 until user.length){
        if (num_list.contains(user[num].toString())){
            continue
        }
        num_list.add(num, user[num].toString())
    }
    for (Intcheck in 0 until user.length){
        if (user[Intcheck].isDigit()){
            onlynum.add(Intcheck, user[Intcheck].digitToInt())
        }
    }
//    println(onlynum)

    //1. 같은 숫자 두번 이상 입력
    if (num_list.size < 3 ){
        throw IllegalArgumentException("같은 숫자 두번 이상 입력")
    }
    //2. 숫자 외 입력
    if (onlynum.size<3){
        throw IllegalArgumentException("숫자 외 입력하였음")
    }
    //3. 길이가 3이 아닐때
    if (user.length != 3) {
        throw IllegalArgumentException("숫자 3자리를 입력해야함")
    }




    return user.toString()
}

fun ballOrStrike(randomNumber: String, inputNumber: String): String {
    var answer = ""
    var ball = "볼"
    var ballcnt = 0
    var strike = "스트라이크"
    var strikecnt = 0
    for (com in 0 until randomNumber.length) {
        for (user in 0 until inputNumber.length) {
            if (randomNumber[com] == inputNumber[user]) { // 같은 번호를 찾았을때
                if (com == user) { // 인덱스 번호가 같다면
                    strikecnt += 1
                } else if (com != user) {
                    ballcnt += 1
                }
            }
        }
    }

    if (ballcnt == 0 && strikecnt == 0) { // 0볼 0 스트라이크(하나도 없는 경우)
        answer = "낫싱"
    } else {
        if (ballcnt == 0) { // 볼이 0개인 경우
            answer = strikecnt.toString() + strike
        } else if (strikecnt == 0) { // 스트라이크 0개인 경우
            answer = ballcnt.toString() + ball
        } else {
            answer = (ballcnt.toString() + ball) + " " + (strikecnt.toString() + strike)
        }
    }

    return answer
}


fun startgame() { //게임 시작 문구 출력 (최초 한번만 실행)
    println("숫자 야구 게임을 시작합니다.")
}

fun askRegame() { // 게임을 새로 시작할것인지 묻는 메서드
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}


fun main() {
    var randomNumber = ""
    var checkNum = ""
    var flag = true // 플래그
    var restart = 0

    startgame() // 최초 한번만 동작하므로 while문 밖 위치
    randomNumber = getRandomNumber() // 숫자가 무엇인지 보여줄 필요는 없으므로 메서드 호출만
    println(randomNumber) // 임시 확인용 후에 제거 예정
    while (true) {
        if (flag == false) {
            break
        }
        checkNum = inputNumber() // 입력한 값을 담아서 보관
        println(ballOrStrike(randomNumber, checkNum))
        if (ballOrStrike(randomNumber, checkNum) == "3스트라이크") {
            askRegame()
            restart = readLine().toInt()
            if (restart == 1) { // 새로 시작
                randomNumber = getRandomNumber() // 다시 값을 받아와줘야하므로 메서드 재호출
            } else if (restart == 2) { // 종료
                flag = false
            }
        }


    }


}
