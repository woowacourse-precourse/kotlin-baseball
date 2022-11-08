package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
    var computerList = listOf<Int>()
    var inputNumberList = listOf<Int>()
    var restartFlag : Int = 1

    while(restartFlag != 2){
        if(restartFlag == 1){
            computerList = makeNumber()     // 랜덤수 생성
            restartFlag = 0
        }
        inputNumberList = getInput()        // 사용자 입력

        val strikes = countStrike(computerList, inputNumberList)        // 스트라이크 개수
        val balls = countBall(computerList, inputNumberList) - strikes  // 볼 개수

        printResult(strikes, balls)     // 결과 출력

        if(isGameOver(strikes)){        // 3스트라이크의 경우
            restartFlag = askRestart()  // 재시작 여부 확인
        }
    }
}

fun startGame(){
    println("숫자 야구 게임을 시작합니다.")
}

fun makeNumber(): List<Int>{
    return Randoms.pickUniqueNumbersInRange(1, 9, 3)
}

fun getInput(): List<Int>{
    print("숫자를 입력해주세요 : ")
    val returnNumber = mutableListOf<Int>()
    val inputNumber = Console.readLine()
    if(checkError(inputNumber)){
        throw IllegalArgumentException("잘못된 입력입니다.")
    }

    for(i in inputNumber){
        returnNumber.add(i.digitToInt())
    }
    return returnNumber
}

fun countBall(computerNumberList: List<Int>, inputNumberList: List<Int>): Int{
    var ballCnt = 0
    for(n in computerNumberList){
        if(inputNumberList.contains(n)){
            ballCnt++
        }
    }
    return ballCnt
}

fun countStrike(computerNumberList: List<Int>, inputNumberList: List<Int>): Int{
    var strikeCnt = 0
    for(i in computerNumberList.indices){
        if(computerNumberList[i] == inputNumberList[i]){
            strikeCnt++;
        }
    }
    return strikeCnt
}
fun printResult(strikeCnt: Int, ballCnt: Int){
    if(strikeCnt == 0 && ballCnt == 0){
        println("낫싱")
    }
    else if(strikeCnt == 0){
        println("${ballCnt}볼")
    }
    else if(ballCnt == 0){
        println("${strikeCnt}스트라이크")
    }
    else{
        println("${ballCnt}볼 ${strikeCnt}스트라이크")
    }
}
fun isGameOver(strikeCnt: Int): Boolean{
    if(strikeCnt == 3){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    return false
}

fun checkError(inputNumber: String): Boolean{
    if(findChar(inputNumber)
            || findZero(inputNumber)
            || !findSame(inputNumber)
            || !matchLength(inputNumber)){
        return true
    }
    return false
}

fun findChar(inputNumber: String): Boolean{
    for(i in inputNumber) {
        if (i.digitToIntOrNull() == null) {
            return true
        }
    }
    return false
}

fun findZero(inputNumber: String): Boolean{
    return inputNumber.contains('0')
}

fun matchLength(inputNumber: String): Boolean{
    return inputNumber.length == 3
}

fun findSame(inputNumber: String): Boolean {
    return inputNumber.toList().distinct().size == 3
}

fun askRestart(): Int{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restart = Console.readLine()
    if(restart == "1" || restart == "2"){
        return restart.toInt()
    }
    throw IllegalArgumentException("잘못된 입력입니다.")
}