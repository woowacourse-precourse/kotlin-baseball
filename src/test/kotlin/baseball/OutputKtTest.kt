package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `Output 파일의` {

    @Nested
    inner class `printWelcomeMessage 메소드는` {

        @Nested
        inner class `실행되면` : NsTest() {

            override fun runMain() {
                printWelcomeMessage()
            }

            @Test
            fun `환영 문구를 출력한다`() {
                runMain()

                val output = output()

                assertThat(output).isEqualTo("숫자 야구 게임을 시작합니다.")
            }
        }
    }

    @Nested
    inner class `printMessageAskingForInputNumber 메소드는` {

        @Nested
        inner class `실행되면` : NsTest() {

            override fun runMain() {
                printMessageAskingForInputNumber()
            }

            @Test
            fun `숫자 입력을 요청하는 메세지를 출력한다`() {
                runMain()

                val output = output()

                assertThat(output).isEqualTo("숫자를 입력해주세요 :")
            }
        }
    }
}