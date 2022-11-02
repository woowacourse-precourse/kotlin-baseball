package baseball

import kotlin.random.Random

fun main() {

    val computer = mutableListOf<Int>()     //사용자가 맞춰야 할 컴퓨터의 숫자이다
    while (computer.size < 3) {
        val randomNumber = Random.nextInt(1, 10)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}
