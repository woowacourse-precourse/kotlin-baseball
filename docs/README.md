# 구현할 기능 목록 

- 게임 시작 문구 출력
  - 숫자 야구 게임을 시작합니다.
- 컴퓨터의 랜덤 숫자 생성 (1~9까지의 서로 다른 3자리 수)
- 사용자로부터 입력 받기 
  - 숫자를 입력해주세요 : xxx
  - 유효하지 않은 입력값은 예외 처리 → `IllegalArgumentException`
- 정답을 맞힐 때까지 입력값에 대한 결과 출력
    - 같은 수가 같은 자리에 있으면 스트라이크
    - 같은 수가 다른 자리에 있으면 볼
    - 같은 수가 전혀 없으면 낫싱
    - 스트라이크와 볼은 개수 출력 
- 3자리 수를 모두 맞히면 게임 종료
    - 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

# 커밋 메시지 컨벤션

https://gist.github.com/stephenparish/9941e89d80e2bc58a153

- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)

# 코틀린 코드 컨벤션

https://kotlinlang.org/docs/coding-conventions.html

