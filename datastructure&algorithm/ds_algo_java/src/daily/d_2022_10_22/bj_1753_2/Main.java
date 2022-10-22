package daily.d_2022_10_22.bj_1753_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
    int end,weight;
    public Node(int end, int weight){
        this.end = end;
        this.weight=weight;
    }
    @Override
    public int compareTo(Node o){
        return weight-o.weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF=Integer.MAX_VALUE;
        int V,E;
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            list[i] = new ArrayList<>();
        }

        int[] dist = new int[V+1];
        for(int i=1;i<=V;i++){
            dist[i]=INF;
        }

        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u =Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        dijkstra(list,dist,K);
        for(int i=1;i<=V;i++){
            System.out.println(dist[i]==INF?"INF":dist[i]);
        }
    }

    private static void dijkstra(ArrayList<Node>[] list, int[] dist, int K){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K,0));
        dist[K]=0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            for(Node node:list[cur]){
                if(dist[node.end]>dist[cur]+node.weight){
                    dist[node.end]=dist[cur]+node.weight;
                    pq.offer(new Node(node.end,dist[node.end]));
                }
            }
        }
    }
}
