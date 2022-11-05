package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.*


fun main() {

    var input = readLine()
    var InputInt = input?.toInt()

    if (InputInt != null) {
        if (InputInt < 100 || InputInt >= 1000) {
            throw IllegalArgumentException("잘못입력하셨습니다.");
        }
    }



    var InputFirst = InputInt!!/100;
    var InputSecond = (InputInt!!-100*InputFirst)/10
    var InputThird = InputInt/10

    if(InputFirst == InputSecond)  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다");
    if(InputThird == InputSecond)  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다");
    if(InputFirst == InputThird)  throw IllegalArgumentException("서로 다른 수를 입력해야 합니다");













}
