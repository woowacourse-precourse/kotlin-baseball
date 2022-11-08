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

    }while()
}
    
}

fun random(computerNumber:List0f){
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!computerNumber.contains(randomNumber)) {
        return computerNumber.add(randomNumber)
    }
}
