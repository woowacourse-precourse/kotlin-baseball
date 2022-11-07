package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun Numbergenerator(): MutableList<Int> {
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
    val playerInputSplit = playerInputString.split("")
    val playerInputList : MutableList<Int> = mutableListOf()
    for(count in 0..2) playerInputList[count]=playerInputSplit[count].toInt()
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
fun StrikeBallCheck(Answer : MutableList<Int>,Input : MutableList<Int>) : Int{
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
        println("$Strike+스트라이크")
    } else if(Strike==0 && Ball!=0){
        println("$Ball+볼")
    } else if(Strike==0 && Ball==0){
        println("낫싱")
    } else{
        println("$Ball+볼 $Strike+스트라이크")
    }
    return Strike
}
fun main() {
    /*var computerNumber = Numbergenerator()
    println(computerNumber)*/
}
