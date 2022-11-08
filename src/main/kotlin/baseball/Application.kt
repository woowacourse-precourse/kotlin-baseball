package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while(true){
        val computer = numberGenerator()
        while (true){
            val player = playerInput()
            val playerInputList=playerInputToList(player)
            playerInputValidCheck(playerInputList)
            val strike = (strikeCheck(computer,playerInputList))
            val ball = (ballCheck(computer,playerInputList))
            resultPrint(strike,ball)
            if (strike==3){
                break
            }
        }
        val menu = menuInput()
        if (!gameMenu(menu)){
            break
        }
    }
}
fun numberGenerator(): MutableList<Int> {
    val computerNumber: MutableList<Int> = mutableListOf()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun playerInput(): String {
    print("숫자를 입력해주세요 : ")
    return readLine()!!
}

fun playerInputToList(playerInputString:String) : MutableList<Int>{
    playerInputString.toIntOrNull()?: throw IllegalArgumentException()
    val playerInputSplit = playerInputString.chunked(1).map { it.toInt() }.toIntArray()
    val playerInputList : MutableList<Int> = mutableListOf()
    for(count in 0..2) playerInputList.add(count,playerInputSplit[count])
    return playerInputList
}

fun playerInputValidCheck(CheckList : MutableList<Int>){
    if (CheckList.size != 3){
        throw IllegalArgumentException()
    }
    if(CheckList[0]==CheckList[1]){
        throw IllegalArgumentException()
    }
    if(CheckList[1]==CheckList[2]){
        throw IllegalArgumentException()
    }
    if(CheckList[0]==CheckList[2]){
        throw IllegalArgumentException()
    }
}

fun strikeCheck(Answer : MutableList<Int>,Input : MutableList<Int>) : Int{
    var strike = 0
    for (count in 0..2){
        if (Answer[count]==Input[count]){
            strike+=1
        }
    }
    return strike
}

fun ballCheck(Answer : MutableList<Int>,Input : MutableList<Int>) : Int{
    var ball = 0
    for (count in 0..2) {
        if (Answer[count] != Input[count] && Answer.contains(Input[count])) {
            ball += 1
        }
    }
    return ball
}

fun resultPrint(strike:Int,ball:Int) {
    if (strike==3){
        print("$strike")
        println("스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if(strike!=0 && ball==0){
        print("$strike")
        println("스트라이크")
    } else if(strike==0 && ball!=0){
        print("$ball")
        println("볼")
    } else if(strike==0){
        println("낫싱")
    } else{
        print("$ball")
        print("볼 ")
        print("$strike")
        println("스트라이크")
    }
}

fun gameMenu(menu:Int):Boolean{
    return when (menu) {
        1 -> {
            true
        }
        2 -> {
            false
        }
        else -> {
            throw IllegalArgumentException()
        }
    }
}

fun menuInput(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return readLine()!!.toIntOrNull() ?: throw IllegalArgumentException()
}

