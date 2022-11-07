package baseball

class Judgement(val clientNumber: List<Int>, val computerNumber: List<Int>) {

    fun judgeTheBall(): MutableList<Int> {
        val strikeOrBall: MutableList<Int> = mutableListOf(0, 0)
        for (number in clientNumber) {
            if (computerNumber.contains(number)) {
                val judge = getScore(number, clientNumber.indexOf(number), computerNumber)
                judgement(judge, strikeOrBall)
            }
        }
        return strikeOrBall
    }

    fun getScore(clientNumber: Int, clientNumberIndex: Int, computerNumber: List<Int>): String {
        if (clientNumberIndex == computerNumber.indexOf(clientNumber)) {
            return "strike"
        }
        return "ball"
    }

    fun judgement(judge: String, strikeOrBall: MutableList<Int>) {
        if (judge == "strike") strikeOrBall[0]++
        if (judge == "ball") strikeOrBall[1]++
    }

}
