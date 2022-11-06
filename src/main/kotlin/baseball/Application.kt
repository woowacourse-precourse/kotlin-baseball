package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var computerNumber = makeRandomNumber(3)
    print("랜덤숫자 : ${computerNumber}")
}

fun makeRandomNumber(length: Int) : MutableList<Int> {
    var noOverlapRandomNumber = mutableListOf<Int>()

    while (noOverlapRandomNumber.size < 3){
        var randNum = Randoms.pickNumberInRange(1, 9)
        if (randNum !in noOverlapRandomNumber){
            noOverlapRandomNumber.add(randNum)
        }
    }
    return noOverlapRandomNumber
}
