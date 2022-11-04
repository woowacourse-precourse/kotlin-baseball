package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}


private fun createComputerNum() : List<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {  //순서대로 백의 자리, 십의 자리, 일의 자리
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return computerNum
}
private fun isInputNumeric(input:String){
    val regex = "[1-9][1-9][1-9]".toRegex()

    if(!input.matches(regex)){
        throw IllegalArgumentException("세 자리의 숫자만 입력가능합니다")
    }
}