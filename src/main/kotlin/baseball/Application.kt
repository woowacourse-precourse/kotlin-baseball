package baseball

private val numberRegex = "[1-9]{3}".toRegex()
fun main() {
    println("숫자 야구 게임을 시작합니다.")
}

fun isValidNumber(n: String): Boolean = numberRegex.matches(n)