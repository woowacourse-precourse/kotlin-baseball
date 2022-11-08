package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
//	TODO("프로그램 구현")
	println("숫자 야구 게임을 시작합니다.")
	var answer = makeRandomBaseballNumber()
	var startOrExit = 1
	while (startOrExit == 1) {
		val userNumber = inputNumber()
		callException(isValidInputNumber(userNumber))
		val strike = calculateBaseballScore(userNumber, answer)
		if (printIfSuccess(strike)) {
			startOrExit = selectStartOrExit()
			answer = restartGame(startOrExit, answer)
		}
	}
}

fun restartGame(startOrExit: Int, answer: String): String {
	if (startOrExit == 1)
		return makeRandomBaseballNumber()
	return answer
}

fun selectStartOrExit(): Int {
	var startOrExit = 0
	println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
	startOrExit = Console.readLine().toInt()
	callException(startOrExit == 1 || startOrExit == 2)
	return startOrExit
}

fun printIfSuccess(strike: Int): Boolean {
	if (strike == 3) {
		println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
		return true
	}
	return false
}

fun calculateBaseballScore(userNumber: String, answer: String): Int {
	val ball = countBall(userNumber, answer)
	val strike = countStrike(userNumber, answer)
	if (ball == 0 && strike == 0)
		println("낫싱")
	else if (ball != 0 && strike != 0)
		println("${ball}볼 ${strike}스트라이크")
	else if (ball != 0)
		println("${ball}볼")
	else
		println("${strike}스트라이크")
	return strike
}

fun countStrike(userNumber: String, answer: String): Int {
	var strike = 0
	for (i in 0..2)
		if (userNumber[i] == answer[i])
			strike++
	return strike
}

fun countBall(userNumber: String, answer: String): Int {
	var ball = 0
	for (userDigit in userNumber) {
		for (answerDigit in answer) {
			if (userDigit == answerDigit) ball++
		}
	}
	ball -= countStrike(userNumber, answer)
	return ball
}

fun callException(isValid: Boolean) {
	if (!isValid)
		throw IllegalArgumentException("program exit")
}

fun isValidInputNumber(userNumber: String): Boolean {
	val userNum = userNumber.toMutableList()
	val userNumSize = userNum.size
	if (userNumSize != 3)
		return false
	for (num in userNum) {
		if (num !in '0'..'9')
			return false
		else if (userNum.distinct().size != userNumSize)
			return false
	}
	return true
}

fun inputNumber(): String {
	print("숫자를 입력해주세요 : ")
	return Console.readLine()
}

fun makeRandomBaseballNumber(): String {
	val numbers = mutableListOf<Char>()
	while (numbers.size < 3) {
		val number = Randoms.pickNumberInRange(1, 9).toChar() + '0'.code
		numbers += number
		if (numbers.size != numbers.distinct().size)
			numbers.remove(number)
	}
	return numbers.joinToString("")
}
