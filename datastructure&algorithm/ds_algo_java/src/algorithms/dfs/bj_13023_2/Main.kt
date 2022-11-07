package algorithms.dfs.bj_13023_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

val br = BufferedReader(InputStreamReader(System.`in`))
var flag = false
fun main(){
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array<MutableList<Int>>(n){ mutableListOf() }

    repeat(m){
        val se = br.readLine().split(" ")
        val s = se[0].toInt()
        val e = se[1].toInt()

        map[s].add(e)
        map[e].add(s)
    }

    for(i in 0..n-1){
        val visited = Array<Boolean>(n){false}
        visited[i] = true
        dfs(i,1,visited,map)
        if(flag) break
    }

    val lambda = {f:Boolean->
        when(f){
            true->1
            false->0
        }
    }

    println(lambda(flag))

}

fun dfs(node:Int, friends:Int,visited:Array<Boolean>,map:Array<MutableList<Int>>){
    if(friends==5){
        flag = true
        return
    }

    for(i in map[node]){
        if(visited[i]) continue

        visited[i] = true
        dfs(i,friends+1,visited,map)
        visited[i] = false
    }
}