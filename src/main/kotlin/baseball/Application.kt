package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun inputNumber(): String? {//숫자 입력
    print("숫자를 입력해주세요 : ")
    val inputNumber = Console.readLine()//String
    checkThreeNumber(inputNumber!!)
    checkNumber(inputNumber)
    checkSameNumber(inputNumber!!)
    return inputNumber
}
fun createRandomNumber(): String{ //랜덤 숫자 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
    println(computer.toString())
}
fun callException(){//예외 처리
    return throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
}
fun checkSameNumber(inputNumber : String){//서로 다른 3자리수 검사
    if(inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2]){
        return callException()
    } else if(inputNumber[1] == inputNumber[0] || inputNumber[1] == inputNumber[2]){
        return callException()
    }
}
fun checkThreeNumber(inputNumber : String){//3자리 인지 검사
    if(inputNumber.length != 3) callException()
}
fun checkNumber(inputNumber : String){//입력된 값이 1~9 가 아닐때
    var temp: Char
    for(i in inputNumber.indices){
        temp = inputNumber.elementAt(i)
        if(49 > temp.toInt() || 57 < temp.toInt()) return callException()
    }
}
fun main() {
    println(inputNumber())
}
