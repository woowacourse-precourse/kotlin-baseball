package baseball.util

import baseball.resources.*
import baseball.util.interfaces.RandomUtil
import camp.nextstep.edu.missionutils.Randoms

class RandomGenerate : RandomUtil {
    override fun generate(): String {
        return Randoms.pickNumberInRange(
            RANDOM_VALUE_MIN_IN_RANGE, RANDOM_VALUE_MAX_IN_RANGE
        ).toString()
    }
}
