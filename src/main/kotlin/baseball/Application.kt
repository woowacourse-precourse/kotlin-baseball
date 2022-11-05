package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun comInput(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) computer.add(randomNumber)
    }
    return computer
}

fun userInput() : MutableList<Int> {
    val user = mutableListOf<Int>()

    while(user.size < 3) {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()!!

        if(userNumber.length == 3) {
            for(i in userNumber.indices) {
                if(userNumber[i] - '0' in 1..9) {
                    user.add(userNumber[i] - '0')
                }
            }
        } else {
            throw IllegalArgumentException()
        }

    }
    return user
}

fun compareNumber(userNumberList : List<Int>, comNumberList : List<Int>) : MutableList<Int> {
    val checkNumber : MutableList<Int> = mutableListOf()

    for(i in userNumberList.indices) {
        if(userNumberList[i] == comNumberList[i]) {
            checkNumber.add(1)
        } else if(userNumberList[i] in comNumberList && userNumberList[i] != comNumberList[i]) {
            checkNumber.add(0)
        } else {
            checkNumber.add(-1)
        }
    }
    return checkNumber
}



fun main() {
    val userNumbers = userInput()
    val comNumbers = comInput()



    println("com : $comNumbers")
    println("user : $userNumbers")
    println(compareNumber(userNumbers, comNumbers))
//    while(true) {
//        var gameStartControl = readLine()!!.toInt()
//
//        if(gameStartControl == 1) {
//            continue
//        } else if (gameStartControl == 0){
//            break
//        } else { println("다시 입력해 주세요") }
//    }


}
