package baseball

fun main() {
    val woowaInput = WoowaInput()
    val randomNumberGenerator = RandomNumberGenerator()
    val baseball = Baseball(woowaInput, randomNumberGenerator)
    baseball.start()
}
