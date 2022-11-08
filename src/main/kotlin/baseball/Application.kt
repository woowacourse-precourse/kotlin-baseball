package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine
import java.util.*

fun checkInput(){

}

fun isStart() : Boolean{
    val input= readLine()
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return input=="1"
}

fun getComputerNumber() : String{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun getUserNumber(): String{
    print("숫자를 입력해주세요 : ")
    val input= readLine()
    return input
}

fun isUserNumberValid(user_name: String): Boolean{
    try{
        user_name.toInt()
    } catch (e:NumberFormatException){
        return false
    }

    if(user_name.length!=3) return false
    if(user_name.contains("0")) return false

    val count: MutableList<Int> = ArrayList(Collections.nCopies(10, 0))
    for(num in user_name) {
        count[num.code - '0'.code]++
        if (count[num.code - '0'.code] >= 2) return false
    }

    return true
}

fun isMatched(com_number:String, user_number: String): Boolean{
    var bool_cnt=0
    var strike_cnt=0

    for(i in 0..2){
        for(j in 0..2){
            if(i==j && user_number[i]==com_number[j]) strike_cnt++
            else if(user_number[i]==com_number[j]) bool_cnt++
        }
    }

    if(strike_cnt==3){
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return true
    }
    else if(strike_cnt==0 && bool_cnt==0){
        println("낫싱")
    }
    else if (bool_cnt == 0)
        println("${strike_cnt}스트라이크")
    else if (strike_cnt == 0)
        println("${bool_cnt}볼")
    else
        println("${bool_cnt}볼 ${strike_cnt}스트라이크")

    return false
}
fun startGame(){
    val com_number=getComputerNumber()
    do{
        val user_number=getUserNumber()
        if(!isUserNumberValid(user_number)) throw IllegalArgumentException("error")
    }while(!isMatched(com_number, user_number))
}
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do{
        startGame()
    }while(isStart())
}