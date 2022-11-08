package baseball

/*
기능 목록
    1. 1에서 9까지의 서로 다른 임의의 수 3개를 무작위로 만들어낸다.
    2. 플레이어의 입력 값을 받는다.
    3. 플레이어의 입력 값에 대한 결과를 출력한다.
        3-1. 상대방(컴퓨터)가 선택한 임의의 수 3개를 모두 맞히지 못할 경우 : 낫싱
        3-2. 임의의 수 3개를 모두 맞힐 경우 : 3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료
        3-3. 숫자만 맞고 숫자의 위치는 맞지 않는 경우 : 볼
        3-4. 숫자와 숫자의 위치 모두 맞는 경우 : 스트라이크
    4. 플레이어는 수 3개를 모두 맞힐 때까지 입력할 수 있도록 한다.
    5. 수 3개를 모두 맞히면, 게임이 종료되도록 한다.
    6. 게임이 종료되면 플레이어가 재시작을 하거나, 완전히 종류할 수 있게 한다.
    7. 사용자가 잘못된 값을 입력하면, IllegalArgumentException을 발생시키고 애플리케이션을 종료시키도록 한다(예외 처리)
    8. 재시작할 경우, 서로 다른 임의의 수 3개를 다시 만들어낸다.
 */
fun main() {
    TODO("프로그램 구현")
}

//1. 1에서 9까지의 서로 다른 임의의 수 3개를 무작위로 만들어내는 함수
fun produceRandomNums() : List<Int> {
    val range = (1..9)
    val randomNums = mutableListOf<Int>()

    for(i in 1..3)
        randomNums += range.random()

    return randomNums
}