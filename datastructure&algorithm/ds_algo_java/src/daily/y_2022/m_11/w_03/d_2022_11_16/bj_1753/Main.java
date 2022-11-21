package daily.y_2022.m_11.w_03.d_2022_11_16.bj_1753;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] map = new ArrayList[V+1];
        for(int i=0;i<map.length;i++){
            map[i] = new ArrayList<>();
        }


        int E = Integer.parseInt(st.nextToken());

        int[] dist = new int[V+1];
        for(int i=0;i<=V;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        int s = Integer.parseInt(br.readLine());
        dist[s] = 0;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[u].add(new Node(v,w));
        }

        dijkstra(s,map,dist);

        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }

        }

    }
    static void dijkstra(int s,ArrayList<Node>[] map,int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node n = new Node(s,0);
        pq.offer(n);
        boolean[] visited = new boolean[dist.length];

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curV = curNode.end;
            int curWeight = curNode.weight;
            visited[curV] = true;
            for(Node node : map[curV]){
                int endNode = node.end;
                int endWeight = node.weight;
                if(visited[endNode]) continue;

                if(curWeight+endWeight<dist[endNode]){
                    dist[endNode] = curWeight+endWeight;
                    pq.offer(new Node(endNode,dist[endNode]));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{

        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return weight-o.weight;
        }
    }
}
