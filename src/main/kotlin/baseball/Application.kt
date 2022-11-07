package baseball

import camp.nextstep.edu.missionutils.Console
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


    return 0 //임시 코드
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


fun isValidNum(answer:Int):Boolean{ //사용자 입력 검사 함수
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

fun inputUserNum():List<Int>{ //사용자가 번호 입력하는 함수
    var answer:Int
    val answerList= mutableListOf<Int>()
    var divideNum=100
    print("숫자를 입력해주세요 : ")
    try{
        answer= Console.readLine()!!.toInt()
    } catch (e:Exception){
        throw IllegalArgumentException()
    }

    if(!isValidNum(answer)) throw IllegalArgumentException()

    for(divideTime in 1 ..3){
        answerList.add(answer/divideNum)
        answer %= divideNum
        divideNum /= 10
    }

    return answerList //List<Int>형식으로 변환 후 리턴

}


