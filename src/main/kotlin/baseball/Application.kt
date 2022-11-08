package baseball

fun getUserNumber(): String {

    print("숫자를 입력해주세요 :")
    val userNumber = readLine()

    if(userNumber.isNullOrEmpty()||userNumber.length!=3)
        throw IllegalArgumentException("잘못입력하셨습니다.")


    for(i in userNumber){
        if(i !in '0'..'9'){
            throw IllegalArgumentException("잘못입력하셨습니다.")}
    }
    if(userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]){
        throw IllegalArgumentException("중복되지 않는 수만 입력 가능합니다.")
    }

    return userNumber
}

