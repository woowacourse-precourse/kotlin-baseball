package baseball

class Judgement(val clientNumber: List<Int>, val computerNumber: List<Int>) {
    val strikeOrBall: MutableList<Int> = mutableListOf(0, 0)

    fun judgeTheBall(): MutableList<Int> {
        for (number in clientNumber) {
            if (computerNumber.contains(number)) {
                getScore(number, clientNumber.indexOf(number), computerNumber)
            }
        }
        return strikeOrBall
    }

    fun getScore(clientNumber: Int, clientNumberIndex: Int, computerNumber: List<Int>) {
        if (clientNumberIndex == computerNumber.indexOf(clientNumber)) {
            strikeOrBall[0]++
        }
        if (clientNumberIndex != computerNumber.indexOf(clientNumber)) {
            strikeOrBall[1]++
        }
    }


}
