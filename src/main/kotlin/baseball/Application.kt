package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var chooseGameNum = 1
    println("숫자 야구 게임을 시작합니다.")

    while (chooseGameNum == 1) {
        var computerNum = getComputerNum()
        var playerNum = ""
        while (playerNum != computerNum) {
            print("숫자를 입력해주세요 : ")
            playerNum = Console.readLine()
            if (playerNum.length != 3) {
                throw IllegalArgumentException("세자리 수를 입력해주세요.")
            }


            var ball = 0
            var strike = 0

            for (j in 0..2) {
                for (i in 0..2) {
                    if (computerNum[j] == playerNum[i]) {
                        if (i == j)
                            strike++
                        else
                            ball++
                    }
                }
            }

            if (ball == 0) {
                if (strike == 0)
                    println("낫싱")
                else
                    println("${strike}스트라이크")
            }

            if (strike == 0) {
                if (ball != 0) {
                    println("${ball}볼")
                }
            }

            if (ball != 0 && strike != 0)
                println("${ball}볼 ${strike}스트라이크")
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        chooseGameNum = Console.readLine().toInt()
    }
}

fun getComputerNum(): String {
    val computerNumList = mutableListOf<Int>()
    var computerNum = ""

    while (computerNumList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumList.contains(randomNumber)) {
            computerNumList.add(randomNumber)
        }
    }

    computerNumList.forEach {
        computerNum = computerNum.plus(it)
    }

    return computerNum
}