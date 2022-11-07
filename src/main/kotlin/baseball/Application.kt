package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.Exception
import java.lang.IllegalArgumentException

private const val GAMESTART=1
private const val GAMEEND=2

fun main() {
    var userChoice=1
    println("숫자 야구 게임을 시작합니다.")

    while(userChoice==GAMESTART){
        userChoice= entireGame()
    }
}

fun entireGame():Int {
    var computerNum:List<Int> = makeRandomNum()



    return 0 //임시
}

fun makeRandomNum():List<Int>{
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}


fun isValidNum(answer:Int):Boolean{
    var answerList=answer.toString().toList()

    if(!(answer is  Int)){
        return false
    }
    if(answer<=0){
        return false
    }
    if(answer.toString().length!=3){
        return false
    }
    if(answerList.contains('0')){
        return false
    }
    if(answerList.distinct().size!=3){
        return false
    }

    return true
}

