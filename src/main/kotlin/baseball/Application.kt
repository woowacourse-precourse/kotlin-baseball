package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun createRandomNumbers(): List<Int>{
    val numbers: MutableList<Int> = mutableListOf()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers
}
fun enterExpectedNumber(): List<Int>{
    val input_numbers: MutableList<Int> = mutableListOf(0,0,0)
    print("숫자를 입력해주세요 : ")
    var input_temp: String = Console.readLine()

    //예외 처리 - 3글자를 입력 받았는가?
    if(input_temp.length!=3){
        throw IllegalArgumentException("입력 값이 3자가 아닙니다.")
    }

    //예외 처리 - 서로 다른 숫자인가?
    if(input_temp[0]==input_temp[1]||
        input_temp[0]==input_temp[2]||
        input_temp[1]==input_temp[2]){
        throw IllegalArgumentException("같은 숫자를 입력할 수 없습니다.")
    }

    //예외처리 - 0이 포함되어 있는가?
    if('0' in input_temp){
        throw IllegalArgumentException("0은 입력할 수 없습니다.")
    }

    //예외 처리 - 숫자인가?
    for(i in 0..input_temp.length-1) {
        if(input_temp[i] !in "0123456789"){
            throw IllegalArgumentException("입력 값이 숫자가 아닙니다.")
        }
        //숫자라면 inputnumbers에 리스트로 저장.
        input_numbers[i] = input_temp[i].code - '0'.code
    }

    return input_numbers
}
fun checkBallAndStrike(user: List<Int>,computer: List<Int>){
    var strike_count: Int = 0
    var ball_count: Int =0
    user.forEach{
        if(it in computer) ball_count++
    }
    for (i in 0..2) {
        if(user[i]==computer[i]){
            ball_count--
            strike_count++
        }
    }
    if(ball_count==0 && strike_count==0) println("낫싱")
    if(ball_count==0 && strike_count!=0) println("${strike_count}스트라이크")
    if(ball_count!=0 && strike_count==0) println("${ball_count}볼")
    if(ball_count!=0 && strike_count!=0) println("${ball_count}볼 ${strike_count}스트라이크")
}
fun play(){
    val computer: List<Int> = createRandomNumbers()
    var user: List<Int> = mutableListOf()
    while(computer!=user){
        user= enterExpectedNumber()
        checkBallAndStrike(user,computer)
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}
fun askContinue(): Boolean{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var answer: String = Console.readLine()
    if(answer !in "12"){
        throw IllegalArgumentException("입력 값이 1 또는 2가 아닙니다.")
    }
    return answer=="1"
}

fun main() {
    var flag: Boolean = true
    println("숫자 야구 게임을 시작합니다.")
    while(flag){
        play()
        flag = askContinue()
    }
}