package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    runBaseballGame()
}

fun runBaseballGame() {
    println("숫자 야구 게임을 시작합니다.")

    var inputGoAndStopStatus: String = "1"
    var answerBaseballNumber: String = generateRandomBaseballNumber()

    while (inputGoAndStopStatus == "1") {

        print("숫자를 입력해주세요 : ")
        val inputThreeNumber: String = readLine().toString()
        if (inspectInputThreeNumberStatus(inputThreeNumber) == -1) throw IllegalArgumentException()

        val baseballStatus: List<Int> = calculateBaseballAndThreeNumberStatus(answerBaseballNumber, inputThreeNumber)
        printBaseballStatus(baseballStatus)
        if(baseballStatus[0] != 3) continue

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        inputGoAndStopStatus = readLine().toString()
        if(inspectInputGoAndStopStatus(inputGoAndStopStatus) == -1) throw IllegalArgumentException()
        if(inputGoAndStopStatus == "1") answerBaseballNumber = generateRandomBaseballNumber()
        if(inputGoAndStopStatus == "2") println("게임 종료")
    }
}