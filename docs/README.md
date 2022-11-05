## 🚀 기능 목록

### 핵심 기능 클래스 목록

| No  | Class Name               | Explanation                                                                     |
|-----|--------------------------|---------------------------------------------------------------------------------|
| 1   | `NumberBaseballComputer` | 사용자로부터 요청을 받고 요청에 대한 처리 결과를 다시 사용자에게 전달                                         |
| 2   | `RandomGenerator`        | `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` API를 사용하여 Random 값을 요청받거나 생성하고 전달 |
| 3   | `Umpire`                 | 경기 내용을 전달 받고 경기 결과를 심판 및 전달                                                     |
| 4   | `ConsoleManager`         | `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 사용자로부터 데이터를 입력 받고 출력    |

---

### 1. NumberBaseballComputer
`NumberBaseballComputer` 클래스는 `ConsoleManager` 객체로부터 사용자 입력을 전달 받고 `RandomGenerator` 객체가 생성한 3자리 수를 전달 받는다.
전달 받은 입력과 3자리 난수를 `Umpire` 객체를 통해 결과를 도출하고 다시 `ConsoleManager` 객체에게 전달한다.

### 2. RandomGenerator
`RandomGenerator` 클래스는 1부터 9까지 무작위로 선택된 서로 다른 수로 이루어진 3개의 원소를 갖는 리스트를 만들어 반환해주는 함수를 갖는다.

### 3. Umpire
`Umpire` 클래스는 사용자와 컴퓨터의 3자리 숫자를 전달 받아 수행한다.
- `checkNumberIndexOf`: 수를 매개변수로 전달 받고 스트라이크나 볼에 해당하는지 결과를 반환.
- `resultIntList`: 각 자리별 수에 대해 `checkNumberIndexOf`를 실행하고 그 결과를 반영한 정수 타입의 리스트 반환.
- `sendResultTo`: 결과와 Console 객체를 매개변수로 전달 받고 결과를 Console 객체에게 전달.

### 4. ConsoleManager
`ConsoleManager` 클래스는 사용자로부터 입력을 받고 그 입력을 `NumberBaseballComputer` 객체에게 전달하거나 전달 받은 결과 리스트를 `printByList` 함수를 통해 화면에 띄워준다.


---

### 예외사항
예외 사항 목록

| No  | Exception                | Category | Explanation          |
|:----|--------------------------|--------|----------------------|
| 1   | `IllegalArgumentException` | 사용자 입력 | 3자리 수 중 중복된 수가 있을 경우 |
| 2   | `IllegalArgumentException` | 사용자 입력 | 숫자가 아닌 입력이 있을 경우 |
| 3   | `IllegalArgumentException` | 사용자 입력 | 3자리 미만 혹은 4자리 이상의 수가 입력될 경우 |
