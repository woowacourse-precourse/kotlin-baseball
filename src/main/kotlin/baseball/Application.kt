package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    generateComputer()
    getInputFormUser()

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

//2. 사용자로부터 입력받기

fun getInputFormUser():Int{
    print("숫자를 입력해주세요 : ")
    var inputNumber = readLine()!!.toInt()
    return inputNumber
}

