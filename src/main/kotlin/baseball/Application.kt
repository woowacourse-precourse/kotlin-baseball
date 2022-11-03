package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console

fun main() {
    var hitnumber= createthreenumber()
    var check=0

    while(true){
        println("숫자 야구 게임을 시작합니다.")
        print("숫자를 입력해주세요 : ")
        var usernumber = readLine()!!.toString()
        if(!errorcheck(usernumber)){//에러발생시 에러 던지고 종료
            throw IllegalArgumentException()
            break
        }
        check=judgementnumber(usernumber.toInt(),hitnumber)

        if(check==-1){
            throw IllegalArgumentException()
            break
        }

        if(check==2) {
            break
        }
        if(check==1){
            hitnumber= createthreenumber()
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

fun judgementnumber(usernumber:Int, computernumber:Int):Int{
    var user_first = usernumber/100
    var user_second = (usernumber%100)/10
    var user_third = usernumber%10
    var computer_first = computernumber/100
    var computer_second = (computernumber%100)/10
    var computer_third = computernumber%10

    var ball=0
    var strike=0

    if(user_first==computer_first)
        strike+=1
    if(user_second==computer_second)
        strike+=1
    if(user_third==computer_third)
        strike+=1

    if(user_first==computer_second||user_first==computer_third)
        ball+=1
    if(user_second==computer_first||user_second==computer_third)
        ball+=1
    if(user_third==computer_first||user_third==computer_second)
        ball+=1

    if(strike==3){
        print("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
        var check = readLine()!!.toInt()

        if(check!=1&&check!=2){//잘못된 입력일 경우
            return -1
        }
        return check
    }

    if(strike==0 && ball==0){
        println("낫싱")
        return 0
    }
    if(strike==0){
        println("$ball"+"볼")
        return 0
    }
    if(ball==0){
        println("$strike"+"스트라이크")
        return 0
    }

    println("$ball"+"볼 $strike"+"스트라이크")

    return 0
}