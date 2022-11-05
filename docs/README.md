# 숫자 야구 기능 구현

## 알고리즘 순서
```
1) 컴퓨터 숫자가 중복되지 않고 랜덤하게 3자리 숫자를 생성한다.
2) 사용자가 숫자를 입력한다.
3) 사용자가 입력한 숫자와 컴퓨터 숫자를 비교하여 결과를 출력한다.
4) 맞출 때까지 2) ~ 3) 을 반복한다.
```

## Class list

### GamePrint class - 게임출력 클래스
 - gameStart function - 게임시작 함수  
 - inputNum function - 숫자입력 함수
 - result function - 결과 함수
 - answer function - 정답 함수
 - gameProgress function - 게임진행 함수

### GameLogic class - 게임로직 클래스
 - gameStart function - 게임초기화 함수
 - comparison function - 비교 함수
 - userNumToList function - 유저넘버리스트 함수
 - userInput function - 유저입력 함수