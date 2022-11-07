## 필요한 기능

### 예상 시나리오
- 컴퓨터로 랜덤한 숫자 발생
- 사용자로부터 숫자 입력 받음
    - 예외인 경우 → `IllegalArgumentException`
    - 예외가 아닌 경우 → 볼/스트라이크 등의 결과 정보 구하기
    - (예외) 중복 숫자가 포함되어있는지
    - (예외) 숫자가 3자리가 맞는지
    - (예외) 숫자가 아닌 것을 입력했는지 
- 숫자를 맞춘 경우 (3 스트라이크) → 재시작 여부

### 예상 필요 함수 목록
| 함수 | 매개변수 | 반환형 | 내용 |
| --- | --- | --- | --- |
|playGame| | |main에서 게임 실행을 위해 호출하는 함수|
| makeRandomNumberList |  | MutableList<Int> | 컴퓨터로 하여금 랜덤한 세자리 숫자 발생시킴 |
| isHavingDuplicatedNumber | Int | Boolean | 중복된 숫자가 포함되어있는지 여부 |
| isIntegerNumber | Int | Boolean | 입력한 형태가 숫자가 맞는지 여부 |
| isNumberOfDigitsCorrect | Int | Boolean | 입력한 숫자 자리수가 맞는지 여부 |
| getListOfNumberByDigits | Int | MutableList<Int> | 사용자가 입력한 숫자를 자릿수별로 나누어 리스트로 저장 |
