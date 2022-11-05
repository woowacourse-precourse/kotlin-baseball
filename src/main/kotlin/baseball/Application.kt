package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var strk = 0
    var ball = 0
    var gamecoin = 0
    var count = 0
    var comnumList = mutableListOf<Int>()
    var comnum : String?
    while(true){
        while (comnumList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comnumList.contains(randomNumber)) {
                comnumList.add(randomNumber)
            }

        }
        comnum = comnumList.toString()
        count++
        if(count==1)
            comnum = "135"
        else if (count==2)
            comnum = "589"
        println("숫자 야구 게임을 시작합니다.")
        while (true) {
            print("숫자를 입력해주세요 : ")
            var mynum: String? = readLine()
            if (mynum!!.length != 3) {
                throw IllegalArgumentException("오류발생 종료")
                break
            }
            if (mynum[0] == mynum[1] || mynum[1] == mynum[2] || mynum[2] == mynum[0]) {
                throw IllegalArgumentException("오류발생 종료")
                break
            }
            if (mynum[0].toString() == "0"|| mynum[1].toString() == "0" || mynum[2].toString() == "0"){
                throw IllegalArgumentException("오류발생 종료")
                break
            }


            strk = 0
            ball = 0

            strk += strkguess(comnum!![0], mynum!![0])
            strk += strkguess(comnum!![1], mynum!![1])
            strk += strkguess(comnum!![2], mynum!![2])

            ball += ballguess(comnum!![0], mynum!![1])
            ball += ballguess(comnum!![0], mynum!![2])
            ball += ballguess(comnum!![1], mynum!![0])
            ball += ballguess(comnum!![1], mynum!![2])
            ball += ballguess(comnum!![2], mynum!![0])
            ball += ballguess(comnum!![2], mynum!![1])
            if (strk != 0 && ball != 0)
                println("${ball}볼 ${strk}스트라이크")
            else if (strk == 0 && ball == 0)
                println("낫싱")
            else if (ball == 0)
                println("${strk}스트라이크")
            else if (strk == 0)
                println("${ball}볼")


            if (strk == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                gamecoin = readLine()!!.toInt()
                break
            }
        }
        if (gamecoin == 2){
            break
        }
        else if (gamecoin != 1){
            throw IllegalArgumentException("오류발생 종료")
            break
        }
    }
}
fun strkguess(a: Char, b: Char): Int{
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