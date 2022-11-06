package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    val computer = randomThreeNumber()
    val user = playerThreeNumber()
}

fun randomThreeNumber():MutableList<Int>{
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
    //inputErrorCheck(playerInputMutableList)
    return playerInputMutableList
}

