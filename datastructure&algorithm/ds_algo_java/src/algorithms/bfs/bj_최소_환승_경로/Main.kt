package algorithms.bfs.bj_최소_환승_경로;

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br=BufferedReader(InputStreamReader(System.`in`))

fun main(){
    val nm = br.readLine().split(" ")
    val stationNum = nm[0].toInt()//역 수
    val lineNum = nm[1].toInt()//호선 수

    val stations = Array<MutableList<Int>>(stationNum+1){ mutableListOf() }//역 공간
    val lines = Array<MutableList<Int>>(lineNum){ mutableListOf() }//호선 공간

    val visitedStation = Array<Boolean>(stationNum+1){false}
    val visitedLine = Array<Boolean>(lineNum){false}

    repeat(lineNum){line->
        br.readLine().split(" ").forEach{station->
            val stationNumber = station.toInt()
            if(stationNumber!=-1){
                lines[line].add(stationNumber)
                stations[stationNumber].add(line)
            }
        }
    }

    val se = br.readLine().split(" ")
    val start = se[0].toInt()
    val end = se[1].toInt()


    val result = bfs(start, end, visitedStation, visitedLine, stations, lines)
    println(result)


}

fun bfs(
    start: Int,
    end: Int,
    visitedStation: Array<Boolean>,
    visitedLine: Array<Boolean>,
    stations: Array<MutableList<Int>>,
    lines: Array<MutableList<Int>>
):Int {
    val pq = PriorityQueue<Node>()
    visitedStation[start] = true//시작역 방문처리
    stations[start].forEach{
        pq.offer(Node(it,start,0))
        visitedLine[it] = true
    }

    while(!pq.isEmpty()){
        val cur = pq.poll()
        val nowStation = cur.station
        val nowLine = cur.line
        val nowChange = cur.change
        if(nowStation==end) return nowChange

        for(i in 0 until stations[nowStation].size){
            val nextLine = stations[nowStation][i]
            if(visitedLine[nextLine]) continue

            visitedLine[nextLine] = true
            pq.offer(Node(nextLine,nowStation, nowChange+1))
        }

        for(i in 0 until lines[nowLine].size){
            val nextStation = lines[nowLine][i]

            if(visitedStation[nextStation]) continue
            visitedStation[nextStation] = true
            pq.offer(Node(nowLine,nextStation, nowChange))
        }
    }
    return -1
}

class Node(var line:Int, var station:Int,var change:Int):Comparable<Node>{
    override fun compareTo(other: Node): Int =
        when{
            this.change<other.change -> -1
            this.change>other.change ->1
            else->0

        }
}

