참고: 다른 게임도 만들 수 있는 확장성을 위해 조금 복잡하지만 이런 상속 구조로 만들었다는 점 양해 바랍니다.

구현할 기능 목록

1. GameProgressImpl 인터페이스 : 만들 게임을 진행할 객체를 만들기 위한 인터페이스. run메소드를 구현하도록 유도한다.
2. GameProgress 추상 클래스: GameProgressImpl인터페이스를 구현한 추상클래스임. run을 어떻게 사용할지 가이드라인을 제시하는 추상클래스임. 만약 이 추상 클래스에서 정의한 run방식이 맘에
   안든다면, GameProgressImpl을 구현한 다른 추상클래스를 만들어서 run을 새롭게 구성하면 됩니다.
   생성자: 입력을 받기 위한 두가지 객체 User와 Enemy타입의 객체를 각각 받습니다. 그리고 게임 진행 상황을 메시지로 출력하기 위한 StringMaker 타입의 객체도 생성자로 받습니다. 
   run(): 게임을 시작하기 위한 메소드입니다. 외부에서는 이 메소드만 확인 가능합니다. 내부에서 gameStart메소드와 isRestartGame메소드를 사용합니다. 이 두 메소드는 추상 메소드로 선언되어 있기
   때문에 이 추상클래스를 상속받는 클래스 쪽에서 정의해주면 됩니다. 이걸 어떻게 정의 해주냐에 따라 무슨 게임인지와 게임 재시작 조건이 달라집니다.

3. BaseBallGameRule 클래스: GameProgress 추상 클래스를 상속하는 클래스입니다. 부모 클래스에서 추상메소드로 선언됐었던 isRestartGame메소드와 gameStart메소드를 정의합니다.
   이 클래스는 숫자 야구 게임을 진행하기 위한 클래스입니다.
   isRestartGame(): 1을 입력받으면 true를 리턴합니다. 
   gameStart(): 게임 하나에 대해서 정의된 메소드입니다. 게임을 클리어해야 반복문을 탈출할 수 있습니다. 매 반복마다 입력을 받고
   입력에 대한 유효성을 검증한 다음에 사용자의 입력을 정수 리스트로 변환해서 컴퓨터가 선택한 숫자들과 비교합니다. 만약 게임 하나의 종료조건과 동일한 출력문이 나온다면 반복문을 탈출하고(즉,게임을 클리어한다면)
   true를 반환합니다.

4. StringMaker 인터페이스: 게임 진행 상황 메시지를 화면에 출력하기 위해 메시지를 어떻게 어떤 것들을 만들어야 할지 가이드라인을 주는 인터페이스입니다.
5. BaseballStringMaker 클래스: StringMaker 인터페이스를 구현한 숫자 야구 게임을 위한 문자열 생성 클래스입니다.
   initGameStartMessage(): 게임 초기에 출력할 문자열인  "숫자 야구 게임을 시작합니다."을 리턴합니다.
   inputForEachRoundMessage(): 각 라운드에 입력 받기 위한 문자열인 "숫자를 입력해주세요 : " 을 리턴합니다.
   resultCurRound(user: Any, computer: Any): 매 라운드에서 입력을 받은걸 토대로, user와 computer의 정수령 리스트를 비교해서 출력해야할 결과를 리턴합니다. ballCount메소드와 strikeCount메소드를 호출합니다.
   gameClearMessage(): 게임 클리어 시에 출력할 문자열인 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"를 리턴합니다.
   gameFailedMessage(): 게임 클리어에 실패하면 출력할 문자열을 반환합니다. 단, 이 숫자게임에서는 게임 클리어하거나 입력을 잘못 받을때까지 게임이 끝나지 않기 때문에 이 메소드는 필요가 없습니다.
   restartGameQuestionMessage(): 게임을 다시 할지 말지 입력받기 위해 출력해야 할 문자열인 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."을 반환합니다.
   ballCount(user: List<Int>, computer: List<Int>): 볼 개수를 세서 리턴해주는 메소드입니다.
   strikeCount(user: List<Int>, computer: List<Int>): 스트라이크 개수를 세서 리턴해주는 메소드입니다.

6. Participant 인터페이스: 게임에 참가하는 참가자들을 나타내기 위한 인터페이스입니다. 게임의 참가자는 최소한 게임의 종류가 무엇이든지 간에 게임 안에 자신의 의견 혹은 입력을 건내줄 수단인 input()메소드를 구현해야 합니다.
   User클래스: Participant인터페이스를 구현한 클래스이고 Console.readLine()을 사용해서 입력을 받는 input()메소드를 구현합니다.
   Computer클래스: Participant인터페이스를 구현한 클래스이고 구현한 input()메소드 안에서 computerRandomChoiceNumber()를 호출해서 랜덤 숫자 세개를 Randoms.pickNumberInRange(1,9)를 사용해서 가져옵니다.

7. InputValidCheckAndConverter(private val inputConverter: InputConverter) 추상클래스: 입력에 대해 유효성을 검증하고 입력이 유효하다면, inputConverter객체를 활용해서 입력을 변환해서 리턴해줍니다.
   inputValidCheckAndConvert(questionType: Int, input: String): 이 안에서 inputValidCheck를 호출해서 questionType에 맞는 유효성 검증을 수행합니다. 만약 여기서 유효하지 않다는 결과를 받으면, 
                                                               isNotValidThrowException()을 호출해서 예외를 발생시킵니다.
   이 외에도 이 추상 클래스는 inputValidCheck()추상메소드와 isNotValidThrowException() 추상메소드가 선언되어 있어야 합니다.
8. BaseballInputValidCheckAndConverter 클래스는 숫자야구게임을 진행하기 위해 받은 입력에 대해 유효성 검증을 하고 필요에 맞게 변환시켜서 반환해주도록 구성되어 있습니다.
   curRoundInputValidCheck(input: String): 각 라운드마다 입력받은 것이 숫자 세개가 들어있는 스트링인지 확인하고 맞다면 true를 반환합니다.
   isNumberValidRange(num: Int): 해당 숫자가 1~9 이내인지에 대한 참/거짓 여부를 리턴합니다.
   restartGameInputValidCheck(input: String): 게임 재시작 여부에 대한 입력을 받은 문자열이 정확히 숫자 한개로 구성되어 있는지 또한 그 숫자가 1혹은2의 숫자가 맞는지에 대한 참/거짓 여부를 리턴합니다.
   restartAnswerInputValidRange(input: String): 게임 재시작 여부에 대한 입력을 받은 문자열이 1혹은2의 숫자가 맞는지 검증하는 메소드입니다.

9. InputConverter 인터페이스: 입력받은 인풋 스트링에 대해서 적절하게 변환해주는 메소드를 구현하도록 유도하는 인터페이스입니다. convertInput(questionType: Int, input: String)이 선언되어 있습니다.
10. BaseballGameInputConverter 클래스: InputConverter 인터페이스를 숫자 야구게임에 맞게 구현한 인풋컨버터입니다. convertInput(questionType: Int, input: String)는 questionType에 맞게 적절한 변환 함수를 호출합니다.
    convertCurRoundInput(input: String): 각 라운드에서 입력받는 질문에 대한 인풋스트링을 List<Int>로 변환해주는 메소드입니다.
    convertRestartGameInput(input: String): 게임이 클리어 되고 나서 게임 재시작 여부 질문에 대한 입력인풋을 Int형으로 변환해주는 메소드입니다.
    companion object로 const val INPUT_CUR_ROUND = 0, const val INPUT_RESTART_GAME = 1 이 정의되어 있어서 questionType을 이용하는데 편리하게 해줍니다.
