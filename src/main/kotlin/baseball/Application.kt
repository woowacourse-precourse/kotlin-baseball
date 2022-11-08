package baseball
import camp.nextstep.edu.missionutils.Randoms
fun getComputerNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while(computerNumber.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNumber.contains(randomNumber)){
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}
