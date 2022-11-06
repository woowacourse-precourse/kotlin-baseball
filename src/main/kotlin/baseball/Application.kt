package baseball

import camp.nextstep.edu.missionutils.Randoms

fun createOpponentData(): String {
    var opponentData = ""

    while(opponentData.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!opponentData.contains(randomNumber.toString()))
            opponentData += randomNumber.toString()
    }

    return opponentData
}

fun main() {
    TODO("프로그램 구현")
}
