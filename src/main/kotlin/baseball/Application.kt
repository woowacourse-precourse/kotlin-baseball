package baseball

import kotlin.io.readLine
import kotlin.text.toInt
import kotlin.collections.mutableListOf

fun main() {
    
    var strike:Int = 0
    var ball:Int = 0


    val computerNumber = mutableListOf()
    while (computerNumber.size() < 3) {
        random(computerNumber)
    }

    while (1){
        strike = 0
        ball = 0
    var inputNumber:String=readLine()
    var userNumber = inputNumber.chunked(1)

    
    val result:list0f<Int>(resultCalculation(userNumber:List0f,computerNumber:List0f,strike:Int,ball:Int))

    if (result[0]<=2&&result[0]>=1&&result[1]==0){
        println("$result[0] 스트라이크")
    }
    else if (result[0]>=1&&result[1]>=1){
        println("$result[1] 볼 $result[0] 스트라이크")
    }
    else if (result[1]>=1&&result[0]==0){
        println("$result[1] 볼")
    }
    else if (strike==3){
        println("$result[0] 스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        break
    }
    else{
        println("낫싱")
    }
}
}

fun random(computerNumber:List0f){
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!computerNumber.contains(randomNumber)) {
        return computerNumber.add(randomNumber)
    }
}

fun resultCalculation(userNumber:List0f,computerNumber:List0f,strike:Int,ball:Int){
    for ( i in 0..2 ){
        if (userNumber[i]==computerNumber[i]){
            strike++
        }
        else if(userNumber[i]!=computerNumber[i]&&userNumber.contains(computerNumber)){
            ball++
        }
    }
    val result : ListOf<Int>(strike,ball)
    return result
}