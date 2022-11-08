package baseball

class ExceptionCheck {

    var inputList = ArrayList<String>()


    fun checkDigit(input : String) {

        if(input.length != 3){
            throw IllegalArgumentException("자릿수 오류 발생")
        }

    }

    fun checkHaveZero(input: String) {

        if(input.contains("0")){
            throw IllegalArgumentException("잘못된 숫자 입력 오류 발생")

        }

    }

    fun checkOverlap(input: String) {
        inputList.clear()

        for (i in 0 until input.length){
            inputList.add(input[i].toString())
        }

        if(inputList.size != inputList.distinct().count()){
            throw IllegalArgumentException("중복 숫자 입력 오류 발생")
        }

    }

    fun checkRestart(input: String) {

        if(input != "1" && input != "2"){
            throw IllegalArgumentException("재시작은 1 , 종료는 2를 입력해주세요")
        }

    }
}