# 최종 기능 목록
|번호|함수명|반환값|기능설명|
|:-:|:--:|:---:|:---:|
|1|printStart|None|시작 문구 출력 함수|
|2|printNothing|None|볼과 스트라이크가 없을 경우 낫싱을 출력하는 함수|
|3|printReport|Boolean|볼과 스트라이크 개수에 따라 출력하는 함수, 3스트라이크 시 true 반환으로 새 게임 여부를 결정함|
|4|printEnd|None|새 게임을 물어보는 문구 출력 함수|
|5|continueChecker|Boolean|사용자에게 새 게임 시작 여부(원할때: true, 원하지 않을때: false, 잘못 입력시에는 IllegalArgumentException)를 반환하는 함수|
|6|getInput|String|사용자로부터 입력받는 함수|
|7|mapConverter|Map|리스트를 문자: 인덱스 맵으로 변환하는 함수|
|8|listChecker|Boolean|올바른 입력인지 검사하는 함수. 올바르지 않을 경우 false 반환|
|9|equalCounter|Int|스트라이크 개수 세는 함수|
|10|getRandomNumList|MutableList|랜덤 배열 생성 함수|

# 기능 로직
|순서|기능 설명|함수명/변수명|
|:-:|:----:|:---:|
|1|게임 시작 문구를 출력한다|printStart()|
|2|수를 문자열로 입력받는다|getInput()|
|3|각 문자열을 리스트로 변환한다|listConverter()|
|4|입력받은 수가 올바른지 검사한다|listChecker()|
|5|맵 생성|playerMap, computerMap|
|6|셋 생성|playerSet, computerSet|
|7|셋에서 공통 원소 저장|commonSet|
|8|공통원소가 있다면 개수 저장|v1|
|9|v1이 없다면 낫싱 출력|printNothing()|
|10|맵에서 공통 원소의 인덱스가 같은지 확인(=스트라이크 개수)|equalCounter()|
|11|10의 결과 개수 저장|v2|
|12|v1-v2를 balls에 저장(음수 혹은 0이면 모두 0으로)|balls|
|13|상황에 따라 결과 출력하는 함수 실행|printReport()|
|14|v2 == 3 이라면 게임 종료 출력|printEnd()|
|15|새 게임을 위한 입력 받기 및 입력 확인|continueChecker()|
|16|15에서 입력받은 값에 따라 지속 여부 결정|continueBool|


# 추가하는 조건
|순번|추가해야할 조건|
|:-:|:---------:|
|1|무한 루프 방지를 위해 최대 반복 20회 제한|
|2|20회 지났으면 강제 종료|
|3|숫자말고 문자를 받아서는 안됨|


# 처음 설계 이후 추가한 기능 목록
|번호|기능 설명|함수명|
|:-:|:-----:|:--:|
|1|컴퓨터가 랜덤으로 생성한 리스트|getRandomNumList()|
|2|리스트를 맵으로 변환하는 함수|mapConverter()|
|4|사용자가 입력한 결과에 대해 결과 출력하는 함수|printReport()|


# 설계 변경 기록
|번호|변경 사유|~에서|~으로|
|:-:|:----:|:--:|:--:|
|1|단순 출력 기능에서 입력 확인 기능이 추가됨에 따라 함수명 변경|printContinue|continueChecker|
|2|개수 세는 기능에서 공통 원소 반환하는 기능으로 변경됨에 따라 불필요 함수가 되어 제거|intersectCounter|REMOVED|
