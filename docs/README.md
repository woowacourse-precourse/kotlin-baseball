## 기능 요구 사항

1. 컴퓨터가 임의의 서로 다른 세 자리 수를 생성
    -camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용

2. 사용자에게 입력값을 받음
    -제시된 조건을 충족시켰을 경우 List<Int> 형태로 변환해서 return
    -각 자리수가 1~9이며 서로 다른 세자리 정수여야 한다.
    -그렇지 않을 경우 exception 처리

4. 컴퓨터의 값과 사용자의 입력값을 비교한다
    -위치와 수 모두 동일하면 strike에 1을 더하고
    -위치는 다르나 해당 숫자를 포함하면 ball에 1을 더해서
    -Pair(ball, strike) 형태로 return

5. 해당 ball, strike값을 출력한다
    -ball만 있을 경우: "1볼"
    -strike만 있을 경우: "2스트라이크"
    -ball, strike 모두 있을 경우: "2볼 1스트라이크"
    -ball, strike 둘 다 없을 경우: "낫싱"

6. 2~4 과정을 통한 결과값을 String형태(FAIL / SUCCESS / EXIT)로 반환한다
    -strike가 3개가 아닌 경우 -> FAIL
    -strike가 3개, 다시 시작하는 경우 -> SUCCESS
    -strike가 3개, 종료하는 경우 -> EXIT
    -이때 새로 시작할지 여부를 묻는 입력값이 1이나 2개 아닐 경우 exception 처리

7. 5의 결과값에 따라 게임 지속 여부를 결정
    -EXIT -> 멈추기
    -FAIL -> 다시 2번 단계로 돌아가기
    -SUCCESS -> 새로 게임 시작하므로 randomValue 새로 설정해주기
