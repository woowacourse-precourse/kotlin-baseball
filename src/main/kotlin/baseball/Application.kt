package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange


// 3자리 랜덤 수 추출 함수
fun randomNumber(): Array<Int> {
    var array: Array<Int> = arrayOf(0, 0, 0)
    for(i in 0..2)
        array[i] = pickNumberInRange(1, 9)
    return array
}

// --------- 한 라운드 진행 함수
fun roundStart() {

}

// 비교 결과 리턴 함수
fun gameResult() {

}

// 정답 확인 함수
fun checkCorrect() {

}
// 스트라이크 확인 함수
fun checkStrike() {

}
// 볼 확인 함수
fun checkBall() {

}
// ---------

// 서로 다른 3자리 수 생성
// 게임 시작 알림문 -> 입력 -> 입력된 숫자와 비교해 정답 비교
// 정답x -> 스트라이크 및 볼 판정 -> 입력 반복
// 정답o -> 게임 종료 -> 진행 선택

fun main() {

    // 랜덤 수 발생

    // 게임 시작 알림문 출력
    // 숫자 입력 받기

    // 입력된 숫자를 통해 라운드 진행

    // 라운드 결과 확인
    // 결과에 따라 라운드 재진행 및 종료 후 진행선택

}
