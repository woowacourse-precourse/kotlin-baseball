package baseball.model

import camp.nextstep.edu.missionutils.Console

class UserNumber {

    var inputList = ArrayList<String>()


    fun setInputList(input: String) {
        inputList = input.split("")
            .map { it } as ArrayList<String>
    }

}