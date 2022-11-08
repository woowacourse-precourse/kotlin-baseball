package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        //게임 시작 문구
        println("숫자 야구 게임을 시작합니다.")

        //컴퓨터 랜덤 3자리 수 뽑기
        val computer = computerRandom()

    }
}

//컴퓨터 랜덤 3자리 수 뽑기
fun computerRandom() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

