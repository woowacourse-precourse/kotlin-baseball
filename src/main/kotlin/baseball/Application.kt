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

    playUntilCorrect(computerNum)

    return 0 //임시 코드
}

fun playUntilCorrect(computerNum: List<Int>){ //정답을 맟줄때 까지 반복하는 함수
    var userNum:List<Int>
    var ballAndStrike:List<Int>
    var untilCorrect=true

    while(untilCorrect){
        userNum= inputUserNum()

        ballAndStrike=getBallAndStrike(computerNum,userNum)
        untilCorrect= printBallAndStrike(ballAndStrike)

    }
}

fun getBallAndStrike(computerNum: List<Int>,
                     userNum:List<Int>):List<Int>{
    var ballCount:Int
    var strikeCount:Int
    val countList= mutableListOf<Int>()

    ballCount= getBall(computerNum,userNum)
    strikeCount= getStrike(computerNum, userNum)

    ballCount-=strikeCount

    countList.add(ballCount)
    countList.add(strikeCount)

    return countList

}

fun getBall(computerNum: List<Int>,
            userNum: List<Int>):Int{
    var ballCount=0
    for(idx in userNum.indices){
        if(computerNum.contains(userNum[idx])){
            ballCount+=1
        }
    }
    return ballCount
}
fun getStrike(computerNum: List<Int>,
              userNum: List<Int>):Int{
    var strikeCount=0
    for(idx in userNum.indices){
        if(userNum[idx]==computerNum[idx]){
            strikeCount+=1
        }
    }
    return strikeCount
}

fun printBallAndStrike(ballAndStrike:List<Int>):Boolean{
    var ballCount=ballAndStrike[0]
    var strikeCount=ballAndStrike[1]

    if(ballAndStrike.contains(0)){ //볼과 스트라이크 중 0이 있을 때
        if(ballCount!=0){
            println("${ballCount}볼")
        }
        if(strikeCount!=0){
            println("${strikeCount}스트라이크")
        }
        if(ballCount==0 && strikeCount==0){
            println("낫싱")
        }
    }
    else{ //n볼 m 스트라이크인 경우 n,m>0
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }

    return strikeCount!=3 //3스트라이크인 경우 false를 리턴한다다


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


