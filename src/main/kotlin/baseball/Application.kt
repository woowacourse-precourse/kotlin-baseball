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

fun compareNumber(
    computer: List<Int>,
    user: List<Int>
): Pair<Int, Int> {
    var ball = 0
    var strike = 0
    computer.onEachIndexed { index, num ->
        if (num == user[index])
            strike += 1
        else if (user.contains(num))
            ball += 1
    }
    return Pair(ball, strike)
}
