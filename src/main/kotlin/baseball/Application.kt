package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    //start_message()
    while(true) {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        //val computer= random_three_number()

        while(true) {
            print("숫자를 입력해주세요 : ")
            var input = readLine()!!.toInt()
            val input_split_temp = mutableListOf<Int>()

            while (input != 0) {
                val num = input % 10
                input_split_temp.add(num)
                input /= 10
            }
            val input_split = input_split_temp.reversed()
            val input_split_set=input_split.toSet()
//            try{
//                if(input_split_set.size!=3){
//                    throw IllegalArgumentException()
//                }
//            }catch (e:IllegalArgumentException){
//                return
//            }
            if(input_split_set.size!=3){
                throw IllegalArgumentException()
            }


            val ball_and_strike = mutableListOf<Int>(0, 0)
            // ball_and_strike[0] => ball
            // ball_and_strike[1] => strike

            for (i in 0..input_split.size - 1) {
                if (input_split[i] == computer[i]) {
                    ball_and_strike[1] += 1
                } else if (input_split[i] in computer) {
                    ball_and_strike[0] += 1
                }
            }
            if(ball_and_strike[0]==0 && ball_and_strike[1]==0){
                println("낫싱")
            } else if (ball_and_strike[0] == 0) {
                println("${ball_and_strike[1]}스트라이크")
            } else if (ball_and_strike[1] == 0) {
                println("${ball_and_strike[0]}볼")
            }
            else {
                println("${ball_and_strike[0]}볼 ${ball_and_strike[1]}스트라이크")
            }

            if(ball_and_strike[1]==3){
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val num=readLine()!!.toInt()
        if(num==2){
            break
        }
        else if(num==1){
            continue
        }
//        else{
//            try{
//                throw IllegalArgumentException()
//            }catch (e:IllegalArgumentException){
//                return
//            }
//        }
        else{
            throw IllegalArgumentException()
        }

    }
}
