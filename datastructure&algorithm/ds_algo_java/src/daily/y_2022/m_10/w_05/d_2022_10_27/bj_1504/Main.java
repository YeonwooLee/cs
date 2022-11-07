package daily.y_2022.m_10.w_05.d_2022_10_27.bj_1504;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end;
    int weight;
    boolean ness;
    public Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight-o.weight;
    }
}
public class Main {
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, E;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] map = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            map[i] = new ArrayList<>();
        }


        dist = new int[N+1];


        for(int i=0;i<E;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int[] necessary = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

        int sToV1,sToV2,v1ToV2,v1ToE,v2ToE;
        dijkstra(map,1);
        sToV1 = dist[necessary[0]];
        sToV2 = dist[necessary[1]];

        dijkstra(map,necessary[0]);
        v1ToV2=dist[necessary[1]];
        v1ToE=dist[N];

        dijkstra(map,necessary[1]);
        v2ToE=dist[N];

        if(Math.min(sToV1+v1ToV2+v2ToE,sToV2+v1ToV2+v1ToE)<100000000) System.out.println(Math.min(sToV1+v1ToV2+v2ToE,sToV2+v1ToV2+v1ToE));
        else System.out.println(-1);

    }

    private static void dijkstra(ArrayList<Node>[] map, int start){
        int INF = 100000000;
        Arrays.fill(dist,INF);
        boolean[] visited = new boolean[map.length];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node n = new Node(start,0);
        dist[start] = 0;


        pq.offer(n);

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            if(visited[cur]) continue;
            visited[cur] = true;

            for(Node node:map[cur]){

                if(dist[node.end]>dist[cur]+node.weight){
                    dist[node.end]=dist[cur]+node.weight;
                    pq.offer(new Node(node.end,dist[node.end]));

                }
            }
        }

    }
}
