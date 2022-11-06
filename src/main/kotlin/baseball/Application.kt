package baseball
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun printStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printNothing() {
    println("낫싱")
}

fun printReport(balls:Int, strike: Int): Boolean {
    if (balls > 0 && strike > 0) {
        println("${balls}볼 ${strike}스트라이크")
    } else if (balls > 0 && strike == 0) {
        println("${balls}볼")
    } else if (balls == 0 && strike > 0) {
        println("${strike}스트라이크")

        if (strike == 3) {
            printEnd()
            return true
        }
    }
    return false
}

fun printEnd() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun continueChecker(): Boolean {
    val inputNum = readLine()
    if (inputNum.length == 1 && inputNum == "1") {
        return true
    } else if (inputNum.length == 1 && inputNum == "2") {
        return false
    }

    throw IllegalArgumentException()
}

fun getInput(): String {
    print("숫자를 입력해주세요 : ")
    return readLine()
}

fun mapConverter(inputList: MutableList<Char>) = inputList.mapIndexed { index, c -> c to index }.toMap()

fun listChecker(inputList: MutableList<Char>): Boolean {
    if (inputList.size !in 1..3) return false
    if (inputList.toSet().size != 3) return false

    inputList.forEach { c ->
        if (c !in '1'..'9') { return false }
    }

    return true
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
    var computer = getRandomNumList()

    do {
        val player = getInput().toMutableList()
        if (!listChecker(player)) throw IllegalArgumentException()

        val playerSet = player.toSet()
        val computerSet = computer.toSet()
        val playerMap = mapConverter(player)
        val computerMap = mapConverter(computer)

        val commonSet = playerSet.intersect(computerSet)
        val v1 = commonSet.size

        if (v1 < 1) {
            printNothing()
            maxDeep++
            continue
        }

        val v2 = equalCounter(playerMap, computerMap, commonSet)
        val balls = if (v1 - v2 > 0) { v1 - v2 } else 0

        val reportBool = printReport(balls, v2)
        var continueBool = false
        if (reportBool) { continueBool = continueChecker() }

        if (reportBool && continueBool) {
            maxDeep = -1
            computer = getRandomNumList()
        } else if (reportBool && !continueBool) {
            break
        }

        maxDeep++
    } while (maxDeep < 20)

}
