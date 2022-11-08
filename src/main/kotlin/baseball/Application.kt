package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다")
    //play()

}
fun play(){
    var playing = true
    while(playing){
        var Correct=false
        var computerNumber = setComputerNumber()

        while(!Correct){
            var userNumber = UserNumber()
            userNumber.setInputNumber()
            Correct = checkResult(computerNumber,userNumber.userNumber)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        playing = checkReplay()
    }
}
fun checkReplay(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
    var replay = Console.readLine()
    checkValidReplay(replay.toInt())
    if(replay.toInt()==1){
        return true
    }
    return false

}
fun checkValidReplay(replay : Int){
    if(replay != 1 && replay != 2){
        throw throw IllegalArgumentException("input only 1 or 2")
    }
}
fun checkResult(computer : List<Int>, user : List<Int>): Boolean {
    if(checkNothing(computer,user)){
        println("낫싱")
        return false
    }
    var strike = checkStrike(computer, user)
    var ball = checkBall(computer, user)-strike
    if(strike==3){
        println("${strike}스트라이크")
        return true
    }
    if(strike==0){
        println("${ball}볼")
        return false
    }
    println("${ball}볼 ${strike}스트라이크")
    return false
}

fun checkStrike(computer : List<Int>, user : List<Int>): Int {
    var strike = 0
    for(i in 0..2){
        if(computer[i] == user[i]){
            strike++
        }
    }
    return strike
}
fun checkBall(computer : List<Int>, user : List<Int>): Int {
    var ball = 0
    val intersectNumber = computer.toSet().intersect(user.toSet())
    ball = intersectNumber.size
    return ball
}
fun checkNothing(computer : List<Int>, user : List<Int>): Boolean {
    val intersectNumber = computer.toSet().intersect(user.toSet())
    if(intersectNumber.size==0){
        return true
    }
    return false
}
//정답을 랜덤으로 생성
fun setComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

class UserNumber(){
    var userNumber= mutableListOf<Int>()
    //숫자 입력
    fun setInputNumber(){
        print("숫자를 입력해주세요: ")
        var s= Console.readLine()
        for(i in s) {
            userNumber.add(i.toString().toInt())
        }
        checkValid()
    }
    //유효값 체크
    fun checkValid(){
        if(userNumber.size>3){
            throw IllegalArgumentException("input many number")
        }
        if(userNumber.size<3){
            throw IllegalArgumentException("input few number")
        }
        for(i in userNumber){
            if(i<1 || i>9){
                throw IllegalArgumentException("out of range")
            }
        }
        if(userNumber[0]==userNumber[1] || userNumber[0]==userNumber[2] || userNumber[1]==userNumber[2]){
            throw IllegalArgumentException("exist same number")
        }
    }
}
