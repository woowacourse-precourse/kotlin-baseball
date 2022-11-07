package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.IllegalFormatCodePointException

fun pickNumbers(): List<Char> {
    val result = mutableListOf<Char>()
    for(i in 1..3) {
        result.add(Randoms.pickNumberInRange(1, 9).toChar())
    }
    return result
}

fun main() {
    val userNumbers: List<Char>

    println("숫자 야구 게임을 시작합니다.")
    do {
        val randNumbers = pickNumbers()





    } while(true)
}
