package baseball

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")
    print(readNum())

}

fun readNum(): MutableList<String> {
    val number = readLine()!!
    val numberArray = number.split("") as MutableList<String>
    numberArray.removeAt(0)
    numberArray.removeAt(numberArray.size-1)

    if (number.length == 3 && numberArray[0] != numberArray[1] && numberArray[1] != numberArray[2] && numberArray[0] != numberArray[2]) {
        return numberArray
    }
    else throw IllegalArgumentException()

}

