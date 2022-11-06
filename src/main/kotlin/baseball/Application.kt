package baseball

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    TODO("프로그램 구현")
}

fun setComputerNum(): MutableList<Int>{
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNum.contains(randomNumber)){
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

