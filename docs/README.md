## 문제 요약

- 컴퓨터가 랜덤으로 3자리 수를 생성한다.
- 유저는 컴퓨터가 생성한 수를 맞춰야한다.
- 유저가 3자리 수를 모두 맞춘다면 게임을 종료할 것인지 새로 진행할 것인지 의사를 묻는다.

## 기능별 함수 설계

- 핵심 기능
    1. `makeComNumber()`
        1. 설명 : computer 측 3자리수 랜덤 생성
        2. 고려사항
            1. 우테코에서 제공되는 라이브러리안의 Randoms.pickNumberInRange(Int,Int)를 이용하여 1-9까지의 범위를 지정
            2. 랜덤으로 들어오는 수 중에서 중복되는 수는 제외 : mutaleSetOf<>() 사용
            3. 자릿수 비교를 위해 인덱스 필요 : List로 변경
    2. `checkInputNumber()`
        1. 설명 : user측에서 입력받은 수가 유효한지 체크
        2. 고려사항
            1. 숫자만 입력받아야 한다 : char 변경 후 아스키코드[1-9]로 검사
            2. 중복된 값이 있으면 안된다 : Set에 받은 후 길이 검사
            3. 빈 값을 받을 수 없다: isNotEmpty 사용
            4. 위의 조건을 충족하지 못할시 `throw IllegalArgumentException()` 실행
    3. `checkScore()`
        1. 설명 : 컴퓨터의 값과 유저의  값을 비교 후 strike 또는 ball 인지 판단
        2. 고려사항
            1. 서로 같은 수가 있을 때, index가 같다면 strike를 1 증가한다
            2. 서로 같은 수가 있을 때, index가 다르다면 ball을 1 증가한다
    4. `data class ScoreData()`
        1. 설명: strike, ball의 데이터를 담고 있을 data class
        2.  strike: Int, ball: Int
    5. `playAgain()`
        1. 설명: 게임이 끝났음을 알리고 계속 할 것인지 의사를 묻는다
        2. 고려사항
            1. 1을 입력하면 다시시작, 2를 입력하면 종료: when 사용

- 추가 기능
    1.`printScore()`
        1. 설명: `ScoreData()` 인스턴스의 strike, ball의 값에따라 해당하는 문구(낫싱, 볼, 스트라이크)를 출력
        2. 고려사항
            1.  strike가 3일 경우 이겼다는 것을 알린다 : (boolean)win =true
    2.`playBall()`
        1. 설명: 숫자야구게임을 진행한다.
        2. 고려사항 : 게임을 끝낼 것인 지 계속 할 것인지 판단 가능 해야한다