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

fun inputNumber(): String {
    /* 잘못 입력한경우
    1. 같은 숫자 두번 이상 입력
    2. 숫자 외 입력
    3. 길이가 3이 되지 않을때
    */
    var num_list = mutableListOf<String>()
    var num_map = mutableMapOf(
        "1" to 1,
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9
    )
    var onlynum = mutableListOf<Int>()

    print("숫자를 입력해주세요 : ")
    var user = readLine()

    for (num in 0 until user.length) {
        if (num_list.contains(user[num].toString())) {
            continue
        }
        num_list.add(user[num].toString())
    }
    for (Intcheck in 0 until user.length) {
        if (num_map.containsKey(user[Intcheck].toString())) {
            onlynum.add(user[Intcheck].digitToInt())
        }
    }

    //3. 길이가 3이 아닐때
    if (user.length != 3) {
        throw IllegalArgumentException("숫자 3자리를 입력해야함")
    }
    //1. 같은 숫자 두번 이상 입력
    else if (num_list.size < 3) {
        throw IllegalArgumentException("같은 숫자 두번 이상 입력")
    }
    //2. 숫자 외 입력
    else if (onlynum.size < 3) {
        throw IllegalArgumentException("숫자 외 입력하였음")
    }

    return user.toString()
}

fun ballOrStrike(randomNumber: String, inputNumber: String): String {
    var answer = ""
    var ball = "볼"
    var ballcnt = 0
    var strike = "스트라이크"
    var strikecnt = 0
    var com_num = mutableListOf<Char>()
    var my_num = mutableListOf<Char>()

    for (com in 0 until randomNumber.length) {
        com_num.add(randomNumber[com])
    }
    for (user in 0 until inputNumber.length) {
        my_num.add(inputNumber[user])
    }
    for (i in 0 until randomNumber.length) {
        if (my_num.contains(com_num[i]) && my_num[i] == com_num[i]) {
            strikecnt += 1
        } else if (my_num.contains(com_num[i]) && my_num[i] != com_num[i]) {
            ballcnt += 1
        }
    }

    if (ballcnt == 0 && strikecnt == 0) { // 0볼 0 스트라이크(하나도 없는 경우)
        answer = "낫싱"
    } else if (ballcnt == 0) { // 볼이 0개인 경우
        answer = strikecnt.toString() + strike
    } else if (strikecnt == 0) { // 스트라이크 0개인 경우
        answer = ballcnt.toString() + ball
    } else {
        answer = (ballcnt.toString() + ball) + " " + (strikecnt.toString() + strike)
    }

    return answer
}


fun startgame() { //게임 시작 문구 출력 (최초 한번만 실행)
    println("숫자 야구 게임을 시작합니다.")
}

fun askRegame(): Int { // 게임을 새로 시작할것인지 묻는 메서드
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var restart = readLine().toInt()

    return restart
}


fun main() {
    var randomNumber = ""
    var checkNum = ""
    var flag = true // 플래그
    var restart = 0

    startgame()
    randomNumber = getRandomNumber()
//    println(randomNumber) // 확인용
    while (true) {
        if (flag == false) {
            break
        }
        checkNum = inputNumber() // 입력한 값을 담아서 보관
        println(ballOrStrike(randomNumber, checkNum))
        if (ballOrStrike(randomNumber, checkNum) == "3스트라이크") {
            restart = askRegame()
        }
        if (restart == 1) { // 새로 시작
            randomNumber = getRandomNumber() // 다시 값을 받아와줘야하므로 메서드 재호출
            restart = 0 // 값 초기화

        } else if (restart == 2) { // 종료
            flag = false
        }

    }

}