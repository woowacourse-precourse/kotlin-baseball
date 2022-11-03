## 📮 구현해야할 기능 목록

1. 컴퓨터가 세자리 수의 랜덤 값 생성
    - 1~9를 사용한 임의의 3자리 수
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.


2. 사용자의 입력받기
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    - 만약 3자리의 숫자가 아닌 잘못된 값(3자리 미만, 숫자가 아닌 값, 각각 다른 3자리 숫자 등)를 체크하고 IllegalArgumentException을 발생시킨 후 종료한다.


3. 출력하기
    - 입력한 숫자에 대한 결과를 출력한다.
    - 3개를 모두 맞히면 게임이 종료, 아니면 사용자 입력으로 돌아가기


4. 게임이 종료됬을 때 재시작하기, 종료하기 분기를 구현한다.
    - 종료 조건 : 3스트라이크
    - 재시작 1을, 게임 종료는 2를 선택한다.

---

## 참고 자료

### [커밋 컨벤션 가이드](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

### [코틀린 코딩 스타일 가이드](https://kotlinlang.org/docs/coding-conventions.html)

### [1주차 공통 피드백](공통 피드백)
