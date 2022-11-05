package baseball
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun printStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printNothing() {
    println("낫싱")
}

fun printReport(balls:Int, strike: Int) {
    println("{$balls}볼 {$strike}스트라이크")
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

fun intersectCounter(playerSet: Set<Char>, computerSet: Set<Char>): Set<Char> {
    return playerSet.intersect(computerSet)
}

fun equalCounter(
    playerMap: Map<Char, Int>,
    computerMap: Map<Char, Int>,
    intersectSet: Set<Char>
): Int {
    var counter = 0
    intersectSet.forEach { c ->
        if (playerMap.getValue(c) == computerMap.getValue(c)) {
            counter++
        }
    }
    return counter
}

fun getRandomNumList(): MutableList<Char> {
    val computer = mutableListOf<Char>()
    while (computer.size < 3) {
        val randomNumber = Character.forDigit(pickNumberInRange(1, 9), 10)

        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun main() {
    printStart()
    var maxDeep = 0
    val computer = getRandomNumList()
    println(computer.joinToString(separator = ""))

    do {
        val player = listConverter(getInput())
        if (!listChecker(player)) {
            throw IllegalArgumentException()
        }

        val playerSet = setConverter(player)
        val computerSet = setConverter(computer)
        val playerMap = mapConverter(player)
        val computerMap = mapConverter(computer)

        val commonSet = intersectCounter(playerSet, computerSet)
        val v1 = commonSet.size

        if (v1 < 1) {
            printNothing()
            continue
        }

        val v2 = equalCounter(playerMap, computerMap, commonSet)

        var balls = 0

        if (v1 - v2 > 0) { balls = v1 }

        if (v2 == 3) {
            printEnd()
            printContinue()
            maxDeep = 0
        }
        else { printReport(balls, v2) }

        maxDeep++
    } while (maxDeep < 20)


}
