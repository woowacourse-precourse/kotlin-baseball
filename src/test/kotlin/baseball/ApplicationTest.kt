package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import common.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
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
    fun `예외 테스트_길이`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { checkInputLength("1234") }
            Assertions.assertEquals(Constant.INVALID_LENGTH_ERROR, exception.message)
        }
    }

    @Test
    fun `예외 테스트_0`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { checkIncludeZero("034") }
            Assertions.assertEquals(Constant.INVALID_ZERO_INCLUDE_ERROR, exception.message)
        }
    }

    @Test
    fun `예외 테스트_중복`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { checkDuplicateNum("224") }
            Assertions.assertEquals(Constant.INVALID_DUPLICATE_NUM_ERROR, exception.message)
        }
    }

    @Test
    fun `예외 테스트_숫자만`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { checkOnlyNumber("a24") }
            Assertions.assertEquals(Constant.INVALID_NOT_ONLY_NUMBER_ERROR, exception.message)
        }
    }

    override fun runMain() {
        main()
    }
}
