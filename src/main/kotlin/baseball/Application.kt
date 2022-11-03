package baseball

import camp.nextstep.edu.missionutils.Randoms

fun getRandomNumber() :String { // 랜덤으로 숫자를 뽑아 3자리 수 문자형으로 반환해주는 함수
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

fun checkNumber() { // 잘못 입력했을 시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

    print("숫자를 입력해주세요 : ")
    var user = readLine()

}


fun startgame(){ //게임 시작 문구 출력 (최초 한번만 실행)
    println("숫자 야구 게임을 시작합니다.")
}

fun main() {
    var randomNumber = ""

    startgame()
    randomNumber=getRandomNumber() // 숫자가 무엇인지 보여줄 필요는 없으므로 메서드 호출만
    println(randomNumber) // 임시 확인용 후에 제거 예정
    checkNumber()


}
