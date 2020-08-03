
import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class Circle(){
    var r = 0.0
    var x = 0.0
    var y = 0.0
    var loc = mutableListOf<Double>(x, y)
}


fun main(){
    var First = Circle()
    var Second = Circle()
    inputdata(First, "첫 번째")
    inputdata(Second, "두 번째")
    println("두 원의 중심 사이 거리는 ${Distance(First.x, Second.x, First.y, Second.y)} 입니다.")
    Shortest(First, Second)
    DefineState(First, Second)
}

fun inputdata(name: Circle, index: String){
    var sc : Scanner = Scanner(System.`in`)
    print("${index} 원의 반지름 : ")
    var r = sc.nextDouble()
    name.r = r
    print("${index} 원의 중심 x 좌표 : ")
    var x = sc.nextDouble()
    name.x = x
    print("${index} 원의 중심 y 좌표 : ")
    var y = sc.nextDouble()
    name.y = y
    println("")
}

fun Distance(a : Double, b : Double, c : Double, d : Double) : Double {
    var dis = sqrt((b - a) * (b - a) + (d - c) * (d - c))
    return dis
}

fun Shortest(First: Circle, Second: Circle){
    if(Distance(First.x, Second.x, First.y, Second.y) < First.r + Second.r)
        if(Distance(First.x, Second.x, First.y, Second.y) + min(First.r, Second.r) < max(First.r, Second.r))
            println("두 원 위의 임의의 점 간의 거리 중 가장 짧은 거리의 길이는 ${max(First.r, Second.r) - Distance(First.x, Second.x, First.y, Second.y) - min(First.r, Second.r)} 이다.")
        else
            println("두 원 위의 임의의 점 간의 거리 중 가장 짧은 거리의 길이는 0 이다.")
    else
        println("두 원 위의 임의의 점 간의 거리 중 가장 짧은 거리의 길이는 ${Distance(First.x, Second.x, First.y, Second.y) - First.r - Second.r} 이다.")
}

fun DefineState(First: Circle, Second: Circle){
    if(Distance(First.x, Second.x, First.y, Second.y) == 0.0 && First.r == Second.r)
        println("겹친다.")
    else if(Distance(First.x, Second.x, First.y, Second.y) < First.r + Second.r)
        if(Distance(First.x, Second.x, First.y, Second.y) + min(First.r, Second.r) < max(First.r, Second.r))
            println("한 원이 다른 원 안에 있다.")
        else if(Distance(First.x, Second.x, First.y, Second.y) + min(First.r, Second.r) == max(First.r, Second.r))
            println("내접한다.")
        else
            println("두 점에서 만난다.")
    else if(Distance(First.x, Second.x, First.y, Second.y) == First.r + Second.r)
        println("외접한다.")
    else
        println("서로 밖에 있다.")
}


