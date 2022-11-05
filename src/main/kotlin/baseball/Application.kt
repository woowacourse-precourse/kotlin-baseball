package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.util.*

fun main() {

    // 시작
    while(true){
        // 랜덤 숫자 3개 받아오기
        val computer = randomThreeNumber()


    }



}


// 랜덤 3글자 추출
private fun randomThreeNumber(): MutableList<String> {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf(3)
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return computer.map { it.toString() }.toMutableList()
}
