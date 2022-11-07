package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    playBaseBall()
    startOrEnd()
}

fun startOrEnd(): Boolean {
    val oneOrTwo = Console.readLine().toInt()
    inputErrorCheckOneNum(oneOrTwo)
    if(oneOrTwo == 1)
        return true
    return false
}

fun inputErrorCheckOneNum(oneOrTwo:Int){
    if(oneOrTwo !in 1..2){
        throw IllegalArgumentException()
    }
}

fun playBaseBall(){
    val computer = randomThreeNumber()
    var result = hashMapOf<String,Int>()
    result["스트라이크"] = 0
    result["볼"] = 0
    while(result["스트라이크"]!=3) {
        result = playOneTime(computer,result)
    }
}

fun playOneTime(computer:List<Int>,result:HashMap<String,Int>):HashMap<String,Int>{
    val user = playerThreeNumber()
    result.replace("스트라이크", findStrike(computer, user))
    result.replace("볼", findBall(computer, user) - result["스트라이크"]!!)
    printResult(result)
    return result
}

fun randomThreeNumber():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while(computer.size<3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
    return computer
}

fun playerThreeNumber():MutableList<Int>{
    val playerInput = Console.readLine()
    val playerInputMutableList = playerInput.map {it.toString().toInt()}.toMutableList()
    inputErrorCheck(playerInputMutableList)
//    print(playerInputMutableList)
    return playerInputMutableList
}

fun inputErrorCheck(userInputMutableList:List<Int>){
    if(userInputMutableList.size != 3 || userInputMutableList.toSet().size!=3){
        throw IllegalArgumentException()
    }

    for(index in userInputMutableList.indices)
        if(userInputMutableList[index] !in 1 .. 9){
            throw IllegalArgumentException()
        }
}

fun findStrike(computer:List<Int>,user:List<Int>):Int{
    var strikeCount = 0
    for(index in 0..2){
        if(computer[index]==user[index])
            strikeCount++
    }
    return strikeCount
}

fun findBall(computer: List<Int>, user:List<Int>):Int{
    var ballCount = 0
    for (index in 0..2){
        if(user[index] in computer)
            ballCount++
    }
    return ballCount
}

fun printResult(result:HashMap<String,Int>){
    if(result["볼"] == 0 && result["스트라이크"] == 0)
        print("낫싱")
    if(result["볼"] != 0)
        print("${result["볼"]}볼 ")
    if(result["스트라이크"]!= 0)
        print("${result["스트라이크"]}스트라이크")
    println("")
}