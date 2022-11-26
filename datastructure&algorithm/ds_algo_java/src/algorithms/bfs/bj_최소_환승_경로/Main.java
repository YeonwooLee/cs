package algorithms.bfs.bj_최소_환승_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[] visitedLine; // 방문한 호선
    static boolean[] visitedStation;//방문한 역
    static ArrayList<Integer>[] stations;//역 맵
    static ArrayList<Integer>[] lines;//호선 맵

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//역의 수
        M = Integer.parseInt(st.nextToken());//호선의 수

        visitedStation = new boolean[N+1];//역 방문 N+1
        visitedLine = new boolean[M+1];//호선 방문 M+1

        stations = new ArrayList[N+1];//역 맵 초기화
        lines = new ArrayList[M+1];//호선 맵 초기화
        for(int i=1;i<=N;i++){
            stations[i] = new ArrayList<>();
        }
        for(int i=1;i<=M;i++){
            lines[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num==-1) break;
                lines[i].add(num);
                stations[num].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int answer = go(s,e);
        System.out.println(answer);
    }
    static int go(int s,int e){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visitedStation[s] = true;//시작역 방문처리
        for(int line:stations[s]){//시작역에 해당하는 라인들
            pq.offer(new Node(line,s,0));//시작역에 해당하는 라인들 pq에 넣어준다
            visitedLine[line] =true;//해당라인 방문처리
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();//현재 노드
            if(cur.curStation==e){//같으면 리턴
                return cur.cnt;
            }

            for(int nextStation: lines[cur.curLine]){//현 노선의 다른 역들
                if(visitedStation[nextStation]) continue;//방문역이면 ㅋ패스

                visitedStation[nextStation] = true;//방문처리
                pq.offer(new Node(cur.curLine,nextStation,cur.cnt));//역만 바꿔서 넣어줌
            }

            for(int nextLine: stations[cur.curStation]){//현 역의 다른 호선들
                if(visitedLine[nextLine]) continue;//방문호선 거름
                visitedLine[nextLine] = true; //방문처리
                pq.offer(new Node(nextLine,cur.curStation,cur.cnt+1));
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node>{
        int curLine, curStation, cnt;
        public Node(int curLine, int curStation, int cnt){
            this.curLine = curLine;
            this.curStation = curStation;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return cnt-o.cnt;
        }
    }

}
