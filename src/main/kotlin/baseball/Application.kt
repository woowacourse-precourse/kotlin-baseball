package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
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

fun countBallAndStrke(playersAnswer:String):Array<Int>{
    var strikeCount=0
    var ballCount=0
    val strikeAndBall= arrayOf(0,0)

    for(i in 0 until 3){
        val containment=answer.contains(playersAnswer[i])
        if(containment && answer[i]==playersAnswer[i]){
            strikeCount++
        }
        else if(containment){
            ballCount++
        }

    }
    strikeAndBall[0]=strikeCount
    strikeAndBall[1]=ballCount

    return strikeAndBall
}
fun playGame(){
    lateinit var playerAnswer:String
    lateinit var ballCountAndStrikeCount :Array<Int>
    while(true){
        playerAnswer= readln()
        if(playerAnswer.length!=3){
            throw IllegalArgumentException("number's digit should be 3.")
        }//잘못된 입력일 경우 illegalargumentexception 발생

        ballCountAndStrikeCount= countBallAndStrke(playerAnswer)

        if(ballCountAndStrikeCount[0]==3){
            println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"+
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
            )
            return
        }

        if(ballCountAndStrikeCount[0]==0 && ballCountAndStrikeCount[1]==0){
            println("낫싱")
        }else if(ballCountAndStrikeCount[0]==0){
            println("${ballCountAndStrikeCount[1]}볼")
        }else if(ballCountAndStrikeCount[1]==0){
            println("${ballCountAndStrikeCount[0]}스트라이크")
        }else{
            println("${ballCountAndStrikeCount[1]}볼 ${ballCountAndStrikeCount[0]}스트라이크")
        }
    }

}


fun main() {
    var playNewGameOrStop by Delegates.notNull<Int>()

    do{
        prepareNewGame()
        playGame()
        playNewGameOrStop= readln().toInt()
        if(playNewGameOrStop !=1 && playNewGameOrStop!=2){
            throw IllegalArgumentException("input should be 1 or 2.")
        }

    }while(playNewGameOrStop==1)


}