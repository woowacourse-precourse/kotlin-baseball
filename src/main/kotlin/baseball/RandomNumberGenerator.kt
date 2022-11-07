package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : Generator {
    override fun generateNumbers(n: Int): List<Int> {
        val randomNumbers = mutableListOf<Int>()
        while (randomNumbers.size < n) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }
        return randomNumbers
    }
}