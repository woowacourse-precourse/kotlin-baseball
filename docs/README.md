## 기능목록 작성

1. 컴퓨터의 랜덤 수 생성
    - 랜덤 값 추출 : camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange()
    - randomThreeNumber() : 1~9 까지 서로 다른 수로 이루어진 3자리 수를 랜덤으로 생성


2. 서로 다른 3자리 수의 숫자를 입력받기
    - playerThreeNumber() : 사용자에게 세자리 숫자 입력받기
        - camp.nextstep.edu.missionutils.Console 라이브러리의 readLine() 사용
    - inputErrorCheck() : 잘못된 입력일 경우 IllegalArgumentException 발생 후 애플리케이션 종료
        - 1~9 숫자가 아닌 경우
        - 3자리가 아닌 수 입력
        - 중복되는 수 입력


3. 입력한 수와 랜덤 수를 각 자리마다 비교하여 개수 생성
    - findStrike() : 각 자리의 수를 서로 비교하여 같으면 TRUE , 같지 않으면 FALSE
    - findBall() : 스트라이크가 아니면 나머지 자리에 존재하는지 확인 후 같으면 TRUE, 같지 않으면 FALSE
    - printResult() : result 리스트에서 스트라이크, 볼의 개수를 세고 출력


4. 게임이 끝난 경우 1을 입력받으면 재시작 2를 입력받으면 종료
    - 사용자 입력받기 : camp.nextstep.edu.missionutils.Console 라이브러리의 readLine()
        - startOrEnd() : 사용자에게 입력 받고 1이면 재시작 2면 종료
        - inputErrorCheckOneNum() : 잘못된 입력일 경우 IllegalArgumentException 발생 후 애플리케이션 종료
            - 1이나 2가 아닌 입력
        - 정상 입력일 경우 : main 에서 playBaseBall() 함수 실행


5. 게임할 때 반복되는 기능
    - playOneTime() : 플레이어가 값을 입력하면 컴퓨터 수와 비교하여 n볼 n스트라이크 혹은 낫싱 출력
    - playBaseBall() : 게임을 처음부터 반복 실행하는 함수