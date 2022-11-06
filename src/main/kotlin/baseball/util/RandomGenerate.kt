package baseball.util

import baseball.util.interfaces.RandomUtil
import camp.nextstep.edu.missionutils.Randoms

class RandomGenerate : RandomUtil {
    override fun generate(): String {
        return Randoms.pickNumberInRange(1, 9).toString()
    }
}
