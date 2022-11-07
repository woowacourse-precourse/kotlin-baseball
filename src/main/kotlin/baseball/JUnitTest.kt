package baseball

fun setTestAnswer() : String {

    // "Test Argument Error"
    if(testAnswerList.isEmpty()) IllegalArgumentException()

    val selectAnswerInTestList: String = testAnswerList[0]
    testAnswerList.removeAt(0)

    if(inspectInputThreeNumberStatus(selectAnswerInTestList) != 1) IllegalArgumentException()

    return selectAnswerInTestList
}