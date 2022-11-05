package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {

    /**
     * 컴퓨터의 랜덤한 숫자를 정해주고 리스트에 넣어주는 함수
     */
    fun createComputerNumberList(computerNumber: MutableList<Int>){
        while (computerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
    }
}