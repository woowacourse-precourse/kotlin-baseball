package baseball

class ThrowException {

    /**
     * 게임 종료시에 사용자가 입력을 올바르게 하지 않았다면 예외를 던져주는 함수
     */
    fun throwExceptionForRestartNumber(input: String?){
        if (!getIsNumber(input))
            throw IllegalArgumentException("입력한 값이 숫자가 아닙니다.")
        else if (!getIsOneOrTwo(input))
            throw IllegalArgumentException("입력한 수가 올바른 값이 아닙니다")
    }

    /**
     * 사용자가 3자리 숫자를 올바르게 입력하지 않았다면 예외를 던져주는 함수
     */
    fun throwExceptionForUserNumber(inputValue: String?){
        if (!getIsNumber(inputValue))
            throw IllegalArgumentException("입력한 값이 숫자가 아닙니다.")
        else if(!hasThreeDigits(inputValue))
            throw IllegalArgumentException("입력한 수가 3자릿수가 아닙니다.")
        else if(!hasDistinctDigits(inputValue))
            throw IllegalArgumentException("입력한 숫자들 중 중복된 숫자가 있습니다.")
    }

    /**
     * 입력한 값이 숫자인지를 Boolean 으로 반환해주는 함수
     */
    private fun getIsNumber(input: String?): Boolean{
        try {
            input?.toInt()!!
        }
        catch (e: NumberFormatException ){
            return false
        }
        return true
    }

    /**
     * 3자릿수 인지 확인해주는 함수
     */
    private fun hasThreeDigits(inputNumber: String?): Boolean{
        return inputNumber?.toInt()!! in 100..999
    }

    /**
     * 중복된 자릿수가 있는지 확인해주는 함수
     */
    private fun hasDistinctDigits(inputNumber: String?): Boolean{
        var userNumber = inputNumber?.toInt()!! // 전달받은 숫자값
        var eachDigit: Int
        val numberList = mutableListOf<Int>() // 각 자릿수를 저장할 리스트
        while(userNumber >= 10){ // 각 자릿수를 리스트에 저장하는 과정
            eachDigit = userNumber % 10
            numberList.add(eachDigit)
            userNumber /= 10
        }
        numberList.add(userNumber)
        return numberList.distinct().size == 3 // 리스트에서 중복을 제거하고 난 size가 3이면 true
    }

    /**
     * 입력한 숫자가 1과 2 인지 판단하는 함수
     */
    private fun getIsOneOrTwo(input: String?): Boolean{
        return input?.toInt()!! in 1..2
    }
}