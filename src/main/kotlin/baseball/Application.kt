package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    baseballGameStart()
}

fun baseballGameStart(){
    val computerNum = setComputerNum()
    compareUserNumAndComputerNum(computerNum)
}

fun setComputerNum() : List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun compareUserNumAndComputerNum(computer : List<Int>){
    var userNum = getNum()
    var ballCount = 0
    var strikeCount = 0

    userNum.forEach{
        if(computer.contains(it))
            ballCount++
    }

    for(i in 0..2){
        if(computer[i] == userNum[i])
            strikeCount++
    }

    ballCount -= strikeCount

//    println("computer : $computer")
//    println("user : $userNum")
//    println("s : $strikeCount b : $ballCount")

//    compareUserNumAndComputerNum(computer)

}

fun getNum() : List<Int>{
    print("숫자를 입력해주세요 : ")
    var tempNum = readLine()!!
    var userNum : Int

    if(isInValidNum(tempNum))
        throw IllegalArgumentException("Error")
    else
        userNum = tempNum.toInt()

    val userNumList = mutableListOf<Int>()

    while(userNum != 0){
        userNumList.add(userNum % 10)
        userNum /= 10
    }

    return userNumList.reversed()
}

fun isInValidNum(userNum : String) : Boolean{
    val regex = Regex("^[0-9]{3}\$")
    if(regex.matches(userNum))
        return false

    return true
}