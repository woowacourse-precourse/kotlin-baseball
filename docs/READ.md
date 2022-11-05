## 구현 목표

최대한 모듈화 하자. 
변수명, 함수명 누구든지 알아볼 수 있게 만들기.


## 게임 흐름

1. 게임 시작 버튼을 누른다.
2. 컴퓨터에는 랜덤 3자리 숫자 값이 정해지며 사용자는 3자리 숫자를 입력한다.
3. 두 각각의 숫자를 비교하고, 결과를 출력한다.
4. 3 스트라이크시 게임을 종료하며 재시작, 종료를 물어보는 문구를 띄운다.

## 만들어본 기능 목록

1. Computer: 컴퓨터의 랜덤값을 생성하고 관리하는 클래스
    * createComputerNumberList(): 컴퓨터가 1에서 9까지의 서로 다른 임의의 수 3개를 선택하며 순서대로 리스트에 넣는 함수

2. ThrowException: 입력값에 대한 예외처리를 관리하는 클래스
    * throwExceptionForUserNumber(): 사용자가 3자리 숫자를 올바르게 입력하지 않았다면 예외를 던져주는 함수
        * isNumber(): 입력한 값이 숫자인지 판단해주고 Boolean 형으로 반환해주는 함수
        * hasThreeDigits(): 입력한 값이 세자리 수 인지 판단해주고 Boolean 형으로 반환해주는 함수
        * hasDistinctDigits(): 입력한 값에 중복된 숫자가 있는지 판단해주고 Boolean 형으로 반환해주는 함수
      
    * throwExceptionForRestartNumber(): 게임 종료시에 사용자가 입력을 올바르게 하지 않았다면 예외를 던져주는 함수
        * isNumber(): 입력한 값이 숫자인지 판단해주는 함수
        * isOneOrTwo(): 입력값이 1과 2 사이에 있는지 판단해주는 함수
      
3. BaseballGame: 컴퓨터 값과 유저의 값을 비교하고 판단하는 등 게임을 진행하는 클래스
    * processGame(): 게임을 진행하는 함수
       * inputUserNumber(): 사용자로부터 입력을 받고, ThrowException 객체를 통해 예외 처리를 한 후 반환하는 함수
       * createUserNumberList(): 사용자로부터 입력 받은 숫자를 쪼개어 순서대로 리스트에 넣고 리스트를 반환하는 함수
       
       * judgeResult(): 두 개의 배열을 인자로 받아 반복문을 돌려 스트라이크와 볼과 낫싱을 판단하고 string 형태로 반환하는 함수
           * compareDigitOfSameNumber() 사용자의 숫자 값이 컴퓨터 값 리스트에 포함되어 있을 때 각각의 index 를 비교하여 일치하면 스트라이크, 불일치하면 볼에 1씩 더해주는 함수
           * decideResultString(): 결과를 string 형태로 바꿔주는 함수
      
4. Application: 게임을 실행하는 클래스
    * startGame(): 게임을 시작하는 함수
       * inputNumberForRestartGame(): 재시작 혹은 종료를 위한 값을 입력받고 ThrowException 객체를 통해 예외 처리를 한 후 반환하는 함수
           




