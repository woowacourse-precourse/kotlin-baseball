package baseball.domain
import camp.nextstep.edu.missionutils.Randoms

class Baseball {

    fun generateNumber(): String {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size != 3){
            val rand = Randoms.pickNumberInRange(1,9)
            if (!computerNumber.contains(rand)) {
                computerNumber.add(rand)
            }
        }
        return computerNumber.joinToString("")
    }
}