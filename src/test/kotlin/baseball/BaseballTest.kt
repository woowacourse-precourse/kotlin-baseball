package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballTest : NsTest() {

    private val baseballTest = Baseball()

    @Test
    fun `스트라이크만 있을 경우`() {
        baseballTest.printBaseballCount(0, 1)
        assertThat(output().toString().trim()).isEqualTo("1스트라이크")
    }

    @Test
    fun `볼만 있을 경우`() {
        baseballTest.printBaseballCount(1, 0)
        assertThat(output().toString().trim()).isEqualTo("1볼")
    }

    @Test
    fun `스트라이크 볼 둘다 있을 경우`() {
        baseballTest.printBaseballCount(1, 1)
        assertThat(output().toString().trim()).isEqualTo("1볼 1스트라이크")
    }

    @Test
    fun `볼,스트라이크 모두 없을 경우`() {
        baseballTest.printBaseballCount(0, 0)
        assertThat(output().toString().trim()).isEqualTo("낫싱")
    }

    override fun runMain() {
        main()
    }
}
