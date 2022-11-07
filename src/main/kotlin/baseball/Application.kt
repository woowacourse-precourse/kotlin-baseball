package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    print(createRandomList())

}

fun createRandomList(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}
