# 기능목록작성

### UI

- 입력
    - [x] 세자리 숫자 입력받기
    - [x] 1 (재시작), 2(종료) 입력 받기
- 출력
    - [x] 볼, 스트라이크 출력하기
    - [x] 낫싱 출력하기
    - [x] "숫자 야구 게임을 시작합니다."
    - [x] "숫자를 입력해주세요 : "
    - [x] "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

### Domain

- [x] 볼 개수 확인
- [x] 스트라이크 개수 확인
- [x] 스트라이크 개수가 3개인지 확인
- [x] 게임을 다시 시작할지 종료할지 결정
- [x] 랜덤 세 자리 숫자 생성

# MVC 아키텍처 적용하기

### Controller

- GameController
    - guess()
    - retry()

### View

- InputView
    - readNumbers()
    - readRetry()
- OutputView
    - printBallStrike()
    - printMessage()

### Model

- Player
    - guess()
    - findBall()
    - findStrike()
- NumberGenerator
    - generate()
- RandomNumberGenerator
    - generate()
- BaseballMaker
    - make()

# 예외 처리 목록

- readNumbers()
    - 0이 입력된 경우
    - 문자나 공백이 포함된 경우
    - 입력의 자리 수가 3개가 아닌 경우

- readRetry()
    - 1이나 2가 아닌 숫자가 입력된 경우
    - 입력의 자리 수가 1개가 아닌 경우
    - 문자나 공백이 입력된 경우