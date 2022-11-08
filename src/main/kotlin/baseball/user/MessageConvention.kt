package baseball.user

import java.util.regex.Matcher
import java.util.regex.Pattern

fun checkInputUserNumber(userInputNumber: String?) {
    val checkOverlapInputNumber = mutableListOf<String>()
    val inputNumberStandard = "^[1-9]*$"
    //중복체크
    userInputNumber ?: throw IllegalArgumentException()
    for (userInputNumberWord in userInputNumber) checkOverlapInputNumber.add(userInputNumberWord.toString())

    checkInputMessagePatten(inputNumberStandard, checkOverlapInputNumber)

    if (checkOverlapInputNumber.size !=3||checkOverlapInputNumber.distinct().size != 3) throw IllegalArgumentException()

}

fun checkInputGameOverMessage(userInputGameOverMessage: String?) {
    val checkOverlapInputResultContinue = mutableListOf<String>()
    val inputGameOverNumStandard = "^[1-2]*$"

    userInputGameOverMessage ?: throw IllegalArgumentException()

    for (userContinueWord in userInputGameOverMessage) checkOverlapInputResultContinue.add(userContinueWord.toString())

    checkInputMessagePatten(inputGameOverNumStandard, checkOverlapInputResultContinue)

    if (userInputGameOverMessage.length != 1) throw IllegalArgumentException()

}
/**입력받은 것이 숫자인지 확인하는 기능**/
fun checkInputMessagePatten(standard: String, checkOverlap: MutableList<String>) {
    val pattern: Pattern = Pattern.compile(standard)

    for (inputNum in checkOverlap) {
        val matcher: Matcher = pattern.matcher(inputNum)
        if (matcher.find().toString() == "false") throw IllegalArgumentException()
    }
}