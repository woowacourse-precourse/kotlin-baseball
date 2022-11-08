package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Nested
    inner class Function2Test {
        @Test
        fun `getComputerNum 메서드로 서로 다른 3자리 수의 리스트 반환`() {
            val numbers = getComputerNum()
            assertThat(numbers)
                    .hasSize(3)
                    .doesNotHaveDuplicates()
        }
    }

    @Nested
    inner class Function3Test {
        @Test
        fun `isNum 메서드가 숫자로 이루어진 스트링값을 입력받았을 때 true 반환`() {
            val strings = listOf("abc", "1")
            assertThat(isNum(strings[0])).isEqualTo(false)
            assertThat(isNum(strings[1])).isEqualTo(true)
        }

        @Test
        fun `isThreeLength 메서드가 3자리 스트링값을 입력받았을 때 true 반환`() {
            val strings = listOf("가나다", "12")
            assertThat(isThreeLength(strings[0])).isEqualTo(true)
            assertThat(isThreeLength(strings[1])).isEqualTo(false)
        }

        @Test
        fun `isNotDuplicate 메서드가 중복이 없는 스트링값을 입력받았을 때 true 반환`() {
            val strings = listOf("12", "112", "abcda")
            assertThat(isNotDuplicate(strings[0])).isEqualTo(true)
            assertThat(isNotDuplicate(strings[1])).isEqualTo(false)
            assertThat(isNotDuplicate(strings[2])).isEqualTo(false)
        }

        @Test
        fun `numToList 메서드가 입력받은 수를 리스트로 반환`() {
            val numbers = "12345"
            val numList = listOf(1, 2, 3, 4, 5)
            assertThat(numToList(numbers)).isEqualTo(numList)
        }
    }

    @Nested
    inner class Function4Test {
        @Test
        fun `getStrikeCount 메서드로 스트라이크 카운트 반환`() {
            val computerNum = mutableListOf(1,5,3)
            val userNum = mutableListOf(1,5,9)

            assertThat(getStrikeCount(computerNum, userNum)).isEqualTo(2)
        }

        @Test
        fun `getBallCount 메서드로 볼 카운트 반환`() {
            val computerNum = mutableListOf(1, 3, 5)
            val userNum = mutableListOf(1, 5, 9)

            assertThat(getBallCount(computerNum, userNum)).isEqualTo(2)
        }

        @Test
        fun `getBallStrikeMessage 메서드가 경우에 따라 볼, 스트라이크, 낫싱 문구 반환`() {
            assertThat(getBallStrikeMessage(0, 2)).isEqualTo("2스트라이크")
            assertThat(getBallStrikeMessage(0, 0)).isEqualTo("낫싱")
        }

        @Test
        fun `getInningResult 메서드로 경우에 맞는 결과 반환`() {
            val userNums = listOf(
                    mutableListOf(3, 2, 4),
                    mutableListOf(5, 2, 8),
                    mutableListOf(9, 8, 7)
            )
            val computerNum = mutableListOf(1, 2, 3)
            val answers = listOf("1볼 1스트라이크", "1스트라이크", "낫싱")
            assertThat(getInningResult(computerNum, userNums[0])).isEqualTo(answers[0])
            assertThat(getInningResult(computerNum, userNums[1])).isEqualTo(answers[1])
            assertThat(getInningResult(computerNum, userNums[2])).isEqualTo(answers[2])
        }
    }

    override fun runMain() {
        main()
    }
}
