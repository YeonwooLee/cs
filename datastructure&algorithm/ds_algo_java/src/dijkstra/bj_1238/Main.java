package dijkstra.bj_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, weight;
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
    static int[] final_dist;
    static int X;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] map = new ArrayList[N+1];
        final_dist = new int[N+1];

        for(int i=1;i<=N;i++){
            map[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[s].add(new Node(e,w));
        }
        for(int i=1;i<=N;i++){
            dijkstra(i,map);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1;i<final_dist.length;i++){
            // System.out.println(final_dist[i]);
            max = Math.max(max,final_dist[i]);
        }
        System.out.println(max);



    }

    private static void dijkstra(int start, ArrayList<Node>[] map){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[map.length];
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<dist.length;i++){
            dist[i] = INF;
        }

        pq.offer(new Node(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            for(Node node :map[cur]){
                if(dist[node.end] > dist[cur]+node.weight){
                    dist[node.end] = dist[cur]+node.weight;
                    pq.offer(new Node(node.end,dist[node.end]));
                }

            }
        }
        if(start==X){
            for(int i=0;i<map.length;i++){
                final_dist[i]+=dist[i];
            }
        }else{
            final_dist[start]+=dist[X];
        }


    }
}
