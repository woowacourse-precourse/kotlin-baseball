package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    generateComputer()
    var inputNum = getInputFormUser()
    verificationNumver(inputNum)
//6. 2~5과정을 반복 만약 스트라이크 3개가 나오면 종료
}

fun generateComputer(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

return computer
}

fun getInputFormUser():Int{
    print("숫자를 입력해주세요 : ")
    var inputNumber = readLine()!!.toInt()
    return inputNumber
}
//3. 입력받은 데이터 값 검증
fun verificationNumver(inputNum : Int):Unit{
    if(inputNum !in 100..999){
        throw IllegalArgumentException("User entered an incorrect value")
    }
}



