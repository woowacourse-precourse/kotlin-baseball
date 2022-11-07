## 🚀 Application.kt 기능 목록
`Application.kt` 파일은 프로그램 실행에 필요한 `main` 함수와 baseballGame을 실행하기 위한 함수들을 제공한다.

### 주요 함수 목록

|함수|파라미터|반환 값|설명|
|---|---|---|---|
|`launchApplication`|`Unit`|`Unit`|`startBaseballGame`을 수행하고 user로부터 입력을 받는다. [요구사항] `startBaseballGame` 함수가 종료되고 입력이 1이면 수행을 반복한다.|
|`startBaseballGame`|`Unit`|`Unit`|`NumberBaseballComputer` 객체를 생성하고 `isPoweredOn` 함수를 참조하여 사용자 입력을 반복할 수 있도록 한다.|
|`validateReStartInput`|`String`|`Unit`|게임 재시작 문구에 대한 user의 입력에 대해 예외사항을 확인한다.|
