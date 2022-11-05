package baseball.logic

class User {
    lateinit var number: IntArray

    fun numberFormatting(intNum: Int){
        this.number = IntArray(3)
        number[0] = intNum / 100
        number[1] = (intNum - number[0]) / 10
        number[2] = intNum % 10
    }

    fun compareWithAnswer(answerArr: IntArray): IntArray{
        var resultArr = IntArray(2)
        resultArr[0] = countStrike(answerArr)
        resultArr[1] = countBall(answerArr)

        return resultArr
    }

}