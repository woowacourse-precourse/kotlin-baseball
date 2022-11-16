package baseball

import baseball.DomainService.sendGameResult
import baseball.DomainService.checkBothNumbers
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    /** fun createRandomNumber test */
    @Test
    fun `난수 생성`() {
        val createList = applicationService.createRandomNumber()
        assertThat(createList).hasSize(3)
        print(createList.toString())
    }

    /** fun checkBothNumbers Test */
    @Test
    fun `두 숫자 비교 낫싱`() {
        val listOfCreatedNumber: List<Int> = listOf(1, 3, 5)
        val listOfInputNumber: List<Int> = listOf(2, 4, 6)
        val result = "낫싱"
        assertThat(sendGameResult(checkBothNumbers(listOfCreatedNumber, listOfInputNumber))).isEqualTo(result)
    }

    @Test
    fun `두 숫자 비교 3볼`() {
        val listOfCreatedNumber: List<Int> = listOf(1, 3, 5)
        val listOfInputNumber: List<Int> = listOf(3, 5, 1)
        val result = "3볼"
        assertThat(checkBothNumbers(listOfCreatedNumber, listOfInputNumber)).isEqualTo(result)
    }

    @Test
    fun `두 숫자 비교 1볼1스트라이크`() {
        val listOfCreatedNumber: List<Int> = listOf(1, 3, 5)
        val listOfInputNumber: List<Int> = listOf(2, 3, 1)
        val result = "1볼 1스트라이크"
        assertThat(checkBothNumbers(listOfCreatedNumber, listOfInputNumber)).isEqualTo(result)
    }

    @Test
    fun `두 숫자 비교 3스트라이크`() {
        val listOfCreatedNumber: List<Int> = listOf(1, 3, 5)
        val listOfInputNumber: List<Int> = listOf(1, 3, 5)
        val result = "3스트라이크"
        assertThat(checkBothNumbers(listOfCreatedNumber, listOfInputNumber)).isEqualTo(result)
    }



    /** entire app test */
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

    override fun runMain() {
        main()
    }

    companion object {
        private val applicationService = ApplicationService
    }
}
