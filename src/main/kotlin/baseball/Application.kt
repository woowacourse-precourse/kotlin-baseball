package baseball

import camp.nextstep.edu.missionutils.Randoms

fun numbergenerator(): MutableList<Int> {
    val computerNumber: MutableList<Int> = mutableListOf()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}
fun playerInput():String {
    print("숫자를 입력해주세요 : ")
    val playerAnswer = readLine()!!
    if (playerAnswer.length != 3){
        throw IllegalArgumentException()
    }
    return playerAnswer
}
fun playerInputToList(playerInputString:String) : MutableList<Int>{
    val playerInputSplit = playerInputString.chunked(1).map { it.toInt() }.toIntArray()
    val playerInputList : MutableList<Int> = mutableListOf()
    for(count in 0..2) playerInputList.add(count,playerInputSplit[count])
    return playerInputList
}
fun playerInputValidCheck(CheckList : MutableList<Int>){
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
fun strikeBallCheck(Answer : MutableList<Int>,Input : MutableList<Int>) : Int{
    var Strike = 0
    var Ball = 0
    for (count in 0..2){
        if (Answer[count]==Input[count]){
            Strike+=1
        } else if(Answer.contains(Input[count])){
            Ball+=1
        }
    }
    if (Strike==3){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if(Strike!=0 && Ball==0){
        print("$Strike")
        println("스트라이크")
    } else if(Strike==0 && Ball!=0){
        print("$Ball")
        println("볼")
    } else if(Strike==0 && Ball==0){
        println("낫싱")
    } else{
        print("$Ball")
        print("볼 ")
        print("$Strike")
        println("스트라이크")
    }
    return Strike
}
fun gameMenu(menu:Int):Boolean{
    when (menu) {
        1 -> {
            return true
        }
        2 -> {
            return false
        }
        else -> {
            throw IllegalArgumentException()
        }
    }
}
fun menuInput(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return readLine()!!.toInt()
}
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while(true){
        var computer = numbergenerator()
        while (true){
            var player = playerInput()
            var playerInputList=playerInputToList(player)
            playerInputValidCheck(playerInputList)
            if (strikeBallCheck(computer,playerInputList)==3){
                break
            }
        }
        val menu = menuInput()
        if (!gameMenu(menu)){
            break
        }
    }
}
