package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.List
import kotlin.collections.List as List1

fun main() {
    //TODO("프로그램 구현")

    println("숫자 야구 게임을 시작합니다.")
    var select = 1
    while (true)
    {
        when(select)
        {
            1 -> {
                var answernumber =answernumberselect()
//                println("")
//                var usernumber = userselectnumber()
//                println("")
//                var stcount = strikecalculate(usernumber,answernumber)
//                println("")
//                var blcount = ballcalculate(usernumber,answernumber)
//                println("")
//                println("${blcount}볼 ${stcount}스트라이크")
//                println("")
                select = tonghap(answernumber)
            }
            2 -> {
                println("게임을 종료합니다.")
                break
            }
        }
    }
}

fun tonghap(anum: MutableList<Int>): Int
{
    var result = 0

    while(true) {
        println("숫자를 입력해주세요 : ")
        var unum = userselectnumber()
        var scount = strikecalculate(unum,anum)
        var bcount = ballcalculate(unum,anum)


            if (scount == 3) {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                result = readLine()!!.toInt()
                return result


            }
            else if (scount == 0 && bcount == 0)
            {
                println("낫싱")
            }

            else {
                println("${bcount}볼 ${scount}스트라이크")
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

fun userselectnumber(): MutableList<Int> {
    val usernumber = mutableListOf<Int>()
    usernumber.add(readLine()!!.toInt())
//    usernumber.add(readLine()!!.toInt())
//    usernumber.add(readLine()!!.toInt())
    var checknumber = mutableListOf<Int>()
    var userNumStr = usernumber.joinToString("")
    userNumStr = userNumStr.chunked(1).toString()
    var userNumStrInt = mutableListOf<Int>()

    var firstnum = userNumStr[1].code
    firstnum = Character.getNumericValue(firstnum)
    userNumStrInt.add(firstnum)
    var secondnum = userNumStr[4].code
    secondnum = Character.getNumericValue(secondnum)
    userNumStrInt.add(secondnum)
    var thirdnum = userNumStr[7].code
    thirdnum = Character.getNumericValue(thirdnum)
    userNumStrInt.add(thirdnum)

    return userNumStrInt
}

fun strikecalculate(a: MutableList<Int>,b:MutableList<Int>):Int
{
    var strikecount = 0
    if (a[0] == b[0])
    {
        strikecount = strikecount+1
    }
    if (a[1] == b[1])
    {
        strikecount = strikecount+1
    }
    if (a[2] == b[2])
    {
        strikecount = strikecount+1
    }
    return strikecount
}

fun ballcalculate(a: MutableList<Int>,b:MutableList<Int>):Int
{
    var ballcount = 0
    if (a[0] == b[1])
    {
        ballcount = ballcount+1
    }
    if (a[0] == b[2])
    {
        ballcount = ballcount+1
    }
    if (a[1] == b[0])
    {
        ballcount = ballcount+1
    }
    if (a[1] == b[2])
    {
        ballcount = ballcount+1
    }
    if (a[2] == b[0])
    {
        ballcount = ballcount+1
    }
    if (a[2] == b[1])
    {
        ballcount = ballcount+1
    }
    return ballcount
}
