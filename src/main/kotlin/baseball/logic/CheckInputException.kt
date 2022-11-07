package baseball.logic

class CheckInputException {
    fun inputExceptionChecker(input: String){
        if(input.length != 3)
            throw IllegalArgumentException()
        if(input.contains("0"))
            throw IllegalArgumentException()
        if(inputDuplicatedChecker(input.toInt()))
            throw IllegalArgumentException()
    }

    private fun inputDuplicatedChecker(input: Int): Boolean{
        //100의 자리와 10의 자리 비교
        if(input/100 == (input/10) - 10)
            return true
        //100의 자리와 1의 자리 비교
        if(input/100 == input%10)
            return true
        //10의 자리와 1의 자리 비교
        if((input/10) - 10 == input%10)
            return true
        return false
    }
}