package baseball

import java.util.Scanner

val Range = (1..9)

var Input = ""
var Input_List = mutableListOf<Int>()

//0 = S , 1 = B , 2 = Null
var Compare_List = mutableListOf<Int>(0,0)

var Result = ""
var Cpu_Num = mutableListOf<Int>()

//예외 확인 함수
fun Check_Exception(Input: String) {
    var token = Input.chunked(1)

    if (token.size != 3)
        throw IllegalArgumentException()

}

fun Split_Input (Input :String) :List<Int>{
    var token = Input.chunked(1)
    for (i in 0..2)
        Input_List[i] = token[i].toInt()

    return Input_List.toList()
}

//컴퓨터 숫자 선택
fun Get_Cpu_Num (): List<Int> {
    val Set = mutableListOf<Int>()
//    val Set = HashSet<Int>()

//    while (Set.size < 5) {
//        var d = Range.random()
//        Set.add(d.toInt())
//    }
//
//    Cpu_Num.toCollection(sortedSetOf())

    while (Set.size < 3){
        Set.add(Range.random())
    }
    Cpu_Num = Set
    print(Cpu_Num)

    return Cpu_Num.toList()
}

//게임 시작 하나한 비교
fun Game_Start (List: List<Int>): List<Int> {

    List.forEach {i ->
        for (j in 0..3) {
            Compare_Num(List[i], Cpu_Num[j],i,j)
        }
    }
    if(Compare_Exception(Compare_List))
        //print("낫싱")
        Compare_List[2] = 1

    return Compare_List.toList()
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

fun Print_Result (Result_List : List<Int>) : String {
    if (Result_List[2] >= 1)
        print("낫싱")
    else if (Result_List[1] != 0) {
        Result += Result_List[1].toChar() + "볼"
        print(Result)
    } else if (Result_List[0] > 0 && Result_List[0] < 3) {
        Result += Result_List[0].toChar() + "스트라이크"
        print(Result)
    } else if (Result_List[0] == 3)
        Result = "3스트라이크 \n 3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    return Result.toString()
}

fun Check_Game_End(): Boolean {
    val Try = 0
    var R_try = false

    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    println(Try)

    if (Try == 1)
        R_try = false

    else if (Try == 2)
        R_try = true

    return R_try
}

fun main() = with(Scanner(System.`in`)){
    var Retry = true

    print("숫자 야구 게임을 시작합니다. \n")
    while (Retry){

        //상대방 번호 설정
        //Get_Cpu_Num()

        print("숫자를 입력해주세요 :")

        Cpu_Num = Split_Input("589") as MutableList<Int>

        //사용자 입력
        println(Input)

        Check_Exception(Input)

        Split_Input(Input)

        Game_Start(Input_List)

        Print_Result(Compare_List)

        if (Result == "3스트라이크")
            Retry = Check_Game_End()

    }
}
