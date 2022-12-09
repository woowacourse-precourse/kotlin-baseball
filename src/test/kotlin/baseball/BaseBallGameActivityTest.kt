package baseball

import baseball.controller.BaseballActivity
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class BaseBallGameActivityTest {
    private lateinit var baseballActivity: BaseballActivity
    private val inputNumbers = listOf<Int>(1, 2, 3)
    private val outputStream: OutputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        baseballActivity = BaseballActivity()
        System.setOut(PrintStream(outputStream))
    }


}