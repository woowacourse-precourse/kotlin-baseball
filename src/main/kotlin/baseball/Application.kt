package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main(){
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}

fun playGame(){
    val computer=getComputerNumber()
    getGameResult(computer)
}

fun endMessage(){
    println("게임을 종료합니다!")
    return
}

fun askRestart(){
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val select= Console.readLine()
    if(select=="1"){
        playGame()
    }
    if(select=="2"){
        endMessage()
    }
}

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

fun getComputerNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while(computerNumber.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computerNumber.contains(randomNumber)){
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun getUserNumber(): String {

    print("숫자를 입력해주세요 :")
    val userNumber = readLine()

    if(userNumber.isNullOrEmpty()||userNumber.length!=3)
        throw IllegalArgumentException("잘못입력하셨습니다.")


    for(i in userNumber){
        if(i !in '0'..'9'){
            throw IllegalArgumentException("잘못입력하셨습니다.")}
    }
    if(userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]){
        throw IllegalArgumentException("중복되지 않는 수만 입력 가능합니다.")
    }

    return userNumber
}

