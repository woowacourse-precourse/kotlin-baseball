package baseball
import camp.nextstep.edu.missionutils.Console.readLine

fun printStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printNothing() {
    TODO("v1이 없다면 낫싱 출력하는 함수 구현")
}

fun printEnd() {
    TODO("v2 == 3 이라면 게임 종료 출력하는 함수 구현")
}

fun printContinue() {
    TODO("새로 게임을 하려는지 문구 출력 및 입력 받는 함수 구현")
}

fun getInput(): String {
    return readLine()
}

fun listConverter(inputString: String): ArrayList<String> {
    TODO("각 문자열을 리스트로 변환하는 함수 구현")
}

fun listChecker(inputList: ArrayList<String>): Boolean {
    TODO("입력받은 수가 올바른지 검사하는 함수 구현")
}

fun equalChecker(v2: Int): Boolean {
    TODO("v2 == 3 확인하는 함수")
}

fun intersectCounter(): Boolean {
    TODO("셋에서 공통 원소가 있는지 확인(볼/스트라이크)하는 함수 구현")
}

fun equalCounter(): Boolean {
    TODO("맵에서 공통 원소의 value가 같은지 확인(스트라이크)하는 함수 구현")
}



fun main() {
    TODO("프로그램 구현")
}
