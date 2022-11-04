package baseball.domain

class Player(number: String) {
    private lateinit var _number: String
    val number: String get() = _number

    init {
        require(number.all { Character.isDigit(it) }) {
            "문자가 섞인 입력 값입니다."
        }
        require(number.length == 3) { "세 자리 숫자가 아닙니다." }
        require(number.toSet().size == 3) { "중복되는 숫자가 존재합니다." }
        require(number.all { it != '0' }) { "입력 포맷이 일치하지 않습니다. 1부터 9까지 수만 입력해주세요." }

        this._number = number
    }
}
