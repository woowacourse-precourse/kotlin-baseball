package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


var ballCount = 0
var strikeCount = 0

var success = false
var computer=mutableListOf<Int>()
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    success=false
    computer = makeAnswer()
    while(!success){
        val userInput = getUserInput()
        check(computer,userInput)
        gameControll()
        ballCount = 0
        strikeCount = 0
    }

}
fun gameControll(){
    if(!success) return
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val userInput = Console.readLine()
    if(userInput=="1"){
        computer = makeAnswer()
        success=false
    }else if(userInput!="2"){
        throw IllegalArgumentException()
    }

}


fun check(com:MutableList<Int>, ui:MutableList<Int>){
    for(i in 0..2){
        strikeCheck(com,ui,i)
    }
    for(i in 0..2){
        ballCheck(com,ui,i)
    }
    ballCount-= strikeCount

    printResult()
}
fun printResult(){
    if(ballCount==0 && strikeCount==0){
        println("낫싱")
        return
    }

    if(ballCount>0&& strikeCount>0){
        println("${ballCount}볼 ${strikeCount}스트라이크")
        return
    }

    if(ballCount>0){
        println("${ballCount}볼")
        return
    }
    if(strikeCount>0&&strikeCount<=3){
        println("${strikeCount}스트라이크")
//        return
    }
    if(strikeCount==3){
//        println("3스트라이크")
        success=true
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun ballCheck(com:MutableList<Int>, ui:MutableList<Int>,idx:Int){
    if(ui[idx] in com){
        ballCount++
    }
}
fun strikeCheck(com:MutableList<Int>, ui:MutableList<Int>,idx:Int){
    if(ui[idx]==com[idx]){
        strikeCount++
    }
}
fun getUserInput():MutableList<Int>{
    val userInput = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val before = Console.readLine()
    if(before.length!=3){
        throw IllegalArgumentException()
    }
    if(before[0]==before[1]||before[0]==before[2]|| before[1]==before[2]){
        throw IllegalArgumentException()
    }
    for(i in 0..2){
        val code = before[i].code
        validCode(code)
        userInput.add(code-'0'.code)
    }

    return userInput
}
fun validCode(code:Int){
    if(code<'0'.code || code>'9'.code){
        throw IllegalArgumentException()
    }
}
fun makeAnswer():MutableList<Int>{

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        addNumber(computer)
    }
//    println("답 = $computer")
    return computer
}

fun addNumber(computer:MutableList<Int>){
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber)
    }
}
