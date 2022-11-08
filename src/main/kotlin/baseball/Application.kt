package baseball
import kotlin.text.toInt
import kotlin.io.println
import kotlin.collections.mutableListOf
import camp.nextstep.edu.missionutils.Randoms

var strike :Int = 0
var ball : Int = 0
val inputnum : Array<Int?> = arrayOfNulls<Int>(3)
val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
fun main(args : ArrayList<String>) :Int
{
    playinggame()
    var doplay : Int = 0
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    doplay = readLine()!!.toInt()
    if (doplay == 1) playinggame()
    if (doplay == 2) return 0;
    return 0;
}
fun playinggame() : Int
{
    val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
    println("숫자 야구 게임을 시작합니다.")
    var i : Int = 0
    println("숫자를 입력해주세요 : ")
    val inputnum : Array<Int?> = arrayOfNulls<Int>(3)
    inputnum[2] = i % 10
    inputnum[1] = i % 10
    inputnum[0] = i % 10
    inputIllegal(inputnum)
    val (strike, ball) = checknum();
    if (print_message() == 0) return (0);
    return -1;
}
fun inputIllegal(inputnum : Array<Int?>) : Int
{
    if (inputnum.size != 3)                                                                     throw IllegalArgumentException("3자리 수가 아닙니다.");
    inputnum.forEach { 
        if (it !in 1..9)                                                                        throw IllegalArgumentException("1~9 사이 수를 입력해주세요.")
    }                      
    if (inputnum[0]==inputnum[1] || inputnum[0]==inputnum[2] || inputnum[1]==inputnum[2])       throw IllegalArgumentException("중복된 값 입니다.")
    return(0);
}
fun checknum() : Pair<Int, Int>
{
    var ball = 0;
    var strike = 0;
    for (i in 0..3 step(1))
        for (j in 0..3 step(1)) checknum02(i, j)
    return Pair(ball,strike)
}
fun checknum02(i : Int, j :Int) : Pair<Int, Int>
{
    if (comAnswer[i] == inputnum[j]){
        if (i == j) strike++;
        else ball++;
    }
    return Pair(ball,strike)
}
fun print_message() : Int
{
    var doplay : Int = 0

    if (strike == 3)
    {
        println("$strike 스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        doplay = readLine()!!.toInt()
        if (doplay == 2) return (0)
        else playinggame()
    }
    if (strike == 0 && ball > 0 && ball <= 3)
        println("$ball 볼")
    if (ball == 0 && strike > 0 && strike <= 3)
        println("$strike 스트라이크")
    if (strike == 0 && ball == 0)
        println("낫싱")
    println("$ball 볼 $strike 스트라이크")
    return 1;
}
fun make_answer(comAnswer: Array<Int>) 
{
    val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
    var switch = BooleanArray(10)
    for (i in switch.indices)
    {
        switch[i] = false 
    }
    var w =0 
    while(w<3)
    {   
        var r = (Math.random() * 10).toInt()
        if(switch[r]==false)
        {
            switch[r] =true 
            comAnswer[w] = r + 1 
            w++
        }
    }
}