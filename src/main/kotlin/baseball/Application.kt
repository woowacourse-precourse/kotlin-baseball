package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var mynum = ""

    while (true) {
        mynum = NumInput()
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
