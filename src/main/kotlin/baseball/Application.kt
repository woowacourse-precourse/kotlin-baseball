package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var chooseGameNum = 1
    println("숫자 야구 게임을 시작합니다.")

    while (chooseGameNum == 1) {
        val computerNum = mutableListOf<Int>()
        while (computerNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber)
            }
        }

        while (true) {
            print("숫자를 입력해주세요 : ")
            var playerNum = Console.readLine()
        }
    }

}
