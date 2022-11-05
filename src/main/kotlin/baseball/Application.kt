package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var pcnum = ""
    var mynum = ""
    var strikecount = 0
    var ballcount = 0

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        pcnum = "135"

        mynum = NumInput()
        strikecount = StrikeBallCount(pcnum, mynum)[0]
        ballcount = StrikeBallCount(pcnum, mynum)[1]
        println(strikecount)
        println(ballcount)
    }
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