## 🚀 기능 목록

### ⌨️ SEQ1
- **사용자입력** : `@datatype : String`
  - [x] 입력 안내문 : `숫자를 입력해주세요 : `
  - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
    - 허용 : **서로 다른 3자리수**
    - 예외처리
      - [x] `입력 값 @datatype` `IllegalArgumentException`
      - [x] 입력 값 범위 : `1~9`
      - [x] 입력 값 중복 : `서로 다른 수`
      - [x] 입력 자리 수 : `3자리`

- **컴퓨터 3자리 수** : `@datatype : String`
  - [x] 3자리수 생성
  - [x] 난수생성 `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`
  - [x] 서로 다른 수

- **게임시작 문구 출력**
  - [x] `숫자 야구 게임을 시작합니다.`


### 🧮 SEQ2
  - **비교: 사용자 입력 vs 컴퓨터 3자리수**
    - [ ] 같은 수가 같은 자리에 있으면 `스트라이크`
    - [ ] 다른 자리에 있으면 `볼`
    - [ ] 같은 수가 전혀 없으면 `낫싱`
 - **출력**
    - [ ] 출력 순서 : `볼 스트라이크`


### 💻 SEQ3
  - **종료조건** `3개의 숫자를 모두 맞히는 경우`
    - [x] **출력** `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
    - [x] **출력** `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
      - [x] **if 1 입력**  : goto  ⌨️SEQ1.
      - [x] **if 2 입력**  : program termination
      - [x] **else** : `TODO` Exception occurred
  - **비종료조건**
    - [x] goto  ⌨️SEQ1.사용자입력


---
## 📌 비기능 요구사항 목록
- **Commit Convention**
  - Git의 커밋([커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)) 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위로 추가.
  - Format of the commit message
    ```
    <type>(<scope>): <subject>
    <BLANK LINE>
    <body>
    <BLANK LINE>
    <footer>
    ```

- **Coding Convention**
  - [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수
  - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
  - Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- **Test**
  - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
- **Allowed Libraries**
  - 아래의 허용된 라이브러리 외 외부 라이브러리를 사용하지 않는다.
  - `camp.nextstep.edu.missionutils.Console`
  - `camp.nextstep.edu.missionutils.Randoms`