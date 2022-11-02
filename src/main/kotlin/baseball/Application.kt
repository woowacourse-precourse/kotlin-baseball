package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")


    while (true)
    {
        var select = readLine()?.toInt()
        when(select)
        {
            1 -> {
                println("임시 1번내용")
                var answernumber =answernumberselect()
                println("")
            }
            2 -> {
                println("게임을 종료합니다.")
                break
            }
        }
    }
}


fun answernumberselect(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3)
    {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer

}