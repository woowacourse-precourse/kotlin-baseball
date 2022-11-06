package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {

}

fun pickRandomNums(){
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}

fun inputNum(): String {
    val inputNum: String = Console.readLine()
    return inputNum
}

fun rightInputCheck(num: String) {
    val inputNum = num
    if (num.length != 3){
        throw IllegalArgumentException("세자리 숫자를 말씀해주세요.")
    }
}
