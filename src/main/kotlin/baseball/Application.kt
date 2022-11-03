package baseball

import java.util.Scanner
import kotlin.random.Random

val Range = (1..9)
val Input_List = mutableListOf<Int>()

//0 = S , 1 = B , 2 = Null
var Compare_List = mutableListOf<Int>(0,0)

var Result = mutableListOf<Int>()
var Cpu_Num = mutableListOf<Int>()

//컴퓨터 숫자 선택
fun Get_Cpu_Num (): List<Int> {

    for (i in 0..3)
        Cpu_Num = mutableListOf(Range.random())

    return Cpu_Num.toList()
}

//게임 시작 하나한 비교
fun Game_Start (List: List<Int>): List<Int> {
    List.forEach {i ->
        for (j in 0..3) {
            Compare_Num(List[i], Input_List[j],i,j)
        }
    }
    if(Compare_Exception(Compare_List))
        //print("낫싱")
        Result[3] = 1

    return Result.toList()
}

//비교 함수
fun Compare_Num (Cpu_Num: Int, Input_Num : Int, Cpu_idx : Int, Input_idx : Int): List<Int> {
    if (Cpu_Num == Input_Num || Cpu_idx == Input_idx)
        //S
        Compare_List[0]++
    else if (Cpu_Num == Input_Num || Cpu_idx != Input_idx)
        //B
        Compare_List[1]++


    return Compare_List.toList()
}

//비교 예외
fun Compare_Exception (Compare_List : List<Int>): Boolean {
    return Compare_List[0] == 0 || Compare_List[1] == 0
}

fun Print_Result (Result_List : List<Int>) : String{
    Result_List.forEach {
        Result += it + "볼"
    }

    return Result.toString()
}

fun main() = with(Scanner(System.`in`)){
    print("숫자 야구 게임을 시작합니다.")
    while (true){
        print("숫자를 입력해주세요 :")

        //상대방 번호 설정
        Get_Cpu_Num()

        //사용자 입력
        for (i in 0..3)
            println(Input_List[i])

        Game_Start(Input_List)

        Print_Result(Compare_List)
    }
}
