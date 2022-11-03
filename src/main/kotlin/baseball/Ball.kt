package baseball

class Ball {

    var number : Int
    var position : Int

    constructor(number: Int, position: Int) {

        if(number < 1 || number > 9) {
            throw IllegalArgumentException("1에서 9사이의 숫자여야 합니다.")
        }
        this.number = number
        this.position = position
    }

}