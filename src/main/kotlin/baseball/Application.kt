package baseball

import kotlin.random.Random

fun checkNumber( str: String, ans: List<Int> ): Int{
    var strike = 0
    var ball = 0
    var idx = 0

    for(elem in str){       //사용자가 입력한 문자열을 한 글자씩 확인하며
        if(ans.contains(elem - '0')){       // ans 에 있는 숫자이면
            if(ans[idx] == elem - '0')      //strike or ball 을 카운트 해준다
                strike++
            else
                ball++
        }

        idx++
    }

    if(strike == 3) {     //3스트라이크 -> 정답!
        println("${strike}스트라이크")
        return 1
    }
    else if(strike==0 && ball==0){
        println("낫싱")
    }
    else if(strike==0){
        println("${ball}볼")
    }
    else if(ball==0){
        println("${strike}스트라이크")
    }
    else{
        println("${ball}볼 ${strike}스트라이크")
    }

    return 0
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer = mutableListOf<Int>()     //사용자가 맞춰야 할 컴퓨터의 숫자이다
    while (computer.size < 3) {
        val randomNumber = Random.nextInt(1, 10)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    var regame = 0
    while (regame != 2) {

        var collect = 0   //정답을 맞췄는지 확인해줄 변수 -> 1이 되면 정답임!
        while (collect != 1) {
            println("숫자를 입력해주세요 : ")
            val temp = readLine()!!
            collect = checkNumber(temp, computer)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}
