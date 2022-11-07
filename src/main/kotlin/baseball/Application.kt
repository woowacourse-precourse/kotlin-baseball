package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var input: String
    while (true) {
        val answer = generateRandomNumber()
        println(answer)
        try {
            print("숫자를 입력해주세요: ")
            input = readLine()!!
            if (checkValidity(input)) {
                if (input == answer) {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                    input = readLine()!!
                    when (input) {
                        "1" -> continue // 재시작
                        "2" -> break // 종료
                        else -> throw IllegalArgumentException()
                    }
                }else{
                    // todo: 스트라이크, 볼, 낫싱 결과 출력

                }
            }else{
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("유효한 값을 입력해주세요.")
            break // 종료
        }
    }
}

// 1~9까지의 범위에 해당하지 않는 수를 입력하면 예외 발생
fun checkValidity(input: String): Boolean {
    if (input.length == 3) {
        for (item in input) {
            if (item.digitToInt() !in 1..9) return false
        }
        return true
    }
    return false
}

// 컴퓨터의 랜덤 숫자 생성
fun generateRandomNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    var result = ""
    for (item in computer) {
        result += item
    }

    return result
}
