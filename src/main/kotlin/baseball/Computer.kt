package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

object Computer {
    fun generateRandomNumber() : List<Int>{
        val randomNumbers=ArrayList<Int>()

        while(randomNumbers.size<3){
            val generatedNumber= Randoms.pickNumberInRange(1, 9)

            if(!randomNumbers.contains(generatedNumber)){
                randomNumbers.add(generatedNumber)
            }
        }

        return randomNumbers.toList()
    }
}