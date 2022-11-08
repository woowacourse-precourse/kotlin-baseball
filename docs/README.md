## 📮 구현해야할 기능 목록

- 게임의 기능의 제공은 `BaseballModel`클래스에서 진행
- 사용자의 인풋체크는 `InputChecker` 클래스에서 진행
- `BallResult` 데이터클래스에서는 스트라이크 및 볼 카운트를 관리하며 이에 관련된 기능을 제공한다.
- `Application.kt`에서는 게임의 진행을 관리한다.

1. 컴퓨터가 세자리 수의 랜덤 값 생성
    - `makeRandomNum()`이 1~9사이의 중복없는 임의의 3자리 숫자를 반환한다.
        - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.


2. 사용자의 입력받기
    - `InputChecker` 클래스에서 3자리의 숫자가 아닌 잘못된 값(3자리 미만, 숫자가 아닌 값, 각각 다른 3자리 숫자 등)를 체크하고 IllegalArgumentException을 발생시킨 후
      종료한다.
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.


3. 출력하기
    - 입력한 숫자에 대한 결과를 출력한다.
      결과값은 BaseBallModel의 `ballResult`내에 객체에 저장
      출력되는 결과값은 `ballResult`객체 내의 `makeResultString()`을 이용한다.
        - 결과에 대한 규칙은 다음과같다.
          같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다
        - 예) 상대방(컴퓨터)의 수가 425일 때
            - 123을 제시한 경우 : 1스트라이크
            - 456을 제시한 경우 : 1볼 1스트라이크
            - 789를 제시한 경우 : 낫싱
        - `calculateBalls()`메소드에서 규칙에 따른 연산이 이루어진다.
    - 컴퓨터가 생각한 3개를 모두 맞히면 게임이 종료, 아니면 사용자 입력으로 돌아가기


4. 게임이 종료됬을 때 재시작하기, 종료하기 분기를 구현한다.
    - 종료 조건 : 3스트라이크
    - 재시작 1을, 게임 종료는 2를 선택한다.
        - `isEndedCheck()`메소드에서 게임의 재시작, 종료를 결정한다.

---

## 참고 자료

### [커밋 컨벤션 가이드](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

[나만의 언어로 번역한 블로그](https://velog.io/@cksgodl/Git-Commit-컨벤션-및-코틀린-스타일-가이드)

### [코틀린 코딩 스타일 가이드](https://kotlinlang.org/docs/coding-conventions.html)

[나만의 언어로 번역한 코딩 스타일 가이드](https://velog.io/@cksgodl/AndroidKotlin-안드로이드-코틀린-스타일-가이드)

### [1주차 공통 피드백](https://docs.google.com/document/d/1KbDCUawqfsCXwMZ6a31MY-oEu-E8eMKu6awIjDv42Us/edit)



