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
        if (select == 1)
        {
            var answernumber =answernumberselect()
            select = tonghap(answernumber)
        }
        else if (select == 2)
        {
            println("게임을 종료합니다.")
            break
        }
        else
        {
            throw IllegalArgumentException()
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

            else if(scount > 0 && bcount > 0 ){
                println("${bcount}볼 ${scount}스트라이크")
            }
            else if (scount > 0 && bcount == 0)
            {
                println("${scount}스트라이크")
            }
            else if (scount == 0 && bcount > 0)
            {
                println("${bcount}볼")
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
    var check = 1
    var userNumStrInt = mutableListOf<Int>()
    var userNumStr = mutableListOf<Int>()

    while(true)
    {
        usernumber.add(readLine()!!.toInt())
        var userNumStr = usernumber.joinToString("")
        userNumStr = userNumStr.chunked(1).toString()

        var firstnum = userNumStr[1].code
        firstnum = Character.getNumericValue(firstnum)
        userNumStrInt.add(firstnum)
        var secondnum = userNumStr[4].code
        secondnum = Character.getNumericValue(secondnum)
        userNumStrInt.add(secondnum)
        var thirdnum = userNumStr[7].code
        thirdnum = Character.getNumericValue(thirdnum)
        userNumStrInt.add(thirdnum)
        println("")

        if (userNumStrInt[0] == userNumStrInt[1] || userNumStrInt[0] == userNumStrInt[2] || userNumStrInt[1] == userNumStrInt[2])
        {
//            println("다시 입력해주세요 :")
//            userNumStr = userNumStr.removeRange(0..userNumStr.length-1)
//            userNumStrInt.removeAll(1..9)
//            usernumber.remove(usernumber[0])
//            continue
            throw IllegalArgumentException()
        }

        if (userNumStr.length == 9)
        {
            break
        }
        else
        {
//            println("다시 입력해주세요 :")
//            userNumStr = userNumStr.removeRange(0..userNumStr.length-1)
//            userNumStrInt.removeAll(1..9)
//            usernumber.removeAll(1..9)
//            usernumber.remove(usernumber[0])
//            continue
            throw IllegalArgumentException()
        }

    }

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
