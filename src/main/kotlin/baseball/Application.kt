package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    //TODO("프로그램 구현")
    println("숫자 야구 게임을 시작합니다.")
    gameImplementation()
}
fun gameImplementation(){

    val gameAnswerArray = gameAnswer()

    baseballCount(gameAnswerArray)

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    gameState()

}
fun gameState(){
    val gameState = Console.readLine()
    if(gameState=="1") gameImplementation()
    else if(gameState=="2"){
        println("게임을 종료합니다.")
        return
    }
    else{
        throw IllegalArgumentException("입력이 잘못되었습니다.")
        return
    }
}
fun inputAnswer(): List<Int> {
    print("숫자를 입력해주세요: ")
    val user = Console.readLine()
    return exceptionTest(user)
}
fun exceptionTest(num:String):List<Int>{
    var inputNumber = MutableList(3){0}
    if(num.length != 3){
        throw IllegalArgumentException("3자리 수가 아닙니다.")
    }
    for(i in 0..2){
        if(num[i] in '1'..'9'){
            inputNumber[i] = (num[i].code - '0'.code)
        }
        else{
            throw IllegalArgumentException("1부터 9까지의 수가 아닙니다.")
        }
    }
    if(inputNumber.distinct().size != 3){
        throw IllegalArgumentException("서로 다른 수가 아닙니다.")
    }
    return (inputNumber)
}
fun gameAnswer():List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    //println(computer)
    return computer
}

fun baseballCount(answerArray: List<Int>){
    val num = inputAnswer()
    var inputNum = num//input number
    var strikeCnt = 0
    var ballCnt = 0
    for(i in 0..2){
        if(inputNum[i] == answerArray[i]) strikeCnt++
        else if(answerArray.contains(inputNum[i])) ballCnt++
    }
    printResult(ballCnt, strikeCnt, answerArray)
}

fun printResult(ball:Int, strike: Int, answerArray:List<Int>){
    if(ball==0){
        if(strike==0){
            println("낫싱")
        }
        else{
            println("$strike 스트라이크")
        }
    }
    else{
        if(strike==0){
            println("$ball 볼")
        }
        else{
            println("$ball 볼 $strike 스트라이크")
        }
    }
    if(strike==3){
        return
    }
    else{
        baseballCount(answerArray)
    }
}