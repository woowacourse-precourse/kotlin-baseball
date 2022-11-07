package baseball

import camp.nextstep.edu.missionutils.Randoms

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
    for(count in 0 until 3) playerInputList[count]=playerInputSplit[count].toInt()
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
fun main() {
    /*var computerNumber = Numbergenerator()
    println(computerNumber)*/
}
