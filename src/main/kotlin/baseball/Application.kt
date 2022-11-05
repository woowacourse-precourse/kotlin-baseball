package baseball

fun inputNumber(): String? {//숫자 입력
    print("숫자를 입력해주세요 : ")
    val inputNumber = readLine()//string

    return inputNumber
}

fun main() {
    println(inputNumber())
}
