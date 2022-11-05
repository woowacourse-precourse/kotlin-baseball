## 기능목록 작성
1. 1~9 까지 서로 다른 수로 이루어진 3자리 수를 랜덤으로 생성 (컴퓨터의 수)
   - 랜덤 값 추출 : camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange()


2. 서로 다른 3자리 수의 숫자를 입력받기
   - 사용자 입력받기 : camp.nextstep.edu.missionutils.Console 라이브러리의 readLine()
   - 잘못된 입력일 경우 : IllegalArgumentException 발생 후 애플리케이션 종료
      - 3자리가 아닌 수 입력
      - 중복되는 수 입력


3. 입력한 수와 랜덤 수를 각 자리마다 비교하여 개수 생성
   - comparison() : 두 수를 비교하여 같으면 TRUE 아니면 FALSE 반환
   - findStrike() : 각 자리의 수를 서로 비교하여 같으면 TRUE , 같지 않으면 FALSE
   - findBall() : 스트라이크가 아니면 나머지 자리에 존재하는지 확인 후 같으면 TRUE, 같지 않으면 FALSE
   - resultInsert() : 스트라이크나 볼의 결과를 result 리스트에 삽입
   - resultPrint() : result 리스트에서 스트라이크, 볼의 개수를 세고 출력
   - allStrike() : 숫자를 모두 맞추었는지 확인하고 TRUE, FALSE 반환
      - allStrike가 TRUE면 게임 종료 FALSE면 계속 진행


4. 게임이 끝난 경우 1을 입력받으면 재시작 2를 입력받으면 종료
   - 사용자 입력받기 : camp.nextstep.edu.missionutils.Console 라이브러리의 readLine()
   - 잘못된 입력일 경우 : IllegalArgumentException 발생 후 애플리케이션 종료
      - 1이나 2가 아닌 입력
>>>>>>> 5a33125 (Docs : 기능목록 작성)
 
    
