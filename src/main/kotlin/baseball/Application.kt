package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    var hitnumber= createthreenumber()

    while(true){
        println("숫자 야구 게임을 시작합니다.")
        println("숫자를 입력해주세요 : ")


    }

}

fun createthreenumber():Int{
    var returnvalue=pickNumberInRange(1,9)
    while(true) {
        var picknumber = pickNumberInRange(1, 9)
        if((returnvalue/10)==picknumber||(returnvalue%10)==picknumber)//중복이 있으면 루프 다시
            continue
        returnvalue=returnvalue*10+picknumber//중복 없으면 추가

        if(returnvalue>99)//세 자리 수가 되었으면
            break
    }

    return returnvalue
}