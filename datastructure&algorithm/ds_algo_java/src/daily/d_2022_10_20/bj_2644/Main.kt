package daily.d_2022_10_20.bj_2644
import java.util.Queue;
import java.util.LinkedList;

private fun readInts() = readLine()!!.split(" ").map{it.toInt()}
fun main(){
    //총 가족 수 만큼 맵 생성
    val num = readLine()!!.toInt()
    val map = Array<MutableList<Int>>(num+1){ mutableListOf() }

    //촌수 구할 두명
    val(start,end) = readInts()

    //총 엣지 수
    val edges = readLine()!!.toInt()
    for(i in 1..edges){
        val(s,e) = readInts()
        map[s].add(e)
        map[e].add(s)
    }

    val visited = Array<Boolean>(num+1){false}

    println(bfs(map,visited,start,end))
}

fun bfs(map:Array<MutableList<Int>>, visited:Array<Boolean>, start:Int, end:Int):Int{
    val q:Queue<Array<Int>> = LinkedList<Array<Int>>()
    q.offer(arrayOf(start,0))
    visited[start]=true

    while(!q.isEmpty()){
        val curNode = q.poll()
        val man = curNode[0]
        val chon = curNode[1]

        for(i in map[man]){
            if(visited[i]) continue
            if(i==end) return chon+1

            visited[i]=true
            q.offer(arrayOf(i,chon+1))
        }
    }
    return -1
}