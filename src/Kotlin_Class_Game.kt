import java.util.*

open class Object() {
    var hp = 0.0
    var gold = 0.0
}
class char : Object(){
        var atk = 0.0
        var exp = 0.0
}
public var result1: Boolean = false
fun main(){
    var player = char()
    var monster = char()
    inputdata(player, "플레이어")
    inputdata(monster, "몬스터")
    combat(player, "플레이어", monster, "몬스터")
    reward(result1, player, "플레이어", monster, "몬스터")
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

fun combat(char1: char, index1: String, char2: char, index2: String) : Boolean{
    println("${index1}가 ${index2}를 공격했다!")
    var rnds = (0..4).random()
    if(rnds == 1) {
        char2.hp = char2.hp - char1.atk * 2.5
        println("치명타!")
    }
    else
        char2.hp = char2.hp - char1.atk

    if (char1.hp <= 0.0 || char2.hp <= 0.0){
        result1 = true
        return true}
    else {
        println("${index2}의 체력 : ${char2.hp}")
        combat(char2, index2, char1, index1)
        return false
    }
}

fun reward(result1: Boolean, char1: char, index1: String, char2: char, index2: String){
    if(result1 == true)
        when(char1.hp <= 0) {
        true -> {char2.exp = char2.exp + char1.exp
               char2.gold = char2.gold + char1.gold
               char1.gold = 0.0
               char1.exp = 0.0
               println("${index1} 가 쓰러졌다!\n${index2}의 경험치 : ${char2.exp}\n${index2}의 잔고 : ${char2.gold}")}
        else -> {
             char1.exp = char1.exp + char2.exp
             char1.gold = char1.gold + char2.gold
             char2.gold = 0.0
             char2.exp = 0.0
             println("${index2} 가 쓰러졌다!\n${index1}의 경험치 : ${char1.exp}\n${index1}의 잔고 : ${char1.gold}")
         }
         }
}