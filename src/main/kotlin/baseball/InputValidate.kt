package baseball

class InputValidate {
    fun baseballNumbersForm(input:String) {
        require(BASEBALL_NUMBERS_FORM.toRegex().matches(input)) { println("1부터 9까지의 숫자를 3개 입력해주세요")}
    }

    fun duplicateBaseballNumbers(input:String) {
        val input = input.toCharArray()
        require(input.size == input.distinct().size ) { println("숫자의 중복이 없도록 입력해주세요.")}
    }

    fun restartNumber(input: String){
        require(RESTART_NUMBER_FORM.toRegex().matches(input)) { println("1 또는 2의 숫자를 하나만 입력해주세요")}
    }

    companion object {
        const val BASEBALL_NUMBERS_FORM = "^[1-9]{3}\$"
        const val RESTART_NUMBER_FORM = "^[1-2]{1}\$"
    }

}