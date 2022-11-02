package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console

fun main() {
    var hitnumber= createthreenumber()
    var check=1

    while(true){
        println("숫자 야구 게임을 시작합니다.")
        println("숫자를 입력해주세요 : ")
        var usernumber = readLine()!!.toString()
        if(!errorcheck(usernumber)){//에러발생시 에러 던지고 종료
            throw IllegalArgumentException()
            break
        }
        if(judgementnumber(usernumber.toInt(),hitnumber))
            break
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

fun judgementnumber(usernumber:Int, computernumber:Int):Boolean{
    var user_first = usernumber/100
    var user_second = (usernumber%100)/10
    var user_third = usernumber%10
    var computer_first = computernumber/100
    var computer_second = (computernumber%100)/10
    var computer_third = computernumber%10

    if(user_first==computer_first && user_second==computer_second && user_third==computer_third){
        println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return true//숫자 재지정 등으로 인하여 만드는 방법 다시 생각할 필요 있음.
    }

    return false//3스트라이크 이외는 false
}