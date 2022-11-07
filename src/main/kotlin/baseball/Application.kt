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

fun inputNumbers(): List<Char> {
    val input = Console.readLine()
    Integer.parseInt(input)
    if (input.length != 3) {
        throw IllegalArgumentException("3자리의 수가 아닙니다")
    }
    return input.toList()
}

fun main() {
    val userNumbers: List<Char>

    println("숫자 야구 게임을 시작합니다.")
    do {
        val randNumbers = pickNumbers()

        print("숫자를 입력해주세요 : ")
        val userNumbers:List<Char> = try {
            inputNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return
        }

    } while(true)
}
