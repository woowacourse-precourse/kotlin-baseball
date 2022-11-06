package baseball

class ExceptionCheck {

    var inputList = ArrayList<String>()


    fun checkDigit(input : String) {

        if(input.length != 3){
            throw IllegalArgumentException("자릿수 오류 발생")
        }else{
            println("3자리 수 입력값임")
        }

    }

    fun checkHaveZero(input: String) {

        if(input.contains("0")){
            throw IllegalArgumentException("잘못된 숫자 입력 오류 발생")

        }else{
            println("입력값에 0 없음")
        }

    }

    fun checkOverlap(input: String) {

        for (i in 0 until input.length){
            inputList.add(input[i].toString())
        }

        if(inputList.size != inputList.distinct().count()){
            throw IllegalArgumentException("중복 숫자 입력 오류 발생")
        }else{
            println("입력값에 중복 문자 없음")
        }


    }
}