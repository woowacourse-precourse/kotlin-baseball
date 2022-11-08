package baseball

import kotlin.io.readLine
import kotlin.text.toInt
import kotlin.collections.mutableListOf

fun main() {
    
    var strike:Int = 0
    var ball:Int = 0

while(true){
    val computerNumber = mutableListOf()
    while (computerNumber.size() < 3) {
        random(computerNumber)
    }

    do{
        strike = 0
        ball = 0
    var inputNumber:String=readLine()
    var userNumber = inputNumber.chunked(1)
    val result:list0f<Int>(resultCalculation(userNumber:List0f,computerNumber:List0f,strike:Int,ball:Int))

    }while()
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
