package baseball

import camp.nextstep.edu.missionutils.Randoms


fun compareList(userInputToInt: List<Int>, computerList: List<Int>): Boolean {
    if (userInputToInt.equals(computerList)) {
        return true
    }
    return false

}

fun startgame(){
    println("숫자 야구 게임을 시작합니다.")
    println("숫자를 입력해주세요 : ")

    var userInputList = userInputToInt()
    var computerList = createComputerList()

    while (!compareList(userInputList, computerList)){
        notThreeStrike(userInputList, computerList)
    }

    println("3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun notThreeStrike(userInputList: List<Int>, computerList: List<Int>) {
    var strike = 0
    for (i in 0..1) {
        strike  += StrikeCheck(i, userInputList, computerList)
    }

}

fun StrikeCheck(i: Int, userInputList: List<Int>, computerList: List<Int>) : Int{
    if(userInputList[i] == computerList[i]){
        return 1
    }else{
        return 0
    }
}

fun main() {
    startgame()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var menu : Int? = readLine()?.toInt()
    while(restart(menu)) {
        startgame()
    }

}

fun restart(menu: Int?): Boolean {

    if (!menuCheck(menu)){
        println("유효하지 않은 입력입니다.")
    }

    return if(menu == 1){
        true
    }else if(menu == 2){
        false
    }else{
        throw IllegalArgumentException("1 또는 2를 입력하세요. ")
        return false
    }

}

fun createComputerList() : List<Int> {
    var computer : List<Int> = mutableListOf()
    for (i in 1..3)
        computer.plus(Randoms.pickNumberInRange(1, 9))
    return computer
}

fun userInputToInt() : List<Int> {
    var userInput : Int? = readLine()?.toInt()
    var inputs : List<Int> = emptyList()

   if(!userInputCheck(userInput)){
       println("유효하지 않은 입력입니다.")
   }

    while (userInput!! > 0){
        var tmp = userInput % 10
        userInput /= 10
        inputs.plus(tmp)
    }

    return inputs
}

fun userInputCheck(userInput: Int?): Boolean {
    if (userInput !in 0..100){
        throw IllegalArgumentException("숫자는 세자리 이하의 정수여야 합니다.")
        return false
    }

    return userInput is Int
}

fun menuCheck(menu: Int?): Boolean {
    return if(menu is Int){
        true
    }else {
        throw IllegalArgumentException("숫자를 입력하세요.")
        false
    }
}
