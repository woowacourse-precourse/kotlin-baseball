package baseball.model

import camp.nextstep.edu.missionutils.Randoms


class ComputerNumber {

    var ComputerList = ArrayList<Int>()


    fun setComputerNumber() {
        var ComputerSet = HashSet<Int>()

        while (ComputerSet.size < 3) {
            ComputerSet.add(getComputerNumber());
        }

        ComputerList = ArrayList(ComputerSet)

    }

    fun getComputerNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }
}