package daily.y_2022.m_11.w_03.d_2022_11_18.bj_1043
import java.io.BufferedReader;
import java.io.InputStreamReader;
var br = BufferedReader(InputStreamReader(System.`in`))
lateinit var parent:Array<Int>
var count =0
fun main() {
    val nm = br.readLine()
    val n = nm.split(" ")[0].toInt()
    val m = nm.split(" ")[1].toInt()

    parent = Array<Int>(n+1){it}
    val party = Array<Boolean>(m){true}

    val knowns = br.readLine().split(" ")
    val knownNum = knowns[0].toInt()


    for(i in 1..knownNum){
        val p = findParent(knowns[i].toInt())
        parent[p]=0
    }

    val temp = mutableListOf<List<String>>()
    repeat(m){
        val partymembers = br.readLine().split(" ")
        temp.add(partymembers)
        val num = partymembers[0].toInt()
        var flag = true
        for(i in 1 .. num){
            val curMem = partymembers[i].toInt()
            if(findParent(curMem)==0){
                flag=false
                for(j in 1..num){
                    parent[findParent(j)]=0
                }
                break
            }
        }
    }
    repeat(m){
        val partymembers = temp.get(it)
        val num = partymembers[0].toInt()
        var flag = true
        for(i in 1 .. num){
            val curMem = partymembers[i].toInt()
            if(findParent(curMem)==0){
                flag=false
                break
            }
        }
        if(flag) count++
    }

    println(count)
}

fun findParent(n:Int):Int{
    if(parent[n]==n) return n
    parent[n] = findParent(parent[n])
    return parent[n]
}