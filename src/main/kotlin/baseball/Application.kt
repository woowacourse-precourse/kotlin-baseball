package baseball

// 기능 목록
// 1. "숫자 야구 게임을 시작합니다." 출력, 게임 함수 실행
// 2. 임의의 수 설정
// 2. "숫자를 입력해주세요:" 출력 후, 3자리 숫자 입력 받기.
// 3. 숫자가 서로 다른 3자리 수가 아니거나 각 자릿수에 0이 있으면, IllegalArgumentException 발생 후 종료
// 4. 입력 받은 숫자와 임의의 수 3개를 비교하는 함수를 이용해 비교하고 결과 출력
// 5. 4번 기능 반복
// 6. 임의의 수와 입력 받은 수가 일치하면 기능 종료 및 재시작 여부 확인
// 7. 재시작 여부에 따라 다시 함수 실행

fun main() {
    print("숫자 야구 게임을 시작합니다.")
    game()
}

fun game() {
    var computer_num = computer_random_num()

    print("숫자를 입력해주세요 : ")

    var num = readLine()



}

fun computer_random_num(): MutableSet<Int> {
    val num_set = mutableSetOf<Int>()
    while (num_set.size<=2) {
        num_set.add((1..9).random())
    }
    return num_set
}
