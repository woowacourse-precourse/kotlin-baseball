package baseball

import camp.nextstep.edu.missionutils.Randoms

fun playGame(){
    //컴퓨터 숫자 만들기
    //리드미 파일을 참조함
    val computer=getComputerNumber()


    message(computer)
    print("3개의 숫자를 모두 맞히셨습니다!")
    println("게임 종료")

    nextGame() //게임 한 턴 후 다음 게임 의사 여부를 묻기
}

fun nextGame(){
    var select = 0
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    select= readLine()!!.toInt()
    if(select==1)
        playGame()
    else if(select==2)
        println("게임을 종료합니다!")
}

fun message(computer: MutableList<Int>){
    //판단 및 메시지 출력

    var strike=0
    var ball=0
    val index=0

    val user=getUserNumber()

    if (user != null) {
        for (i in user){
            if(computer.contains(i-'0'))
                ball++
            if(computer[index]==i-'0'){
                ball--
                strike++
            }
        }
    }

    if(strike==3)
        println("${strike}스트라이크")
    else if(strike==0&&ball==0)
        println("낫싱")
    else if(strike==0)
        println("${ball}볼")
    else if(ball==0)
        println("${strike}스트라이크")
    else
        println("${ball}볼 ${strike}스트라이크")

}

fun getComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserNumber(): String? {
    //사용자 숫자 입력하기

    println("숫자를 입력해주세요 :")
    val user = readLine()

    //예외처리
    if(user.isNullOrEmpty() ||user.length!=3)
        throw IllegalArgumentException()

    for (i in user) {
        if (i !in '0'..'9')
            throw IllegalArgumentException()
    }
    return user
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}