package model

import camp.nextstep.edu.missionutils.Console
import util.Messages

class User {
    private val _numberList = mutableListOf<Int>()
    val numberList: List<Int>
        get() = _numberList

    fun input(): String {
        print(Messages.INPUT_USER)
        return Console.readLine()
    }

    // 유저의 입력을 리스트 변환
    fun inputConvertToList(userInput: String) {
        _numberList.apply {
            userInput.forEach { number ->
                add(number - '0')
            }
        }
    }
}