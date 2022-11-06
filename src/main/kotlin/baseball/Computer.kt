package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

object Computer {
    var randomNumbers = ArrayList<Int>()

    fun generateNewRandomNumbers() {
        val generatedNumbers = ArrayList<Int>()

        while (generatedNumbers.size < 3) {
            val eachNumber = Randoms.pickNumberInRange(1, 9)

            if (!generatedNumbers.contains(eachNumber)) {
                generatedNumbers.add(eachNumber)
            }
        }
        println(generatedNumbers)
        randomNumbers = generatedNumbers
    }
}