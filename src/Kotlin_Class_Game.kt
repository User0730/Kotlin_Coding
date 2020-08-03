import java.util.*

open class Object() {
    var hp = 0.0
    var gold = 0.0
}
class char : Object(){
        var atk = 0.0
        var exp = 0.0
}






fun main(){
    var player = char()
    var monster = char()
    inputdata(player, "플레이어")
    inputdata(monster, "몬스터")
}

fun inputdata(name: char, index: String){
    var sc : Scanner = Scanner(System.`in`)
    print("${index} 의 체력 : ")
    var hp = sc.nextDouble()
    name.hp = hp
    print("${index} 의 공격력 : ")
    var atk = sc.nextDouble()
    name.atk = atk
    print("${index} 의 경험치 : ")
    var exp = sc.nextDouble()
    name.exp = exp
    print("${index} 의 잔고 : ")
    var gold = sc.nextDouble()
    name.gold = gold
    println("")
}

fun combat(player: char, index1: String, monster: char, index2: String){
    println("${index1}가 ${index2}를 공격했다!")
    player
}