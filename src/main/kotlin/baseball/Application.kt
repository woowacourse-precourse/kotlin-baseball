package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.List
import kotlin.collections.List as List1

fun main() {
    //TODO("프로그램 구현")

    println("숫자 야구 게임을 시작합니다.")


    while (true)
    {
        var select = readLine()?.toInt()
        when(select)
        {
            1 -> {
                println("임시 1번내용")
                var answernumber =answernumberselect()
                println("")
                var usernumber = userselectnumber()
                println("")
                var stcount = strikecalculate(usernumber,answernumber)
                println("")
                var blcount = ballcalculate(usernumber,answernumber)
                println("")
                println("${blcount}볼 ${stcount}스트라이크")
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

fun userselectnumber(): MutableList<Int> {
    val usernumber = mutableListOf<Int>()
    println("숫자를 입력해주세요 : ")
    usernumber.add(readLine()!!.toInt())
//    usernumber.add(readLine()!!.toInt())
//    usernumber.add(readLine()!!.toInt())

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

    print(userNumStrInt)

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