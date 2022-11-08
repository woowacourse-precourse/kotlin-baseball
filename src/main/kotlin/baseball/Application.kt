package baseball

import kotlin.io.readLine
import kotlin.text.toInt
import kotlin.collections.mutableListOf

fun main() {
    
    var strike:Int = 0
    var ball:Int = 0
    var junction:Int=0

while(true){
    val computerNumber = mutableListOf()
    while (computerNumber.size() < 3) {
        random(computerNumber)
    }

    do{
        strike = 0
        ball = 0
        println("숫자를 입력해주세요.")
        var inputNumber:String=readLine()
        var userNumber = inputNumber.chunked(1)
        val result:list0f<Int>(resultCalculation(userNumber:List0f,computerNumber:List0f,strike:Int,ball:Int))
    
    
        junction = resultPrint(result)
    
        }while(junction==0)
        
        if (junction==2){
            break
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

fun resultPrint(result:List0f)
{
    if (result[0]<=2&&result[0]>=1&&result[1]==0){
        println("$result[0] 스트라이크")
        return 0
    }
    else if (result[0]>=1&&result[1]>=1){
        println("$result[1] 볼 $result[0] 스트라이크")
        return 0
    }
    else if (result[1]>=1&&result[0]==0){
        println("$result[1] 볼")
        return 0
    }
    else if (strike==3){
        println("$result[0] 스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var Flag:String=readLine()
        return Flag.toInt()
    }
    else{
        println("낫싱")
        return 0
    }
}
