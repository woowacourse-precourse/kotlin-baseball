# 미션 - 숫자 야구

## 🔍 기능목록
0. 게임을 실행시킨다.
1. 컴퓨터가 서로 다른 3자리의 난수를 만든다.
   - 1.1 camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 사용해 구현한다.
2. 사용자가 서로 다른 3자리의 입력을 한다.
   - 2.1 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
   - 2.2 입력할 때마다 정규표현식을 통해 입력값을 검증한다.
   - 2.3 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
3. 3에서의 입력을 토대로 Ball과 Strike를 판별한다.
4. 2와 3이 서로 같다면(성공했다면) 게임을 종료한다.
5. 게임을 종료했다면 재시작 여부를 묻는다.
   - 5.1 정규표현식을 통해 1과 2 중 하나를 입력했는지 판별한다.
   - 5.2 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
   - 5.3 만약 사용자가 1을 선택했다면(게임을 계속한다면) 1번부터 반복한다.
   - 5.4 2를 선택했다면(게임을 종료한다면) 애플리케이션을 종료한다.

## 🚨 예외처리
- 스트라이크와 볼이 함께 등장한다면 볼이 먼저 등장한다.
- 스트라이크와 볼 둘 중 하나만 만족한다면 1볼, 0스트라이크와 같은 출력을 하지 않는다.
- 사용자가 잘못된 값을 입력한다면 예외처리를 통해 애플리케이션을 종료한다.
- 종료 시 System.exit()를 호출하지 않는다.

## 📮 고찰
### 경고문구 확인
- WARNING: An illegal reflective access operation has occurred
- WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console (file:/C:/Users/drdd1/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed
- WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
- WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
- WARNING: All illegal access operations will be denied in a future release
  - 프로젝트를 진행하면서 위와 같은 경고문구를 확인했습니다.
  - 테스트코드와 메인코드 모두 정상적으로 작동하나 경고문구를 제거하기 위해 정보를 찾아보았습니다.
  - JDK 11 버전을 사용하고 있기 때문에 발생
  - java -version과 인텔리제이 IDE에서 사용하고 있는 버전이 다르기 때문이라는 정보를 얻었습니다.
  - 하지만 확인해 본 결과 같은 버전을 사용하고 있어 경고문구를 지우지 못했습니다.

### 정규표현식
- val regex = "^[1-9]{3}$".toRegex()
- val regex = "^[1-2]$".toRegex()
  - 정규표현식을 통해 코드를 간결하고 이해하기 쉽게 작성할 수 있다는 것을 배웠습니다.
  - 조건문을 통해 여러줄로 표현할 것을 정규표현식을 통해 작성했습니다.