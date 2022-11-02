package baseball

import camp.nextstep.edu.missionutils.Randoms

fun randomNumber(): List<Int> {
    val computer = mutableListOf<Int>()     //사용자가 맞춰야 할 컴퓨터의 숫자이다
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun checkNumber(str: String, ans: List<Int>): Int {
    var strike = 0
    var ball = 0
    var idx = 0

    for (elem in str) {       //사용자가 입력한 문자열을 한 글자씩 확인하며
        if (ans.contains(elem - '0'))        // ans 에 있는 숫자이면 일단 ball을 카운트 한다
            ball++
        if (ans[idx] == elem - '0') {     //ans의 해당 idx값과 동일하다면 ball이 아니라 strike다
            ball--
            strike++
        }

        idx++
    }

    if (strike == 3) {     //3스트라이크 -> 정답!
        println("${strike}스트라이크")
        return 1
    } else if (strike == 0 && ball == 0) {
        println("낫싱")
    } else if (strike == 0) {
        println("${ball}볼")
    } else if (ball == 0) {
        println("${strike}스트라이크")
    } else {
        println("${ball}볼 ${strike}스트라이크")
    }

    return 0
}

fun getString(): String {

    println("숫자를 입력해주세요 : ")
    val temp = readLine()

    if (temp.isNullOrEmpty() || temp.length != 3) {        //숫자의 입력 형식이 옳은지 확인해준다
        throw IllegalArgumentException("잘못된 입력입니다")
        temp = getString()
    }

    for (t in temp) {
        if (t !in '0'..'9') {
            throw IllegalArgumentException("잘못된 입력입니다")
            temp = getString()
        }
    }

    return temp
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var computer = randomNumber()

    var regame = 0
    while (regame != 2) {

        var collect = 0   //정답을 맞췄는지 확인해줄 변수 -> 1이 되면 정답임!
        while (collect != 1) {
            val temp = getString()

            collect = checkNumber(temp, computer)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        regame = readLine()!!.toInt()

        computer = randomNumber()
    }
}
