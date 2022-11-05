package baseball
import camp.nextstep.edu.missionutils.Console.readLine

fun printStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printNothing() {
    println("낫싱")
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

fun listConverter(inputString: String): MutableList<Char> {
    return inputString.toMutableList()
}

fun listChecker(inputList: MutableList<Char>): Boolean {
    if (inputList.size !in 1..3) {
        return false
    }
    return true
}

fun equalChecker(v2: Int): Boolean {
    TODO("v2 == 3 확인하는 함수")
}

fun intersectCounter(playerSet: Set<Char>, computerSet: Set<Char>): Int {
    return playerSet.intersect(computerSet).size
}

fun equalCounter(
    playerMap: HashMap<Char, Int>,
    computerMap: HashMap<Char, Int>,
    intersectSet: Set<Char>
): Boolean {

    intersectSet.forEach { c ->
        if (playerMap.getValue(c) == computerMap.getValue(c)) {
            return true
        }
    }
    TODO("맵에서 공통 원소의 value가 같은지 확인(스트라이크)하는 함수 구현")
}



fun main() {
    TODO("프로그램 구현")
}
