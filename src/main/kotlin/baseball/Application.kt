package baseball

import camp.nextstep.edu.missionutils.Randoms




fun setRandomAnswer(): ArrayList<Int>{
    var answer = arrayListOf<Int>()

    while (answer.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNum))
            answer += randomNum
    }
    return answer
}