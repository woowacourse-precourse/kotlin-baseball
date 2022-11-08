package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다")
    //play()

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
