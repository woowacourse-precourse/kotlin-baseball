# Kotlin Baseball Game - 기능 요구사항 목록

<br/>

## 기능 요구 사항
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

<br/>

## 게임 실행 방법
다음과 같이 `BaseballGame.Builder` 클래스를 이용하여 `BaseballGame` 인스턴스를 생성하고, `BaseballGame.play()` 함수 호출시 게임이 시작됩니다.

```kotlin
BaseballGame.Builder()
    .onInit(/* 컴퓨터 랜덤 숫자 입력 */)
    .onProgress(/* 사용자 숫자 입력 */)
    .onFinish(/* 게임 재시작(1) or 종료(2) 코드 입력 */)
    .build()
    .play()
```

<br/>

## 패키지 구성 요소
- BaseballGame::class
- Message::class
- ExceptionHandler::class
- Provider::class

<br/>

## [BaseballGame::class](/src/main/kotlin/baseball/game/BaseballGame.kt)
숫자 야구 게임 실행 클래스

1. `play()`
    1. 게임 시작 메시지 출력한다
    2. 임의의 3자리 숫자를 컴퓨터 숫자로 입력한다
    3. `startGame(...)` 함수 호출을 통해 게임 시작된다
    4. 유저가 컴퓨터의 3자리 숫자를 모두 맞히게 되면 유저는 게임을 재시작 및 종료를 선택할 수 있다
    5. 재시작(1)을 선택하면 (ⅰ ~ ⅳ) 과정을 다시 반복, 종료(2) 선택시 프로그램이 종료된다

2. `startGame(computerNumber)`
    1. 컴퓨터 숫자를 맞힐 유저의 숫자를 입력받는다
    2. `compare(...)` 함수를 통해 컴퓨터 숫자와 유저 숫자를 비교한다
    3. `compare(...)` 의 결과(ball, strike)에 대한 메시지(힌트) 출력한다
    4. strike < 3 이면, (ⅰ ~ ⅲ) 과정 다시 반복한다
    5. strike == 3 이면, 게임이 종료된다

3. `compare(computer, user)`
    1. 같은 수가 다른 자리에 있는 숫자의 갯수: "N볼"
    2. 같은 수가 같은 자리에 있는 숫자의 갯수: "M스트라이크"
    3. N == 0 and M == 0: "낫싱"


<br/>

## [Message::class](/src/main/kotlin/baseball/game/Message.kt)
게임 진행 과정내에서 메세지를 출력하는 로직 담당

- `showStartGame()`
```
숫자 야구 게임을 시작합니다.
```

- `requestUserNumber()`
```
숫자를 입력해주세요 : 
```
사용자가 잘못된 숫자를 입력한 경우 `ExceptionHandler.checkNumberFormat(...)` 함수를 통해 예외 처리된다

- `showHint(ball, strike)`
    - ball == 0 and strike == 0 이면
  ```
  낫싱
  ```
    - 그렇지 않으면, 아래 방식 중 하나 출력
  ```
  n볼
  m스트라이크
  n볼 m스트라이크
  ```

- `requestRestartOrFinish()`
```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```


- `showGameFinished()`
```
게임 종료
```

<br/>

## [ExceptionHandler::class](/src/main/kotlin/baseball/game/ExceptionHandler.kt)
사용자 입력 예외 처리 핸들러

- `checkNumberFormat(number)`
    1. 글자 수가 3자리인지 확인
    2. 중복된 숫자가 없는지 확인
    3. 각 자리 숫자가 (1 ~ 9)인지 확인

위 조건 중 하나라도 맞지 않으면 `IllegalArgumentException` 이 발생한다

- `throwFinishCode(code)`

게임 종료/재시작 코드를 잘못 입력하였을 때 위 함수를 호출하여 `IllegalArgumentException` 를 발생시킨다

<br/>

## [Provider::class](/src/main/kotlin/baseball/game/Provider.kt)

- `pickComputerRandomNumber()`
    - `camp.nextstep.edu.missionutils.Randoms`를 활용하여 컴퓨터 랜덤 숫자 뽑기
- `readUserNumber()`
    - `camp.nextstep.edu.missionutils.Console`을 활용하여 유저 숫자 입력 받기
