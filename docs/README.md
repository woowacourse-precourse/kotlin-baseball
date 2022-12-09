# 🚀 기능 구현 목록

- 1 부터 9까지 서로 다른 수로 이루어진 3자리의 수 입력 기능 InputView # inputBaseballNumbers()
  - 1 부터 9까지만 입력 가능하다 InputValidate # baseballNumbersForm()
  - 서로 다른수를 입력해야 한다 InputValidate # duplicateBaseballNumbers()
  - 3 자리만 입력되어야 한다 InputValidate # baseballNumbersForm()
- 1 부터 9까지 서로 다른 수로 이루어진 3자리의 수 반환 기능 NumberGenerator # createBaseballNumbers()
  - 1 부터 9까지만 반환 가능하다 
  - 서로 다른수를 반환해야 한다 
  - 3 자리만 반환 되어야 한다 
- 입력한 수와 반환한 수를 비교하여 결과를 출력하는 기능 OutputView # judgementResult()
  - 같은 수가 같은 자리에 있는 스트라이크의 개수를 구해 결과를 반환합니다 Judgment # getStrikeResult()
  - 다른 자리에 있는 볼의 개수를 구해 결과를 반환합니다 Judgment # getBallResult
  - 같은 수가 전혀 없으면 낫싱 Judgment # getTotalResult
  - 판정의 전체 결과를 반환합니다 Judgment # getTotalResult

- 야구 게임 기능 BaseballActivity # baseballGameExecute
  - 3개의 숫자가 모두 스트라이크일 경우 승리 Judgment # winGame()
  - 게임 진행 BaseballActivity # baseballGame()
  - 게임 다시 시작 또는 종료 BaseballActivity # restartGame()