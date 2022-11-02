package baseball

import camp.nextstep.edu.missionutils.Randoms

fun getRandomNumber() :String { // 문자형으로 3자리 수 반환
    var randomNum=""
    var num =0
    while (randomNum.length<3){
        num = Randoms.pickNumberInRange(1, 9) // 1~9까지
        if (!randomNum.contains(num.toString())){
            randomNum+=num.toString()
        }
    }
    return randomNum
}


fun startgame(){ //게임 시작 문구 출력 (최초 한번만 실행)
    println("숫자 야구 게임을 시작합니다.")
}

fun main() {
    startgame()
    getRandomNumber()
}
