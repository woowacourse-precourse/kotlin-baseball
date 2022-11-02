package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console

fun main() {
    var hitnumber= createthreenumber()

    while(true){
        println("숫자 야구 게임을 시작합니다.")
        println("숫자를 입력해주세요 : ")
        var usernumber = readLine()!!.toString()
        if(!errorcheck(usernumber)){//에러발생시 에러 던지고 종료
            throw IllegalArgumentException()
            break
        }




    }

}

fun createthreenumber():Int{
    var returnvalue=pickNumberInRange(1,9)
    while(true) {
        var picknumber = pickNumberInRange(1, 9)
        if((returnvalue/10)==picknumber||(returnvalue%10)==picknumber)//중복이 있으면 루프 다시
            continue
        returnvalue=returnvalue*10+picknumber//중복 없으면 추가

        if(returnvalue>99)//세 자리 수가 되었으면
            break
    }

    return returnvalue
}

fun errorcheck(checkword:String):Boolean {

    var number = checkword.toIntOrNull()
    if (number == null)
        return false
    if(number>999||number<100)
        return false
    if(!checkoverlap(number))
        return false


    return true
}

fun checkoverlap(checkInt:Int):Boolean{
    var first = checkInt/100
    var second = (checkInt%100) / 10
    var third = checkInt%10

    if(first==second || second==third || first==third)
        return false

    return true
}