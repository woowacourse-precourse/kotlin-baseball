package baseball

class GamePrint {
    fun gameStart(){
        println("숫자 야구 게임을 시작합니다.")
    }
    fun inputNum(){
        print("숫자를 입력해주세요 :")
    }
    fun result(){
        if(ballCount > 0)
            print("${ballCount}볼 ")
        if(strikeCount > 0)
            print("${strikeCount}스트라이크 ")
    }
    fun answer(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    fun gameProgress(){
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}