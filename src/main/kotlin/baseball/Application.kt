package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun cptChooseRandomNum():List<Int>{ // 컴퓨터가 서로 다른 랜덤한 수 3개를 뽑게 하는 함수
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun userChooseNum():List<Char>{ // 사용자가 서로 다른 수 3개를 입력하게 하는 함수
    print("숫자를 입력해주세요 : ")
    val userGuessNum = readLine()!!.toList()
    val userGuessNumString = userGuessNum.toString()

    if(userGuessNumString.toIntOrNull() != null || userGuessNum.size != 3 || userGuessNum.distinct().size != 3){
        throw IllegalArgumentException()
    }

    return userGuessNum
}