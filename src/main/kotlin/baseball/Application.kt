package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.properties.Delegates

lateinit var answer:String

fun setRandomNumber() {
    answer = ""
    while (answer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber.digitToChar())) {
            answer += randomNumber
        }
    }
}

fun prepareNewGame(){
    setRandomNumber()
    println("숫자 야구 게임을 시작합니다.")
}

fun main() {
    var playNewGameOrStop by Delegates.notNull<Int>()

    do{
        prepareNewGame()

    }while(playNewGameOrStop==1)


}