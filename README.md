# 미션 - 숫자 야구

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

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

---

## ✏️ 과제 진행 요구 사항

- 미션은 [kotlin-baseball](https://github.com/woowacourse-precourse/kotlin-baseball) 저장소를 Fork & Clone해
  시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

### 기능 목록

- 컴퓨터의 랜덤한 3자리 수를 구하는 클래스 구현(class name: ComputerRandomNumber)
    - 변수
        - 3자리 난수 생성에 사용되는 난수 최소값
        - 3자리 난수 생성에 사용되는 난수 최대값
    - randomNumber 초기화해주는 기능
    - 3자리 난수를 만들어 반환하는 기능
    - 만든 3자리 난수를 문자열에 저장하는 기능
- 컴퓨터, 사람 플레이어에 대한 인터페이스 구현(interface name: Player)
    - 플레이어들이 사용할 수를 가져온다
    - 사람이 입력한 수를 검증하는 기능
        - 입력한 수의 각 자리수의 숫자가 달라야 함
        - 3자리 자연수 형태여야 함
    - 입력한 숫자가 3자리 자연수 형태가 아니라면 IllegalArgumentException을 발생시키는 함수
- 컴퓨터 플레이어 정보에 대한 클래스 구현(class name: ComputerPlayer)
    - 컴퓨터의 난수를 가져오는 기능
- 사람 플레이어 정보에 대한 클래스 구현(class name: HumanPlayer)
    - 사람이 정한 3자리 자연수 저장하는 기능
    - 사람이 정한 3자리 자연수 가져오는 기능
    - IllegalArgumentException이 발생하면 "유효하지 않은 숫자형식입니다."을 출력하는 기능
- 숫자야구개임이 수행되는 클래스 구현(class name: BaseballGame)
    - 변수
        - 사람 플레이어가 3자리 수를 모두 맞추었을때 반환되는 String 변수
        - 사람 플레이어의 추측이 틀렸을때 반환되는 String 변수
        - 게임 재시작함을 의미하는 사람플레이어의 입력
        - 게임 끝을 의미하는 사람플레이어의 입력
    - 숫자야구게임이 시작하는 기능
    - 사람 플레이어가 숫자를 정하는 기능
        - 사용자가 적절한 형태를 입력하지 않으면 IllegalArgumentException 발생시키는 기능
    - 숫자야구게임을 재시작할지 또는 끝낼지를 결정하는 기능
        - 사람플레이어가 1을 입력하면 재시작
        - 사람플레이어가 2를 입력하면 종료
        - 다른 값 입력시 IllegalArgumentException 발생
    - 사람플레이어와 컴퓨터플레어이가 고른 수를 비교해서 결과를 출력하는 기능
        - 고른 수가 맞다면 CORRECT_ANSWER를 반환
        - 고른 수가 틀리면 WRONG_ANSWER를 반환
    - 사람 플레이어가 고른 수에서 볼의 갯수에 대한 결과를 만드는 기능
        - 볼이 없으면 빈 문자열을 반환
    - 사람 플레이어가 고른 수에서 스트라이크 갯수에 대한 결과를 만드는 기능
        - 스트라이크가 없으면 빈 문자열을 반환
- ComputerRandomNumber 클래스 Test하는 클래스 구현(class name: ComputerRandomNumberTest)
    - randomNumber에 3자리 난수가 생성됐는지 테스트
- ComputerPlayer 클래스 Test하는 클래스 구현(class name: ComputerPlayerTest)
    - ComputerRandomNumber 인스턴스를 인자로 넘긴 ComputerPlayer의 인스턴스가 3자리 난수를 생성하는지 테스트
- HumanPlayer 클래스 Test하는 클래스 구현(class name: HumanPlayerTest)
    - 3자리 자연수이면 정상적으로 humanSelectedNumber에 값을 할당하는지 테스트
    - 3자리 자연수가 아니라면 IllegalArgumentException이 발생하고 애플리케이션이 종료하는지 테스트
- BaseballGame 클래스 Test하는 클래스 구현(class name: BaseballGameTest)
    - 컴퓨터 난수, 사람 플레이어가 고른 값이 값이 3자리 자연수인지 테스트
    - 3자리 자연수가 아니면 IllegalArgumentException을 발생시키고 애플리케이션을 종료하는지 테스트
- Refactoring
  - trailing commas 추가
  - 클래스 프로퍼티 코딩컨벤션 지키기
  - 함수 매개변수 코딩컨벤션 지키기