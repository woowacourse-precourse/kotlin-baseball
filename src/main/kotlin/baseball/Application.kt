package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var strikeCount = 0
var ballCount = 0
var isEnd = 0
fun inputNumber(): String {//숫자 입력
    print("숫자를 입력해주세요 : ")
    val inputNumber = Console.readLine()//String
    checkThreeNumber(inputNumber)
    checkNumber(inputNumber)
    checkSameNumber(inputNumber)
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
fun isContainNumber(inputNumber : String, randomNumber : String){
    var count = 0
    for(i in inputNumber.indices){
        when(randomNumber.contains(inputNumber[i])){
            true -> isDigitNumber(inputNumber[i], randomNumber, i)
            false -> count += 1
        }
    }
    if(count == 3) return println("낫싱")
    //3자리 숫자에 포함 미포함
}
fun isDigitNumber(inputNumber : Char, randomNumber : String, index : Int){
    if(inputNumber == randomNumber[index]){
        strikeCount += 1
    } else if(inputNumber != randomNumber[index]){
        ballCount += 1
    }
    //자리수가 같은지 다른지
}
fun printHint(){
    when {
        ballCount == 0 && strikeCount > 0 -> println("${strikeCount}스트라이크")
        strikeCount == 0 && ballCount > 0 -> println("${ballCount}볼")
        ballCount > 0 && strikeCount > 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
    }
    ballCount = 0
    strikeCount = 0
}
fun startGame(){
    val randomNumber = createRandomNumber()
    println(randomNumber)
    val startGameMessage = "숫자 야구 게임을 시작합니다."
    println(startGameMessage)
    var inputNumber: String
    while(isEnd == 0){
        inputNumber = inputNumber()
        isContainNumber(inputNumber, randomNumber)
        printHint()
    }
}
fun main() {
    startGame()
}