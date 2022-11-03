package baseball

import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun strikeRandNumCreate(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputNum(): String {
    print("숫자를 입력해주세요 : ")
    val userNum = camp.nextstep.edu.missionutils.Console.readLine()
    checkInputValid(userNum)

    return userNum
}

fun checkInputValid(user_num: String): Boolean {
    if (user_num.length != 3)
        return false
    for (i in user_num) {
        if (!(i in '1'..'9')){
            throw IllegalArgumentException("1 부터 9까지의 값을 입력해 주세요")
            return false}
    }
    return true
}
fun ballOrStrike(randNum:MutableList<Int>, inputNum : String){
    var ball : Int = 0
    var strike : Int = 0
    for (i in inputNum){
        if(randNum.contains(i.digitToInt()))
            strike++
        else
            ball++
        }
    if(ball != 0 && ball != 3)
        print("${ball}볼 ")
    else if(ball == 3)
        println("낫싱")
    if(strike != 0 && strike != 3)
        println("${strike}스트라이크")
    else if(strike == 3)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}
fun main() {
    gameStart()
    val randNum = strikeRandNumCreate()
    println(randNum)
    val userNum=inputNum()
    ballOrStrike(randNum, userNum)
}
