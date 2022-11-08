# 📂 기능 목록
 
## 📄 Application.kt
게임을 실행시켜 전체적인 작동을 하도록 한다.
- ``` main() ```
    - 숫자야구 게임을 실행시킨다.
- ``` runBaseballGame() ```
    - 사용자로부터 입력을 받아 게임을 진행시키고, 진행 상황을 출력한다. 게임 실행에 있어 전체적인 역할을 한다.
    - 파라미터 : 없음.
    - 반환값 : 없음.
    
## 📄 GameCalculation.kt
숫자야구 게임 진행시 필요한 연산을 수행한다. 
- ``` calculateBaseballAndThreeNumberStatus(String, String) : List<Int> ```
    - 정답과 사용자로부터 입력된 3개의 숫자를 비교해 스트라이크가 몇 개인지, 볼이 몇 개인지 계산한다.
    - 파라미터 : 정답(컴퓨터가 선정한 3개의 숫자), 문자열(사용자가 입력한 3개의 숫자).
    - 반환값 : 리스트. [스트라이크의 개수, 볼의 개수]
- ``` printBaseballStatusMatchForm(List<Int>) ```
    - 맞춘 개수를 출력 양식 규격에 맞추어 출력한다.
    - 파라미터 : 맞춘 개수를 담은 리스트. [스트라이크의 개수, 볼의 개수]
    - 반환값 : 없음.
- ``` generateRandomBaseballNumber() : String ```
    - 컴퓨터의 숫자를 랜덤으로 발생시킨다.
    - 파라미터 : 없음.
    - 반환값 : String. (발행된 3자리 숫자)

## 📄 InspectInput.kt
입력된 값들의 여러가지 상태를 검사한다.
- ``` inspectInputThreeNumberStatus(String) : Int ```
    - 사용자가 입력한 3개의 숫자 값이 정상적인 값인지, 받고자 하는 형태에 부합하는지 등을 검사한다. 
    - 파라미터 : 문자열(사용자가 입력한 3개의 숫자). 
    - 반환값 : 원하는 상태라면 1을, 아니라면 -1을 반환한다 (IllegalArgumentException을 발생시킨다). 
- ``` inspectInputGoAndStopStatus(String) : Int ```
    - 사용자가 입력한 게임 지속 여부 값이 정상적인 값인지, 받고자 하는 형태에 부합하는지 등을 검사한다. 
    - 파라미터 : 문자열(사용자가 입력한 1개의 숫자. go:1, stop:2)
    - 반환값 : 원하는 상태라면 1을, 아니라면 -1을 반환한다 (IllegalArgumentExceptionIllegalArgumentException을 발생시킨다). 
