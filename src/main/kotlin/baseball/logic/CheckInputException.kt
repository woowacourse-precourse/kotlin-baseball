package baseball.logic

class CheckInputException {
    fun inputExceptionChecker(input: String){
        if(input.length != 3)
            throw IllegalArgumentException()
        if(input.contains("0"))
            throw IllegalArgumentException()
    }
}