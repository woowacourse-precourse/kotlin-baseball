package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer = mutableListOf<Int>()
    var num = 0
    var end = true
    computer = Random_Num()
    while (end){
        if (num == 1) computer = Random_Num()
        num = k_Baseball(computer)
        end = Retry(num)
    }
}

fun Retry(num : Int) : Boolean{
    if (num == 2) return false
    else return true
}

fun k_Baseball(comp : MutableList<Int>) : Int{
    print("숫자를 입력해주세요 : ")
    var num : Int = readLine()!!.toInt()
    if (num in 0 .. 999) num
    else throw IllegalArgumentException("ERROR!")
    val list = mutableListOf<Int>()
    var str = 0
    var ball = 0
    var result = 1
    list.add((num / 100).toInt())
    num = num % 100
    list.add((num / 10).toInt())
    num = num % 10
    list.add(num)

    for (i in 0..2){
        if (comp[i] == list[i]) str++
        else if (list[i] in comp) ball++
        else continue
    }

        if (str == 0 && ball == 0) return str0_ball0()
        else if (str == 0) return only_Ball(ball)
        else if (str == 3) return Clear()
        else if (ball == 0) return only_Strike(str)
        else return str_ball(str, ball)

}
fun str0_ball0() : Int{
    println("낫싱")
    return 0
}

fun only_Ball(ball : Int) : Int{
    println("${ball}볼")
    return 0
}

fun only_Strike(str : Int) : Int{
    println("${str}스트라이크")
    return 0
}

fun str_ball(str : Int, ball : Int) : Int{
    println("${ball}볼 ${str}스트라이크")
    return 0
}

fun Clear() : Int{
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var n : Int = readLine()!!.toInt()
    return n
}

fun Random_Num() : MutableList<Int>{
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}