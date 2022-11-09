package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var randomNumber100: Int = 0
var randomNumber10 :Int =0
var randomNumber1 :Int = 0

var userInput : Int =0
var userInput1 : Int = 0
var userInput10 : Int = 0
var userInput100 : Int = 0

var strike : Int = 0
var ball : Int = 0

fun main() {
    println("숫자야구게임을 시작합니다.")
    do{
        randomMaker()
        do{
            print("숫자를 입력해 주세요 : ")
            inputValidationCheck(Console.readLine())
            checkStrikeBall()
        }while(strike != 3)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.")
    }while(restartCheck(Console.readLine()))

}

fun randomMaker(): Int {
    randomNumber100 = Randoms.pickNumberInRange(1, 9)

    do {
        randomNumber10 = Randoms.pickNumberInRange(1, 9)
    } while (randomNumber100 == randomNumber10)

    do {
        randomNumber1 = Randoms.pickNumberInRange(1, 9)
    } while (randomNumber100 == randomNumber1 || randomNumber1 == randomNumber10)

    return 100 * randomNumber100 + 10 * randomNumber10 + randomNumber1

}

fun inputValidationCheck(input : String)  {
    try {
        userInput = input.toInt()
    }catch (e : NumberFormatException){
        throw IllegalArgumentException("User의 입력이 적절하지 않습니다.")
    }

    if( userInput in 111..999){
        userInput
    }else{
        throw IllegalArgumentException("User의 입력값이 적정범위를 벗어났습니다.")
    }
    var temp = userInput
    userInput100 = temp/100
    temp -= (100 * userInput100)
    userInput10 = temp/10
    userInput1 =  temp-(10*userInput10)

    if((userInput1 == userInput10)
        || (userInput1 == userInput100)
        || (userInput10 == userInput100)
    ){
        throw IllegalArgumentException("User의 입력값 중 중복되는 수가 있습니다.")
    }
}

fun checkStrikeBall( ){
    strike = 0
    ball = 0

    if(userInput100 == randomNumber100){
        strike ++
    }

    if(userInput10 == randomNumber10){
        strike ++
    }

    if(userInput1 == randomNumber1){
        strike ++
    }

    if((userInput100 == randomNumber10)
        || (userInput100 == randomNumber1)){
        ball ++
    }

    if((userInput10 == randomNumber100)
        || (userInput10 == randomNumber1)){
        ball ++
    }

    if((userInput1 == randomNumber100)
        || (userInput1 == randomNumber10)){
        ball ++
    }

    if(strike == 0 && ball == 0 ){
        println("낫싱")
    }else if(strike == 0) {
        println("${ball}볼")
    }else if(ball == 0){
        println("${strike}스트라이크")
    }else{
        println("${ball}볼 ${strike}스트라이크")
    }
}

fun restartCheck(input : String) : Boolean{
    val again : Int
    try {
        again = input.toInt()
    }catch (e : NumberFormatException){
        throw IllegalArgumentException("User의 입력이 적절하지 않습니다.")
    }

    if(again != 1 && again !=2){
        throw IllegalArgumentException("User의 입력이 적절하지 않습니다.")
    }

    return again == 1

}

