package baseball
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
fun main() {
    println("숫자 야구 게임을 시작합니다.")

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




