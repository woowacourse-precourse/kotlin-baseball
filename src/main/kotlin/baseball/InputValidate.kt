package baseball

class InputValidate {
    fun baseballNumbersForm(input:String) {
        require(BASEBALL_NUMBERS_FORM.toRegex().matches(input)) { println("1부터 9까지의 숫자를 3개 입력해주세요")}
    }

    fun duplicateBaseballNumbers(input:String) {
        val input = input.toCharArray()
        require(input.size == input.distinct().size ) { println("숫자의 중복이 없도록 입력해주세요.")}
    }
    companion object {
        const val BASEBALL_NUMBERS_FORM = "^[1-9]{3}\$"
    }

}