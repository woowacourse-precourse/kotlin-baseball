package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var strike = 0
    var ball = 0
    var coin = 1
    var count = 1
    var comnumList = mutableListOf<String>()
    var comnum : String?
    println("숫자 야구 게임을 시작합니다.")
    while(true){
        randomNum(comnumList)
        comnum = comnumList.joinToString("")
        if(count==1)
            comnum = "135"
        else if (count==2)
            comnum = "589"
        print("숫자를 입력해주세요 : ")
        var mynum: String? = readLine()
        if (mynum!!.length != 3)
            throw IllegalArgumentException("오류발생 종료")
        if (mynum.toSet().count() != 3)
            throw IllegalArgumentException("오류발생 종료")
        if (mynum.contains('0'))
            throw IllegalArgumentException("오류발생 종료")

        strike = 0
        ball = 0

        strike += strikeguess(comnum!![0], mynum!![0])
        strike += strikeguess(comnum!![1], mynum!![1])
        strike += strikeguess(comnum!![2], mynum!![2])

        ball += ballguess(comnum!![0], mynum!![1])
        ball += ballguess(comnum!![0], mynum!![2])
        ball += ballguess(comnum!![1], mynum!![0])
        ball += ballguess(comnum!![1], mynum!![2])
        ball += ballguess(comnum!![2], mynum!![0])
        ball += ballguess(comnum!![2], mynum!![1])
        if (strike != 0 && ball != 0)
            println("${ball}볼 ${strike}스트라이크")
        else if (strike == 0 && ball == 0)
            println("낫싱")
        else if (ball == 0)
            println("${strike}스트라이크")
        else if (strike == 0)
            println("${ball}볼")


        if (strike == 3) {
            count++
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            coin = readLine()!!.toInt()
            comnumList.clear()
        }
        if (coin == 2)
            break
        else if (coin != 1)
            throw IllegalArgumentException("오류발생 종료")
    }
}
fun strikeguess(a: Char, b: Char): Int{
    if (a == b){
        return 1
    }
    return 0
}
fun ballguess(a: Char, b: Char): Int{
    if (a == b){
        return 1
    }
    return 0
}
fun randomNum(comnumList : MutableList<String>): MutableList<String> {
    while (comnumList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!comnumList.contains(randomNumber)) {
            comnumList.add(randomNumber)
        }
    }
    return comnumList
}
