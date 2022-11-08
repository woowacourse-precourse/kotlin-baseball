package baseball.model

class BaseBall(
    val computerNumbers: List<Int>,
    val playerNumbers: List<Int>
) {
    fun getStrikeCount(): Int = combineNumberList()
        .filter { num -> num.first == num.second }
        .count()

    fun getBallCount(): Int = combineNumberList()
        .filter { num -> num.first != num.second && hasNumberInComputer(num.second) }
        .count()

    private fun hasNumberInComputer(playerNumber: Int): Boolean =
        computerNumbers.contains(playerNumber)

    private fun combineNumberList() =
        computerNumbers.zip(playerNumbers)
}