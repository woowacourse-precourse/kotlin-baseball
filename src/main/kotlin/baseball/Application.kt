package baseball
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun printStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printNothing() {
    println("낫싱")
}

fun printEnd() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun printContinue() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun getInput(): String {
    print("숫자를 입력해주세요 : ")
    return readLine()
}

fun listConverter(inputString: String): MutableList<Char> {
    return inputString.toMutableList()
}

fun mapConverter(inputList: MutableList<Char>): Map<Char, Int> {
    return inputList.mapIndexed { index, c -> c to index }.toMap()
}

fun setConverter(inputList: MutableList<Char>): Set<Char> {
    return inputList.toSet()
}

fun listChecker(inputList: MutableList<Char>): Boolean {
    if (inputList.size !in 1..3) {
        return false
    }
    return true
}

fun equalChecker(v2: Int): Boolean {
    if (v2 == 3) {
        return true
    }
    return false
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

fun getRandomNumList(): MutableList<Char> {
    val computer = mutableListOf<Char>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber.toChar())) {
            computer.add(randomNumber.toChar())
        }
    }
    return computer
}

fun main() {
    printStart()
    var maxDeep = 0
    val computer = getRandomNumList()

    do {
        val player = listConverter(getInput())
        if (!listChecker(player)) {
            throw IllegalArgumentException()
        }

        val playerMap = mapConverter(player)
        val computerMap = mapConverter(computer)

        val playerSet = mutableSetOf<Char>()
        val computerSet = mutableSetOf<Char>()

        TODO("입력 받은 후 맵과 셋으로 변경하는 알고리즘 추가")

        maxDeep++
    } while (maxDeep < 20)


}
