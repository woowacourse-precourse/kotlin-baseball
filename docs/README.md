# 미션 - 숫자 야구

## 🔍 구현할 기능 목록
### ✅ 기능 요구사항
#### 프로그램  
- 1에서 9까지 서로 다른 임의의 수 3개를 정한다.  
```TEXT
  - 중복된 숫자가 없도록 함
```  

#### 플레이어  
- 3자리 수를 입력한다.
```TEXT
  - 비정상적인 입력일 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 문자, 3자리가 아닐 경우, 중복된 숫자가 있을 경우 
```

#### 힌트
- 같은 자리에 같은 숫자가 있는 경우 `스트라이크`를 출력한다.  
- 다른 자리에 같은 숫자가 있는 경우 `볼`을 출력한다.  
- 같은 숫자가 하나도 없는 경우 `낫싱`을 출력한다.  

#### 게임 종료
- 프로그램의 3자리 숫자와 플레이어의 3자리 숫자가 같은 경우 게임이 종료된다.
  - 게임을 재시작하려면 `1`을 입력한다.
  - 게임을 완전히 종료하려면 `2`를 입력한다.
  - 비정상적인 입력에 대해서는 `IllegalArgumentException`을 발생시킨다.
```TEXT
- 1, 2 외의 다른 숫자가 입력된 경우  
- 문자가 입력된 경우  
```  

### ✅ 프로그래밍 요구사항
#### 요구사항
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다  
- 1 <= indent depth && indent depth <= 2 이다.  
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
#### 라이브러리  
-  `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.

### 🎉 최종 구현안 함수명
- 컴퓨터에게 랜덤 숫자 3개 받기 -> randomThreeNumber()  
- 게임시작 -> gameStart()
  - 사용자 입력 숫자(유효성 체크) -> guessNumber()
  - 스트라이크, 볼 카운트 -> userNumberCheck()
  - 스트라이크, 볼 or 낫싱 출력 -> userNumberCheckResult()
- 게임을 새로 시작할 것인지, 종료할 것인지 -> restartOrFinish()