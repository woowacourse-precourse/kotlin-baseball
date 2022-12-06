package baseball.utils

fun String.inputTypeException(){
    try {
        this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

//길이 체크
fun String.checkNumbersLength(size:Int){
    if(this.length != size)
        throw IllegalArgumentException()
}

//1~9 숫자인지 체크
fun String.checkNumberRange(start:Int,end:Int){
    for(index in this.indices){
        if(this[index]-'0' !in start..end)
            throw IllegalArgumentException()
    }
}