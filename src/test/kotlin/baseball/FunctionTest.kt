package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.Collections.max
import java.util.Collections.min

class FunctionTest : NsTest() {

    @Test
    fun `컴퓨터의 랜덤값 유효 확인`() {
        val randomNum = createComputerNumber()
        assertThat(
            checkLength(randomNum)
                    && checkRange(randomNum)
                    && checkDuplication(randomNum)
        )
    }

    @Test
    fun `문자열 입력값 리스트로 변환`() {
        val input = stringInputToList("123")
        assertThat(input).containsExactly(1, 2, 3)
    }

    @Test
    fun `낫싱 테스트`() {
        val userNum = listOf<Int>(1, 2, 3)
        val computerNum = mutableListOf<Int>(4, 5, 6)
        assertThat(checkNothing(userNum, computerNum))
    }

    @Test
    fun `스트라이크 테스트`() {
        val userNum = listOf<Int>(1, 2, 3)
        val computerNum = mutableListOf<Int>(1, 5, 3)
        val strike = checkStrike(userNum, computerNum)
        assertThat(strike).isEqualTo(2)
    }

    @Test
    fun `볼 테스트`() {
        val userNum = listOf<Int>(1, 2, 3)
        val computerNum = mutableListOf<Int>(2, 3, 1)
        val ball = checkBall(userNum, computerNum)
        assertThat(ball).isEqualTo(3)
    }

    @Test
    fun `스트라이크와 볼 출력 테스트`() {
        val userNum = listOf<Int>(1, 2, 3)
        val computerNum = mutableListOf<Int>(8, 2, 1)
        printBallAndStrike(userNum, computerNum)
        assertThat(output()).contains("1볼 1스트라이크")
    }

    @Test
    fun `낫싱 출력 테스트`() {
        val userNum = listOf<Int>(1, 2, 3)
        val computerNum = mutableListOf<Int>(4, 5, 6)
        val isNothing = checkNothing(userNum, computerNum)
        printResult(isNothing, userNum, computerNum)
        assertThat(output()).contains("낫싱")
    }

    @Test
    fun `재시작 예외 테스트`() {
        assertThrows<IllegalArgumentException> { askQuitOrNot("12") }
    }

    @Test
    fun `입력값 길이가 3이 아닌 예외 테스트`() {
        assertThrows<IllegalArgumentException> { checkException("98") }
    }

    @Test
    fun `입력값이 숫자가 아닌 예외 테스트`() {
        assertThrows<IllegalArgumentException> { checkException("1ab") }
    }

    @Test
    fun `입력값에 0이 들어가는 예외 테스트`() {
        assertThrows<IllegalArgumentException> { checkException("803") }
    }

    @Test
    fun `입력값에 중복값이 들어가는 예외 테스트`() {
        assertThrows<IllegalArgumentException> { checkException("141") }
    }

    override fun runMain() {
        main()
    }

    private fun checkRange(randomNum: MutableList<Int>): Boolean {
        if ((min(randomNum) >= 1) && (max(randomNum) <= 9))
            return true
        return false
    }

    private fun checkLength(randomNum: MutableList<Int>): Boolean {
        if (randomNum.size == 3)
            return true
        return false
    }

    private fun checkDuplication(randomNum: MutableList<Int>): Boolean {
        if (randomNum.distinct().size == 3)
            return true
        return false
    }
}