package Exception

enum class ExceptionMessage(val message : String){
    RANGE_ERROR("[ERROR] 숫자는 3자리 수 여야합니다."),
    NOT_NUMBER_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    DUPLICATE_ERROR("[ERROR] 숫자는 중복될 수 없습니다."),
    CHOOSE_ERROR("[ERROR] 1 또는 2를 입력해 주세요.")

}


class InputException {

    fun checkException(input : String){
        notNumberException(input)
        rangeException(input)
        duplicateException(input)
    }

    fun chooseException(input : String){
        notNumberException(input)
        val inputNum = input.toInt()
        if (!(inputNum == 1 || inputNum == 2)){
            throw IllegalArgumentException(ExceptionMessage.CHOOSE_ERROR.message)
        }
    }

    fun rangeException(input : String){
        if(input.length != 3){
            throw IllegalArgumentException(ExceptionMessage.RANGE_ERROR.message)
        }
    }

    fun notNumberException(input : String){
        for (i in input.indices){
            if (!input[i].isDigit()){
                throw IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.message)
            }
        }
    }

    fun duplicateException(input : String){
        var numList = mutableListOf<Char>()
        for (i in input.indices){
            numList.add(input[i])
        }
        for (i in 0 until numList.size - 1){
            if (numList[i] == numList[i+1]){
                throw IllegalArgumentException(ExceptionMessage.DUPLICATE_ERROR.message)
            }
        }
    }



}