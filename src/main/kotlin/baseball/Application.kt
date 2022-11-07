package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var input: String?
    while(true){
        val answer = generateRandomNumber()
        println(answer)

        try{
            print("숫자를 입력해주세요: ")
            input = readLine() // todo: 유효하지 않은 입력 값 예외 처리

            if(input == answer){
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                input = readLine()
                when(input){
                    "1" -> continue // 재시작
                    "2" -> break // 종료
                    else -> throw IllegalArgumentException()
                }
            }
        }catch (e: IllegalArgumentException){
            println("유효한 값을 입력해주세요.")
            break // 종료
        }
    }
}

fun generateRandomNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    var result = ""
    for(item in computer){
        result += item
    }

    return result
}
