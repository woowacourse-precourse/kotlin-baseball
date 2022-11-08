## ✅ 기능 목록
1. `makeComputerChoose()` : 호출 시 컴퓨터는 __1~9까지의 랜덤한 수를 선택 후 ArrayList에 add__  
  1-1. 같은 수를 여러번 선택할 경우 add하지 않으며 배열의 길이가 3이 될 때까지 선택을 반복
3. `gameStart()` : 게임 시작 (게임 시작 문구 출력, 1번의 함수를 통해 컴퓨터는 랜덤 수 선택 시작)
4. `userInput()` : 플레이하는 동안(`while (chooseStartOrEnd == 1)`) 사용자는 숫자를 입력하고 `splitNum` 함수에 의해 split됨  
3-1. `splitNum()` : 매개변수를 __1번의 return 값과 같은 형식(배열)으로__ split
4. `checkUserInputForm()` : 사용자가 플레이 중 __잘못된 형식의 숫자를 입력했을 때 예외__ 발생시키기
5. `checkStrikeOrBall()` : split된 사용자 예측 숫자의 strike, ball 개수 확인
6. `checkResult()` : 5번에서 얻은 strike, ball 개수에 따른 결과 분석 __(예측 성공 or 실패)__
7. `askRestart()` : 사용자가 예측에 성공한 경우`(userWin = true)` 게임 종료 안내 및 재시작 여부 묻기  
7-1. 재시작 여부 입력 시 1이나 2가 아닌 값을 입력했을 경우 예외 발생시키기
8. `printResult()` : 사용자가 예측에 __실패한 경우 strike, ball 개수 출력__
9. `resetResult()` : 다음 예측을 위해 __strike, ball 개수는 0으로,__ `userWin = false`로 초기화
