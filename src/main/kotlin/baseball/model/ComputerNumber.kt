package baseball.model

import camp.nextstep.edu.missionutils.Randoms


class ComputerNumber {




    fun setComputerNumber() : String{

        var ComputerSet = HashSet<Int>()

        ComputerSet.clear()

        while (ComputerSet.size < 3) {

            ComputerSet.add(getComputerNumber());
        }

        val computerNumber = ComputerSet.joinToString("")
        return computerNumber
    }

    fun getComputerNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }
}