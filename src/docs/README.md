# 기능목록작성

### UI

- 입력
    - [ ] 세자리 숫자 입력받기
    - [ ] 1 (재시작), 2(종료) 입력 받기
- 출력
    - [ ] 볼 출력하기
    - [ ] 스트라이크 출력하기
    - [ ] 볼, 스트라이크 출력하기
    - [ ] "숫자 야구 게임을 시작합니다."
    - [ ] "숫자를 입력해주세요 : "
    - [ ] "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

### Domain

- [ ] 볼 개수 확인
- [ ] 스트라이크 개수 확인
- [ ] 스트라이크 개수가 3개인지 확인
- [ ] 게임을 다시 시작할지 종료할지 결정

# MVC 아키텍처 적용하기
-
### Controller
- GameController
    - guess()
    - retry()
### View
- InputView
    - readNumbers()
    - readRetry()
- OutputView
    - printBall()
    - printStrike()
    - printBallStrike()
    - printGameStart()
    - printPleaseInput()
    - printCorrect()

### Model
- RandomNumberGenerator
    - generate()
- RandomThreeNumberGenerator
    - generate()
- MakeNumbers
    - make()