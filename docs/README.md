# 🚀 구현할 기능 목록

## 1. 사전 준비

- [x] 라이브러리 import
- [x] 상수 선언
- [x] 게임 시작 문구 출력
- [x] 게임 진행 함수 생성

## 2. 게임 진행

- [x] 컴퓨터가 무작위의 수 생성
- [x] 반복문으로 종료 시까지 게임 반복
- [x] 플레이어 입력
- [x] 잘못된 값을 입력한 경우 오류 처리
- [x] 입력한 수에 대한 결과 계산
- [x] 결과 출력
- [x] 게임 종료 시 종료 문구 출력

## 3. 게임 종료 후

- [x] 1을 입력한 경우 게임 재시작
- [x] 2를 입력한 경우 게임 종료
- [x] 그 외의 값을 입력한 경우 오류 처리

# 🚨 프로그래밍 요구 사항

### [Kotlin 코드 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)

### 프로그램 종료 시 `System.exit()`를 호출하지 않는다.

### indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

### 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 `test/kotlin/study`를 참고하여 학습한 후 테스트를 구현한다.

### `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
