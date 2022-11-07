package daily.y_2022.m_10.w_05.d_2022_10_30.pg_등대_kt

class Solution {
    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        val nodes  = Array(n+1){mutableListOf<Int>()}
        val visited = Array(n+1){0}

        lighthouse.forEach{
            val s = it[0]
            val e = it[1]
            nodes[s].add(e)
            nodes[e].add(s)
        }

        dfs(nodes,visited,1)

        var cnt=0
        visited.forEach{it->
            if(it==2) cnt++
        }
        return cnt
    }

    fun dfs(nodes:Array<MutableList<Int>>,visited:Array<Int>, cur:Int){
        visited[cur] = 1

        nodes[cur].forEach{ end->
            if(visited[end]==0){
                dfs(nodes,visited,end)
                if(visited[end]==1){
                    visited[cur]=2
                }
            }
        }
    }
}