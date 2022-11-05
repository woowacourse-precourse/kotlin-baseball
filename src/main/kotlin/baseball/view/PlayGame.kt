package baseball.view

class PlayGame {
    fun getUserNum(): Int{
        print("숫자를 입력해주세요 : ")
        return readLine()!!.toInt()
    }

    fun printResult(resultArr: IntArray){
        if(resultArr[0] == 0 && resultArr[1] == 0)
            println("낫싱")
        else
            println("${resultArr[1]}볼 ${resultArr[0]}스트라이크")
    }
}