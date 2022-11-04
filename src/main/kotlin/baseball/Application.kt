package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console

fun main() {
    val random = pickNumberInRange(1, 9)
    println(random)
    val input = Console.readLine()
    println(input.get(2))
}
