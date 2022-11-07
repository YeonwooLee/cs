package daily.y_2022.m_11.w_01.d_2022_11_04.bj_1697_2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*

val visited = Array<Boolean>(100001){false}
val br = BufferedReader(InputStreamReader(System.`in`))

fun main(){
    val NK = algorithms.bfs.bj_1697_2.br.readLine().split(" ")
    val N = NK[0].toInt()
    val K = NK[1].toInt()

    println(algorithms.bfs.bj_1697_2.bfs(N, K))
}

fun bfs(n:Int, k:Int):Int{
    if(n==k) return 0

    val q : Queue<Array<Int>> = LinkedList<Array<Int>>()
    q.offer(arrayOf(n,0))

    while(!q.isEmpty()){
        val cur = q.poll()
        val posi = cur[0]
        val time = cur[1]

        val dirs = arrayOf(posi+1,posi-1,posi*2)
        for(i in 0..dirs.size-1){
            val next = dirs[i]
            if(next<0||next>100000) continue
            if(algorithms.bfs.bj_1697_2.visited[next]) continue

            if(next==k) return time+1
            algorithms.bfs.bj_1697_2.visited[next]=true
            q.offer(arrayOf(next,time+1))
        }
    }
    return -1
}
