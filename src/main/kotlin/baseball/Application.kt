package baseball

import camp.nextstep.edu.missionutils.Randoms

/* 기능 목록
* 입력 예외 처리
*   resultNum 입력
* 게임 구현
* 종료 및 재시작 구현
* */

const val RESULT_NUM_RANGE = 3

fun getResultNum(): Int{
    var start = 0
    var end = 0
    repeat (RESULT_NUM_RANGE){
        start = start*10+1
        end = end*10+9
    }
    return Randoms.pickNumberInRange(start,end)
}

fun main() {

}
