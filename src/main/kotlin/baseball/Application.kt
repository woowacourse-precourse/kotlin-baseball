package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    var userInputToInt = userInputToInt()


    var computer : List<Any> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.plus(randomNumber)
        }
    }
}
fun userInputToInt() : IntArray{
    var userInput : Int? = readLine()?.toInt()
    var inputs = intArrayOf()

    while (userInput!! > 0){
        var tmp = userInput % 10
        userInput /= 10
        inputs.plus(tmp)
    }

    return inputs
}
