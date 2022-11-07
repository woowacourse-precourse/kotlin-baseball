package baseball
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer_number = create_computer_number()
    game_Start(computer_number)
}
fun InputNumber(): String{ //숫자 입력
    print("숫자를 입력해주세요: ")
    var number = readLine().toString()
    iscorrectNumber(number)

    return number
}

fun iscorrectNumber(number : String){ // 숫자의 조건이 맞는지 검사
    var list = number.toList()
    if(number.length != 3 ||list.distinct().size != 3 || '0' in list) {
        throw IllegalArgumentException(number)
    }
    for(i : Int in 0..2) {
        if (number[i].code < 49 || number[i].code > 57) { //숫자가 아닌 문자가 입력됐을경우
            throw IllegalArgumentException(number)
        }
    }
}
fun create_computer_number(): String{
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1,9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    var computer_number = computer.joinToString("")
    return computer_number
}
fun test_number(computer_number: String,number: String){ // 스트라이크 볼 갯수 검사
    var strike = 0
    var ball = 0
    for (i : Int in 0..2){
        if(computer_number[i]==number[i]){
            strike+=1
        }
        else if (computer_number[i] != number[i] && number[i] in computer_number){
            ball+=1
        }
    }
    return when{
        strike == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            restart_game()
        }
        strike == 0 && ball == 0 -> {
            println("낫싱")
            game_Start(computer_number)
        }
        strike == 0 && ball!=0 ->{
            println("$ball 볼")
            game_Start(computer_number)
        }
        strike != 0 && ball == 0 ->{
            println("$strike 스트라이크")
            game_Start(computer_number)
        }
        else -> {
            println("${ball}볼 ${strike}스트라이크")
            game_Start(computer_number)
        }
    }
}
fun restart_game() { // 게임 재시작
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choose = Integer.parseInt(readLine())
    if (choose == 1){
        var computer_number = create_computer_number()
        game_Start(computer_number)
    }
    else if(choose!=2){
        var choose_number =choose.toString()
        throw IllegalArgumentException(choose_number)
    }

}
fun game_Start(computer_number: String){ // 게임시작
    var number = InputNumber()
    test_number(computer_number,number)
}