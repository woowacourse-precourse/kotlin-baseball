package baseball
import kotlin.text.toInt
import kotlin.io.println
import kotlin.collections.mutableListOf
import camp.nextstep.edu.missionutils.Randoms

var strike :Int = 0
var ball : Int = 0
val inputnum : Array<Int?> = arrayOfNulls<Int>(3)
val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)

fun make_answer(comAnswer: Array<Int>) 
{
    val comAnswer : Array<Int?> = arrayOfNulls<Int>(3)
    var switch = BooleanArray(10)
    for (i in switch.indices)
    {
        switch[i] = false 
    }
    var w =0 
    while(w<3)
    {   
        var r = (Math.random() * 10).toInt()
        if(switch[r]==false)
        {
            switch[r] =true 
            comAnswer[w] = r + 1 
            w++
        }
    }
}