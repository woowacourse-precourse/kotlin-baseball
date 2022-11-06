## USECASE
- 성공 시나리오
1. 플레이어가 게임을 시작한다.
2. 시스템은 게임 시작 문구를 출력한다.
3. 컴퓨터는 랜덤한 서로 다른 숫자를 골라 3자리의 수를 만든다.
4. 사용자로부터 수를 입력받는다.
5. 사용자의 입력을 컴퓨터의 수와 비교한다.
6. 컴퓨터의 수와 일치하지 않을 경우 야구 게임의 규칙에 맞는 볼, 스트라이크를 출력해준다.
7. 컴퓨터의 수와 사용자의 입력이 같을 때까지 4~6을 반복한다.
8. 컴퓨터의 수와 사용자의 입력이 같을 경우 게임 종료를 선언하고 게임 재시작 여부를 물어본다.
9. 게임 재시작을 원할 경우 다시 2번으로 돌아가고 종료를 원할 경우 프로그램을 종료한다.


- 대안 시나리오

4a. 사용자가 잘못된 값을 입력할 경우
1. IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

8a. 사용자가 잘못된 값을 입력할 경우
1. IllegalArgumentException을 발생시킨 후 애플리케이션은 종료


## 기능 구현 리스트
1. main()
- 게임이 흘러가는 main 함수
2. setComputerNum(): MutableList<Int>
- 컴퓨터가 자신의 수를 정하는 함수
3. isInputAnswer(computerNum: MutableList<Int>): Boolean
- 사용자의 입력을 받고 컴퓨터의 수와 비교하여 결과를 출력해주고 정답이면 true 반환, 오답이면 false 반환
4. is3Strikes()
- 3스트라이크일 경우 게임 종료 및 새로운 게임시작을 입력받는 함수
5. inputNum(stringInput: String) : MutableList<Int>
- 사용자의 입력을 인자로 받고 잘못된 형식인지 검사하고 잘못되었을 경우 IllegalArgumentExceptionn을 발생시킨 후 종료, 그렇지 않을 경우 input값을 MutableList<Int>로 변환 후 반환
6. changeIntToMutableListInt(input: Int): MutableList<Int>
- int값의 각 자리 숫자를 MutableList<Int>로 변환하는 기능