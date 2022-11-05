package algorithms.exhaustive_search.bj_1520

import java.util.*

private val dr = arrayOf(-1, 0, 1, 0)
private val dc = arrayOf(0, -1, 0, 1)

private var m = 0
private var n = 0
private lateinit var map:Array<Array<Int>>
private lateinit var dp:Array<Array<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    m = st.nextToken().toInt()
    n = st.nextToken().toInt()

    map = Array(m +1){Array(n +1){0} }
    dp = Array(m +1){Array(n +1){-1} }

    repeat(m){ i->
        st = StringTokenizer(readLine())
        repeat(n){ j->
            map[i+1][j+1]=st.nextToken().toInt()
        }
    }

    println(dfs(1,1))
}

fun dfs(sr:Int, sc:Int):Int{
    if(sr== m && sc== n) return 1
    if(dp[sr][sc]!=-1) return dp[sr][sc]

    dp[sr][sc] = 0
    for(i in 0..3){
        val nr = sr+ dr[i];
        val nc = sc+ dc[i];

        if(nr<1||nr> m ||nc<1||nc> n) continue
        if(map[sr][sc]<= map[nr][nc]) continue

        dp[sr][sc]+= dfs(nr,nc)
    }
    return dp[sr][sc];
}
