package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var chooseGameNum = 1
    println("숫자 야구 게임을 시작합니다.")

    while (chooseGameNum == 1) {
        val computerNumList = mutableListOf<Int>()
        while (computerNumList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber)
            }
        }

        var computerNum = ""
        computerNumList.forEach {
            computerNum = computerNum.plus(it)
        }

        var playerNum = ""
        while (playerNum != computerNum) {
            print("숫자를 입력해주세요 : ")
            playerNum = Console.readLine()
        }
    }

}
