package baseball

fun getGameResult(computerNumber: MutableList<Int>){
    var strike = 0
    var ball = 0
    var index = 0
    val userNumber = getUserNumber()

    for(i in userNumber){
        if(computerNumber.contains(i - '0'))
            ball++
        if(computerNumber[index] == i - '0'){
            ball--
            strike++
        }
        index++
    }

    if(strike == 3){
        println("${strike}스트라이크")
        print("3개의 숫자를 모두 맞히셨습니다!")
        println(" 게임종료")
        askRestart()
        return
    }

    else if(strike==0&&ball==0)
        println("낫싱")
    else if(strike==0)
        println("${ball}볼")
    else if(ball==0)
        println("${strike}스트라이크")
    else
        println("${ball}볼 ${strike}스트라이크")

    getGameResult(computerNumber)
}


