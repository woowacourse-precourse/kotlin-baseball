package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

fun main() {
    start_message()
    while(true) {
        val computer= make_random_three_number()

        while(true) {
            var input=input_three_number()
            val input_split=number_split(input)

            input_exception(input_split)

            val ball_and_strike= make_strike_ball(input_split,computer)

            print_strike_ball(ball_and_strike)

            if(answer_and_gameover(ball_and_strike)){ break }
        }
        question_message()
        val num= question_answer()
        if(game_or_quit(num)){ continue }
        else{ break }
    }
}

fun start_message(){ println("숫자 야구 게임을 시작합니다.") }
fun make_random_three_number(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) { computer.add(randomNumber) }
    }
    return computer
}
fun input_three_number():Int{
    print("숫자를 입력해주세요 : ")
    try {
        var input = readLine()!!.toInt()
        return input
    }catch (e:NumberFormatException){ throw IllegalArgumentException() }
}
fun number_split(input:Int):List<Int>{
    val input_split_temp = mutableListOf<Int>()
    var input=input
    while (input != 0) {
        val num = input % 10
        input_split_temp.add(num)
        input /= 10
    }
    val input_split = input_split_temp.reversed()
    return input_split
}

fun input_exception(input_split: List<Int>){
    val input_split_set=input_split.toSet()

    if(input_split_set.size!=3){ throw IllegalArgumentException() }
    else if(input_split.size!=3){ throw IllegalArgumentException() }
}

fun make_strike_ball(input_split: List<Int>, computer:List<Int>):List<Int>{
    val ball_and_strike = mutableListOf<Int>(0, 0)
    // ball_and_strike[0] => ball
    // ball_and_strike[1] => strike

    for (i in 0..input_split.size - 1) {
        if (input_split[i] == computer[i]) { ball_and_strike[1] += 1 }
        else if (input_split[i] in computer) { ball_and_strike[0] += 1 }
    }
    return ball_and_strike
}

fun print_strike_ball(ball_and_strike:List<Int>){
    if(ball_and_strike[0]==0 && ball_and_strike[1]==0){ println("낫싱") }
    else if (ball_and_strike[0] == 0) { println("${ball_and_strike[1]}스트라이크") }
    else if (ball_and_strike[1] == 0) { println("${ball_and_strike[0]}볼") }
    else { println("${ball_and_strike[0]}볼 ${ball_and_strike[1]}스트라이크") }
}

fun answer_and_gameover(ball_and_strike: List<Int>):Boolean{
    if(ball_and_strike[1]==3){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    else{ return false }
}

fun question_message(){ println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.") }

fun question_answer():Int{
    try{
        val num=readLine()!!.toInt()
        return num
    }catch (e:NumberFormatException){ throw IllegalArgumentException() }
}

fun game_or_quit(num:Int):Boolean{
    if(num==2){ return false }
    else if(num==1){ return true }
    else{ throw IllegalArgumentException() }
}