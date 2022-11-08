package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var pcnum = ""
    var mynum = ""
    var strikecount = 0
    var ballcount = 0
    var restart = 1
    var case = 0

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        if (case == 0) {
            pcnum = "135"
        } else if (case == 1) {
            pcnum = "589"
        }

        mynum = NumInput()
        strikecount = StrikeBallCount(pcnum, mynum)[0]
        ballcount = StrikeBallCount(pcnum, mynum)[1]

        if (ballcount == 0 && strikecount == 0)
            println("낫싱")
        if (strikecount == 0 && ballcount >= 1)
            println("${ballcount}볼")
        if (ballcount == 0 && strikecount >= 1)
            println("${strikecount}스트라이크")
        if (ballcount in 1..2 && strikecount in 1..2)
            println("${ballcount}볼 ${strikecount}스트라이크")

        if (strikecount == 3) {
            println("세개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            restart = readLine()!!.toInt()
            case += 1
            pcnum = RandomNumMaker()
        }
        if (restart == 2) {
            println("게임 종료")
            break
        } else if (restart != 1) {
            throw IllegalArgumentException("Error(잘못된 수 입력!)")
        }
    }
}

fun RandomNumMaker(): String {
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return "${computer[0]}${computer[1]}${computer[2]}"
}

fun NumInput(): String {
    print("숫자를 입력해주세요 : ")
    var fnum: String? = readLine()
    if (fnum!!.length != 3)
        throw IllegalArgumentException("Error(3자리가 아닌 수 입력!)")
    if (fnum[0] == fnum[1] || fnum[1] == fnum[2] || fnum[2] == fnum[0])
        throw IllegalArgumentException("Error(중복된 수 입력!)")
    if (fnum.contains('0'))
        throw IllegalArgumentException("Error(잘못된 수 입력!)")
    return fnum
}

fun StrikeBallCount(pcnum: String, mynum: String): List<Int> {
    var fstrike = 0
    var fball = 0
    for (i in 0..2) {
        if (pcnum[i] == mynum[i]) {
            fstrike += 1
        }
    }
    for (i in 0..2) {
        if (pcnum.contains(mynum[i])) {
            fball += 1
        }
    }
    fball -= fstrike
    return listOf(fstrike, fball)
}