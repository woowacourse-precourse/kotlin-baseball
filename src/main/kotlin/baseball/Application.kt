package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startgame()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var menu : Int? = readLine()?.toInt()
    while(restart(menu)) {
        startgame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        menu = readLine()?.toInt()
    }

}

fun compareList(userInputToInt: List<Int>, computerList: List<Int>): Boolean {
    if (userInputToInt == computerList) {
        return true
    }
    return false

}

fun startgame(){
    println("숫자 야구 게임을 시작합니다.")

    var userInputList = userInputToInt()
    var computerList = createComputerList()

    while (!compareList(userInputList, computerList)){
        notThreeStrike(userInputList, computerList)
        userInputList = userInputToInt()
    }

    println("3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun notThreeStrike(userInputList: List<Int>, computerList: List<Int>) {
    var strike = 0
    val userInputsize:Int = userInputList.size
    for (i in 0 until userInputsize) {
        strike  += strikeCheck(i, userInputList, computerList)
    }
    var ball = 0
    for (userIn in userInputList){
        ball += ballCheck(userIn, computerList)
    }
    ball -= strike

    printResult(ball, strike)
}

fun printResult(ball: Int, strike: Int) {
    if(ball!=0 && strike != 0){
        println("${ball}볼 ${strike}스트라이크")
    }else if(ball == 0 && strike != 0){
        println("${strike}스트라이크")
    }else if(ball != 0 && strike == 0){
        println("${ball}볼")
    }else{
        println("낫싱")
    }
}

fun ballCheck(userIn : Int, computerList: List<Int>): Int{
    return if (computerList.contains(userIn)){
        1
    }else
        0
}

fun strikeCheck(i: Int, userInputList: List<Int>, computerList: List<Int>) : Int{
    return if(userInputList[i] == computerList[i]){
        1
    }else{
        0
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
    var computer = mutableSetOf<Int>()
    while (computer.size < 3)
        computer+=Randoms.pickNumberInRange(1, 9)
    return computer.toList()
}

fun userInputToInt() : List<Int> {
    print("숫자를 입력해주세요 : ")
    var userInput : Int? = readLine()!!.toIntOrNull()
    var inputs : List<Int> = listOf()

    if(!userInputCheck(userInput)){
        println("유효하지 않은 입력입니다.")
    }

    while (userInput!! > 0){
        var tmp = userInput % 10
        inputs += tmp
        userInput /= 10
    }

    if(!setCheck(inputs)){
        println("유효하지 않은 입력입니다.")
    }


    return inputs.reversed()
}

fun setCheck(inputs: List<Int>): Boolean {
    val setList = inputs.toSet().toList()
    return if(inputs == setList){
        true
    }else{
        throw IllegalArgumentException("숫자는 세 개 이하의 중복되지 않은 정수여야 합니다.")
        false
    }
}

fun userInputCheck(userInput: Int?): Boolean {
    if (userInput !in 0..999){
        throw IllegalArgumentException("숫자는 세 개 이하의 중복되지 않은 정수여야 합니다.")
        return false
    }else if(userInput !is Int){
        throw IllegalArgumentException("숫자는 세 개 이하의 중복되지 않은 정수여야 합니다.")
        return false
    }else{
        return true
    }

}

fun menuCheck(menu: Int?): Boolean {
    return if(menu is Int){
        true
    }else {
        throw IllegalArgumentException("숫자를 입력하세요.")
        false
    }
}
