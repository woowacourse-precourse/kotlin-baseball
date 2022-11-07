package baseball

import camp.nextstep.edu.missionutils.Randoms

fun playGame(){
    //컴퓨터 숫자 만들기
    //리드미 파일을 참조함
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    message(computer)
    print("3개의 숫자를 모두 맞히셨습니다!")
    println("게임 종료")

    nextGame() //게임 한 턴 후 다음 게임 의사 여부를 묻기
}

fun nextGame(){
    var select = 0
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    select= readLine().toInt()
    if(select==1)
        playGame()
    else if(select==2)
        println("게임을 종료합니다!")
}



fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}
