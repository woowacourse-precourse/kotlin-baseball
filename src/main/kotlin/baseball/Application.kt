package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var computerNum: ArrayList<Int>

fun main() {

}

fun makeComputerChoose(): ArrayList<Int> {
    computerNum = ArrayList()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) computerNum.add(randomNumber)
    }

    return computerNum
}
