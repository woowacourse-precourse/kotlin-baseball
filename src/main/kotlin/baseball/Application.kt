package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    val computer = randomThreeNumber()
    val user = playerThreeNumber()
    val result = hashMapOf<String,Int>()
    result["스트라이크"] = 0
    result["볼"] = 0
    result.replace("스트라이크",findStrike(computer,user))
}

fun randomThreeNumber():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while(computer.size<3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
//    print(computer)
    return computer
}

fun playerThreeNumber():MutableList<Int>{
    val playerInput = Console.readLine()
    val playerInputMutableList = playerInput.map {it.toString().toInt()}.toMutableList()
    inputErrorCheck(playerInputMutableList)
//    print(playerInputMutableList)
    return playerInputMutableList
}

fun inputErrorCheck(userInputMutableList:List<Int>){
    if(userInputMutableList.size != 3 || userInputMutableList.toSet().size!=3){
        throw IllegalArgumentException()
    }

    for(index in userInputMutableList.indices)
        if(userInputMutableList[index] !in 1 .. 9){
            throw IllegalArgumentException()
        }
}

fun findStrike(computer:List<Int>,user:List<Int>):Int{
    var count = 0
    for(index in 0..2){
        if(computer[index]==user[index])
            count++
    }
//    print(count)
    return count
}