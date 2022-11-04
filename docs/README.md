### 기능 목록
1. 게임 시작 문구를 출력하는 기능
2. 사용자가 맞춰여하는 정답을 만드는 기능
   1. camp.nextstep.edu.missionutils에서 제공하는 Randoms 사용
   2. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
3. 사용자가 3개의 수를 입력하는 기능
   1. camp.nextstep.edu.missionutils.Console의 readLine() 활용
4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료하는 기능
   1. 입력한 값이 숫자가 아닌 경우
   2. 입력한 값이 3개의 숫자가 아닌 경우
   3. 서로 다른 수를 입력하지 않은 경우
5. 같은 수가 자리에 있으면 스타라이크를 카운트하는 기능 
6. 다른 자리에 있으면 볼을 카운트하는 기능 
7. 같은 수가 전혀 없으면 낫싱이라는 힌트를 주는 기능 
8. 정답이면 게임을 종료하는 기능 
9. 게임 재시작 기능
10. 애플리케이션을 종료하는 기능