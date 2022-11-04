package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println(comRandomNum())
}

fun comRandomNum() : String {
    var computer = ""

    while(computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber.toString())) {
            computer += randomNumber.toString()
        }
    }
    return computer
}

fun inputUserNum() {
    print("숫자를 입력해주세요 : ")
    val userNum = readLine()
}
