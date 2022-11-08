package baseball


class GamePrint {

    private val gl = GameLogic()

    fun gameStart(){

        gl.gameStart()
        result()
    }
    fun inputNum(){
        print("숫자를 입력해주세요 : ")
        gl.userInput()
    }
    fun result(){
        inputNum()
        val ballCnt = gl.comparison()["ball"]
        val strikeCnt = gl.comparison()["strike"]
        if(ballCnt!! > 0){
            print("${ballCnt}볼 ")
        }
        if(strikeCnt!! > 0){
            print("${strikeCnt}스트라이크 ")
        }
        if(strikeCnt + ballCnt == 0){
            print("낫싱")
        }
        println()
        if(strikeCnt == 3){
            answer()
            if(gl.gameProgress()){
                gameStart()
            } else{
                return
            }
        }
        else{
            result()
        }

    }
    private fun answer(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}