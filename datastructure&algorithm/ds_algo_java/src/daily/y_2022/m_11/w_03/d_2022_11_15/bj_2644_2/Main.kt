package daily.y_2022.m_11.w_03.d_2022_11_15.bj_2644_2
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br= BufferedReader(InputStreamReader(System.`in`))
fun main(){
    val n = br.readLine().toInt()
    val map = Array<MutableList<Int>>(n+1){ mutableListOf() }

    val ab = br.readLine().split(" ")
    val a = ab[0].toInt()
    val b = ab[1].toInt()

    val m = br.readLine().toInt()
    for(i in 0 until m){
        val xy = br.readLine().split(" ")
        val x = xy[0].toInt()
        val y = xy[1].toInt()

        map[x].add(y)
        map[y].add(x)
    }

    println(bfs(a,b,map))
}

fun bfs( a:Int, b:Int, map:Array<MutableList<Int>>):Int{
    val q:Queue<IntArray> = LinkedList<IntArray>()
    q.offer(intArrayOf(a,0))
    val visited = Array<Boolean>(map.size){false}
    visited[a]=true

    while(!q.isEmpty()){
        val cur = q.poll()
        val num = cur[0]
        val chon = cur[1]

        for(i in map[num]){
            if(visited[i]) continue

            visited[i] = true
            q.offer(intArrayOf(i,chon+1))

            if(i==b) return chon+1
        }
    }
    return -1
}