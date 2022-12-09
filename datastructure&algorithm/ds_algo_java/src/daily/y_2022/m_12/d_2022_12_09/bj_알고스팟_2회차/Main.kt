package daily.y_2022.m_12.d_2022_12_09.bj_알고스팟_2회차

import algorithms.bfs.bj_알고스팟_2회차.Node
import java.io.BufferedReader
import java.io.InputStreamReader;
import java.util.PriorityQueue

val br = BufferedReader(InputStreamReader(System.`in`))
val dr = arrayOf<Int>(-1,0,1,0)
val dc = arrayOf<Int>(0,-1,0,1)

fun main(){
    val rc = algorithms.bfs.bj_알고스팟_2회차.br.readLine().split(" ")

    val r = rc[1].toInt()
    val c = rc[0].toInt()

    val map = Array<Array<Int>>(r){Array<Int>(c){0} }
    for(i in 0 until r){
        val now = algorithms.bfs.bj_알고스팟_2회차.br.readLine()
        for(j in 0 until c){
            map[i][j] = now.substring(j,j+1).toInt()
        }
    }
    val visited = Array<Array<Boolean>>(r){Array<Boolean>(c){false} }
    visited[0][0] = true

    val res = algorithms.bfs.bj_알고스팟_2회차.bfs(map, visited, 0, 0, r - 1, c - 1)
    println(res)
}

fun bfs(map:Array<Array<Int>>, visited:Array<Array<Boolean>>, sr:Int, sc:Int, r:Int, c:Int):Int{
    val pq = PriorityQueue<Node>()
    pq.offer(Node(sr,sc,0))

    while(!pq.isEmpty()){
        val cur = pq.poll()
        val curR = cur.row
        val curC = cur.col
        val curSudo = cur.sudo
//        println("curR is $curR curC is $curC curSudo is $curSudo")

        if(curR==r && curC==c) return curSudo

        for(i in 0..3){
            val nr = curR+ algorithms.bfs.bj_알고스팟_2회차.dr[i]
            val nc = curC+ algorithms.bfs.bj_알고스팟_2회차.dc[i]

            if(nr<0||nr>r||nc<0||nc>c) continue
            if(visited[nr][nc]) continue

            visited[nr][nc] = true
//            println("mpa[nr][nc] = ${map[nr][nc]}")
            if(map[nr][nc]==1){
                pq.offer(Node(nr,nc,curSudo+1))
            }else{
                pq.offer(Node(nr,nc,curSudo))
            }

        }
    }
    return -1
}

class Node(val row:Int, val col:Int, val sudo:Int):Comparable<Node>{
    override fun compareTo(o: Node):Int{
        return this.sudo - o.sudo
    }
}