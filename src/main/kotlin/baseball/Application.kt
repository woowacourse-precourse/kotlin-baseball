package baseball

import camp.nextstep.edu.missionutils.Randoms
// import camp.nextstep.edu.missionutils.Console

val basic_list = mutableListOf<Int>()
fun make_number(): String {
    while (basic_list.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!basic_list.contains(randomNumber)) {
            basic_list.add(randomNumber)
        }
    }
    return basic_list.toString()
}

fun main() {
    print("숫자를 입력해주세요 : ")
    val input_number = readLine()
    if (input_number!!.length > 3)
        throw IllegalArgumentException() // throw??
    make_number()
}
