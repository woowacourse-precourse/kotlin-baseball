package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    val computer = randomList()
}

fun randomList():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while(computer.size<3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playerThreeNumber():MutableList<Int>{
    val playerInput = Console.readLine()
    val playerInputMutableList = playerInput.map {it.toString().toInt()}.toMutableList()
    inputErrorCheck(playerInputMutableList)
    print(playerInputMutableList)
    return playerInputMutableList
}

fun inputErrorCheck(userInputMutableList:List<Int>){
    if(userInputMutableList.size != 3) {
        throw IllegalArgumentException()
    }

    if(userInputMutableList.size != userInputMutableList.toSet().size){
        throw IllegalArgumentException()
    }

    for(index in userInputMutableList.indices)
        if(userInputMutableList[index] !in 1 .. 9){
            throw IllegalArgumentException()
        }
}

