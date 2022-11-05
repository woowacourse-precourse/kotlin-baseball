package baseball.view

class PlayGame {
    fun getUserNum(): Int{
        print("숫자를 입력해주세요 : ")
        return readLine()!!.toInt()
    }
}