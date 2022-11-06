package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val randomValue = createRandomValue()
    val inputValue  = createInputValue()

    println(randomValue)
    println(inputValue)
}

fun createRandomValue(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun createInputValue(): List<Int>{

    return readLine()!!
        .map { it.digitToIntOrNull() }
        .filterNotNull()
}