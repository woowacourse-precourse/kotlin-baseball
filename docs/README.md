## Feature List
1. 문제 요구사항 파악
    + 입력으로 서로 다른 3자리의 수와 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수가 주어진다.
    + 숫자 야구 게임 (상대방의 3자리 숫자를 맞추는 게임)
    + 요구하는 입출력 형식을 확인할 것
    
    ```
    추가 요구 사항
    - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
    - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
    - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/kotlin/study`를 참고하여 학습한 후 테스트를 구현한다.

    라이브러리
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    ```

2. 예외 처리
    + 잘못된 값을 입력 받을 경우 'IllegalArgumentException'을 발생시키라고 명시되어 있다.
    + 잘못된 값이라 함은 입력받은 3자리 수가 음수인 경우 / 3자리가 아닌 경우 / 정수가 아닌 경우가 있다.

3. 함수 - 8개
    | 함수명 | 매개변수 | 리턴타입 | 용도 |
    | --- | --- | --- | --- |
    | createOpponentData |  | String | 상대방 숫자 생성 후 return |
    | isNegativeNumber | String inputData | Boolean | 입력값 음수인지 check |
    | isNotThreeDigits | String inputData | Boolean | 입력값 3자리수인지 check |
    | isNotInteger | String inputData | Boolean | 입력값 정수인지 check |
    | isGameOver | List<Int> | Boolean | strike 개수 3개인지 check |
    | compareData | String opponentData, String inputData | List<Int> | 상대방 숫자와 입력값 비교 후 결과 return |
    | gameResultString | List<Int> | String | 게임 결과 String return |
    | continueGame | String inputContinue | Boolean | 게임 종료 후 입력 된 숫자 확인하여 게임 continue(true) / exit(false) return |

    + compareData return List<Int> -> ball / strike 2개를 카운트한 List

4. 수정 사항
    + main 함수 파일에 너무 많은 함수가 있어 읽기 불편하다. 비슷한 기능끼리 묶어 class화 하자.
    
    | 클래스 | 함수 | 용도 |
    | --- | --- | --- |
    | UserInputException(Input: String) | isNegativeNumber, isNotThreeDigits, isNotInteger | 입력 받은 유저의 값을 예외 처리함 |
    | ContinueInputException(Input: String) | isNegativeNumber, isNotOneDigits, isNotOneOrTwo, isNotInteger | 입력 받은 게임 진행 / 종료 값을 예외 처리함 |
    | BaseballGame | createOpponentData, compareData, isGameOver, gameResultString, continueGame, processGame | 게임 진행 |
    | InOutput | inputUserData, inputContinueData, printStartMessage, printInputMessage, printGameResult, printEndMessage | 게임 진행 / 결과 출력 |
    
---
## 문제

## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
```

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

---

## 🎯 프로그래밍 요구 사항

- Kotlin 1.6.20에서 실행 가능해야 한다. **Kotlin 1.6.20에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/kotlin/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```kotlin
val computer = mutableListOf()
while (computer.size() < 3) {
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber)
    }
}
```
