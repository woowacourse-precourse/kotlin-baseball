## 🚀 BaseballClassManage.kt 기능 목록

### 핵심 기능 클래스 목록

| No  | Class Name               | Explanation                                                              |
|-----|--------------------------|--------------------------------------------------------------------------|
| 1   | `NumberBaseballComputer` | 사용자로부터 요청을 받고 요청에 대한 처리 결과를 저장                                           |
| 2   | `RandomGenerator`        | `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` API를 사용하여 Random 값을 생성 |
| 3   | `Recorder`               | 경기 내용을 기록하고 문자열로 반환하는 `toString` 메소드 제공                                  |
| 4   | `ConsoleManager`         | `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 사용자로부터 데이터를 입력 받고 출력 |

---

### 1. NumberBaseballComputer

`NumberBaseballComputer` 클래스는 사용자 입력을 전달 받고 `RandomGenerator` 객체를 통해 컴퓨터의 3자리 수를 생성한다.
전달 받은 입력과 3자리 난수를 `Recorder` 객체에게 전달하여 경기 결과를 도출하고 그 결과를 `getResponse` 함수로 제공할 수 있다.

| 함수                |파라미터|반환 값| 설명                                                                   |
|-------------------|---|---|----------------------------------------------------------------------|
| `receiveUserMessage` |`String`|`Unit`| `String` 타입인 `message를` 파라미터로 전달 받고 `message`를 분석하여 `message`의 요구 사항대로 실행한다. |
| `getResponse`     |`Unit`|`String`| 컴퓨터가 만든 가장 최근의 `responseMessage`를 반환한다.                                |
| `isPoweredOn`     |`Unit`|`Boolen`| 현재 컴퓨터 전원이 켜져 있는 상태인지 여부를 반환한다.                                      |
| `validate`        |`String`|`Unit`| `validate`가 붙은 함수는 `private` 함수이며 내부적으로 예외를 확인한다.                        |

### 2. RandomGenerator

`RandomGenerator` 클래스는 1부터 9까지 무작위로 선택된 서로 다른 수로 이루어진 3개의 원소를 갖는 리스트를 만들어 반환해주는 함수를 갖는다.

| 함수        |파라미터|반환 값|설명|
|-----------|---|---|---|
| `randomList` |`Unit`|`List<Int>`|`Randoms의` `pickNumberIntRange` 함수를 사용하여 서로 다른 수로 이루어진 3개의 원소를 갖는 리스트는 반환한다. 각 3개의 원소의 범위는 1부터 9까지이다.|

### 3. Recorder

`Recorder` 클래스는 객체가 생성될 때 사용자와 컴퓨터의 3자리 숫자를 전달 받아 해당 게임의 결과를 생성한다.
프로그램 요구사항을 위한 결과는 문자열로만 제공하지만 확장 가능성을 남겨둔다.

| 함수    |파라미터|반환 값| 설명                                                                                       |
|-------|---|---|------------------------------------------------------------------------------------------|
| `toString` |`Unit`|`String`| 생성된 `Recorder` 객체가 갖는 게임 결과를 문자열로 반환한다.                                                    |
|`resultIntList`|`Unit`|`List<Int>`| 객체가 생성될 때 전달받은 매개변수들을 통해 각 자리별 수에 `checkNumberIndexOf` 함수를 실행하고 그 결과를 반영한 정수 타입의 리스트 반환. |

### 4. ConsoleManager

`ConsoleManager` 클래스는 사용자로부터 입력을 받고 그 입력을 `NumberBaseballComputer` 객체에게 전달하거나 전달 받은 결과를 `writeLine` 함수를 통해 화면에 띄워준다.

|함수|파라미터|반환 값|설명|
|---|---|---|---|
|`readLine`|`Unit`|`String`|`Console` 클래스의 `readLine` 함수를 이용하여 사용자로부터 입력을 받는다.|
|`writeLine`|`String`|`Unit`|`writeLine` 함수는 `ConsolManager` 객체가 마지막으로 `readLine` 함수를 수행한 결과를 터미널에 출력한다.|

---

### 예외사항

예외 사항 목록

| No  | Exception                | Category | Explanation          |
|:----|--------------------------|--------|----------------------|
| 1   | `IllegalArgumentException` | 사용자 입력 | 3자리 수 중 중복된 수가 있을 경우 |
| 2   | `IllegalArgumentException` | 사용자 입력 | 숫자가 아닌 입력이 있을 경우 |
| 3   | `IllegalArgumentException` | 사용자 입력 | 3자리 미만 혹은 4자리 이상의 수가 입력될 경우 |
