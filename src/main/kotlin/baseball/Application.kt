package baseball

import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    val randNum = strikeRandNumCreate()
    println(randNum)
    while(true) {
        val userNum = inputNum()
        if(ballOrStrike(randNum, userNum)==3)
            break
    }
    gameEnd()
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
    println("입력된 숫자 : $userNum")
    return userNum
}

fun checkInputValid(user_num: String): Boolean {
    var checkedNum = mutableListOf<Char>()
    checkedNum.add(user_num[0])
    if (user_num.length != 3){
        throw IllegalArgumentException("3자리 값을 입력해 주세요")
    }
    for (i in user_num.slice(1..2)) {
        if (i in checkedNum) {
            throw IllegalArgumentException("서로 다른 숫자를 입력해 주세요")
        }
        else
            checkedNum.add(i)
    }
    for (i in user_num) {
        if (i !in '1'..'9'){
            throw IllegalArgumentException("1 부터 9까지의 값을 입력해 주세요")
        }
    }
    return true
}
fun ballOrStrike(randNum:MutableList<Int>, inputNum : String) :Int{
    var ball : Int = 0
    var strike : Int = 0
    for (i in inputNum.indices){
        if(inputNum[i].digitToInt() == randNum[i])
            strike++
        else if(randNum.contains(inputNum[i].digitToInt()))
            ball++
        }
    if(ball != 0)
        print("${ball}볼 ")
    else if(ball == 0 && strike ==0)
        println("낫싱")
    if(strike != 0)
        println("${strike}스트라이크")
    if(strike == 3)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

    return strike
}
fun gameEnd(){
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var option = camp.nextstep.edu.missionutils.Console.readLine().toInt()
    if (option !in 1 .. 2)
        throw IllegalArgumentException("1 부터 2까지의 값을 입력해 주세요")
    else if(option == 1)
        gameStart()
}
fun main() {
    gameStart()
}
