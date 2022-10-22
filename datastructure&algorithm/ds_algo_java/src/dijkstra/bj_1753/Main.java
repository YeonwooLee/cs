package dijkstra.bj_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, weight;
    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = Integer.MAX_VALUE;
    static int v,e,k;
    static ArrayList<Node>[] list;
    static int[] dist;//시작 정점에서 -> 각 정점까지의 거리

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());//정점 수
        e = Integer.parseInt(st.nextToken());//간선 수
        k = Integer.parseInt(br.readLine());//시작노드 번호

        list = new ArrayList[v+1];//각 정점 리스트
        dist = new int[v+1];//시작노드 -> 각 정점까지의 거리

        //거리 무한 초기화
        Arrays.fill(dist,INF);

        //정점 초기화
        for (int i=1;i<=v;i++){
            list[i]=new ArrayList<>();
        }


        //정점리스트에 각 edge 초기화
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            //start -> end로 가는 가중치 weight
            list[start].add(new Node(end,weight));
        }


        dijkstra(k);//k로부터 시작되는 다익스트라

        for(int i=1;i<=v;i++){
            System.out.println(dist[i]==INF?"INF":dist[i]);
        }
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //노드에서 출발하는 엣지들을 체크한 노드 = 최단거리 이미 구한 노드
        boolean[] check = new boolean[v+1];

        //시작정점을 pq에 넣는다
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();//현재 start Node랑 가장 가까운 노드
            int cur = curNode.end;//해당 녿드의 번호



            //해당노드의 간선 순회
            for(Node node:list[cur]){
                if(dist[node.end]>dist[cur]+node.weight){
                    dist[node.end] = dist[cur]+node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }

        }
    }


}
