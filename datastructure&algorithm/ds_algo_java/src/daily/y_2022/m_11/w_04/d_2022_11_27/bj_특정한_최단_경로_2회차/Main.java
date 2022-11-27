package daily.y_2022.m_11.w_04.d_2022_11_27.bj_특정한_최단_경로_2회차;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dist;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        //맵 초기화
        ArrayList<Node>[] map = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }

        //간선 잇기
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }

        //임의의 두 정점
        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());


        //거리
        dist = new int[n+1];

        int oneToP1 = dijkstra(1,p1,dist,map);
        int oneToP2 = dijkstra(1,p2,dist,map);
        int p1ToP2 = dijkstra(p1,p2,dist,map);
        int p1ToEnd = dijkstra(p1,n,dist,map);
        int p2ToEnd = dijkstra(p2,n,dist,map);



        // int a = oneToP1+p2ToEnd;

        // int b = oneToP2+p1ToEnd;
        int a = mySum(oneToP1,p2ToEnd);
        int b = mySum(oneToP2,p1ToEnd);
        int result = mySum(Math.min(a,b),p1ToP2);
        if(result==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }





    }
    static int mySum(int a, int b){
        return (long)a+(long)b>Integer.MAX_VALUE?Integer.MAX_VALUE:a+b;
    }
    static int dijkstra(int from, int to, int[] dist,ArrayList<Node>[] map){
        //dist 초기화하고 들어올것
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[dist.length];

        dist[from] = 0;
        visited[from] = true;


        pq.offer(new Node(from,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curVertex = cur.end;
            int curDist = cur.weight;
            visited[curVertex] = true;//뽑힌 이상 최단거리야

            for(Node next:map[curVertex]){
                int nextEnd = next.end;
                int nextWeight = next.weight;
                if(visited[nextEnd]) continue;

                if(curDist+nextWeight<dist[nextEnd]){
                    dist[nextEnd] = curDist+nextWeight;
                    pq.offer(new Node(nextEnd,dist[nextEnd]));
                }
            }
        }
        // System.out.println(from+"->"+to+"="+dist[to]);
        return dist[to];

    }
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
}
