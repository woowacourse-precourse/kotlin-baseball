# Kotlin-Baseball 기능 목록

### main()
>게임 실행

### gameImplementation()
>다음 함수들을 호출하며 게임 진행
>1. gameAnswer(): 야구 게임 정답(computer)을 구하는 함수
>2. baseballCount(): ball, strike 개수 구하는 함수
>위 과정에서 3개의 숫자를 모두 마친 후
>3. gameState(): 게임 재실행 여부 결정하는 함수

### gameState()
> 변수 gameState 에 재실행여부 저장(1: 재실행, 2: 게임 종료)
> 예외: 1,2 이외의 수를 입력했을 때 

### inputAnswer()
> user의 입력값 처리 함수
> exceptionTest(): 입력값 예외 처리 함수 호출

### exceptionTest()
> 예외의 경우
> 1. 3자리 수가 아닐 때
> 2. 1부터 9까지의 수가 아닐 때
> 3. 서로 다른 수가 아닐 때

### gameAnswer()
> 1. 컴퓨터의 정답(랜덤한 서로 다른 세 자리 수)을 만드는 함수
> - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
     Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

### baseballCount()
>1. strike의 수 계산
>2. else if를 사용하여 ball의 수 계산
>3. printResult() 함수 호출해서 양식에 맞게 출력

### printResult()
> 1. 형식에 맞게 출력한다.
> 2. 스트라이크가 3일 때 return, 아닐 때 재귀함수 사용해서 과정 반복
