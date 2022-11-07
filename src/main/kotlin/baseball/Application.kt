package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var randomNumber100: Int = 0
var randomNumber10 :Int =0
var randomNumber1 :Int = 0


fun main() {
    TODO("프로그램 구현")


}

fun randomMaker() : Int{
    randomNumber100 =  Randoms.pickNumberInRange(1,9)

    do{
        randomNumber10 = Randoms.pickNumberInRange(1,9)
    }while(randomNumber100 == randomNumber10)

    do{
        randomNumber1 = Randoms.pickNumberInRange(1,9)
    }while(randomNumber100 == randomNumber1 || randomNumber1 == randomNumber10)

    val Number = 100*randomNumber100+10*randomNumber10+randomNumber1

    return Number

}

