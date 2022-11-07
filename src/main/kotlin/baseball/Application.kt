package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main(){

}


fun setRandomAnswer(): ArrayList<Int>{
    var answer = arrayListOf<Int>()

    while (answer.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNum))
            answer += randomNum
    }
    return answer
}

fun setGameStartMessage(){
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput() : String? {
    println("숫자를 입력해주세요 :")
    return camp.nextstep.edu.missionutils.Console.readLine()
}

