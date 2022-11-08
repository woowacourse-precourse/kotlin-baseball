## 필요한 기능

### 예상 시나리오
1. 컴퓨터로 랜덤한 숫자 발생
2. 사용자로부터 숫자 입력 받음
    - 예외인 경우 → `IllegalArgumentException`
    - 예외사항 (우선순위 순)
        - 숫자가 아닌 것이 입력됐는지
        - 중복된 숫자가 포함되어있는지
        - 숫자가 3자리가 맞는지
3. 예외가 없었다면, 스트라이크와 볼의 개수를 계산
4. 숫자를 맞춘 경우 (3 스트라이크) → 반복 종료
   못 맞춘 경우 → 2번부터 반복
5. 재시작 여부
    - 1 또는 2 외의 숫자 입력된 경우 예외 발생

### 예상 필요 함수 목록

| 함수 | 매개변수 | 반환형 | 내용 |
| --- | --- | --- | --- |
|playGame| | | main에서 게임 실행을 위해 호출하는 함수|
| makeRandomNumberList |  | MutableList`<Int>` | 컴퓨터로 하여금 랜덤한 세자리 숫자 발생시킴 |
| getPlayerNumberList | String (input) | MutableList`<Int>` | 사용자가 입력한 값 리스트로 반환 <br/>- 잘못된 입력 예외 발생(checkExceptionOnNumbers) |
| isGameGonnaRestart | | Boolean | main에서 재시작 여부를 묻기 위해 호출하는 함수
| getResultOfGame | MutableList`<Int>`, MutableList`<Int>` | Pair`<Int,Int>` | 사용자와 컴퓨터의 숫자들을 비교, 스트라이크와 볼의 개수 계산
| printResult | Pair`<Int, Int>` | | 결과를 출력하는 함수

<br/>

예외 관련 함수들은 `ExceptionCheckList` 파일에서 관리하기
  
  | 함수 | 매개변수 | 반환형 | 내용 |
  | --- | --- | --- | --- |
  | isHavingDuplicatedNumber | String |  | 중복된 숫자가 포함되어있으면 오류 발생 |
  | isInteger | String |  | 입력한 형태가 숫자가 아닌 형태면 오류 발생 |
  | isNumberOfDigitsCorrect | String |  | 입력한 숫자 자리수가 다르면 오류 발생 |
  | checkExceptionOnNumbers | String (input) | | 입력값 관련 예외 사항들 (위의 3가지 함수) 각각 호출해서 검사 <br/> - 오류 우선순위 순으로 함수 호출