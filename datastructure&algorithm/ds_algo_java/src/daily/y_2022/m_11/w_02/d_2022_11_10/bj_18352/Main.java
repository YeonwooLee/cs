package daily.y_2022.m_11.w_02.d_2022_11_10.bj_18352;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] split;
    static int N,M,K,X;

    public static void main(String[] args) throws IOException{
        split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);//도시
        M = Integer.parseInt(split[1]);//도로
        K = Integer.parseInt(split[2]);//거리
        X = Integer.parseInt(split[3]);//출발


        ArrayList<Node>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);

            arr[s].add(new Node(e,1));
        }

        dijkstra(arr,X, dist);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(dist[i]==K) result.add(i);
        }

        result.sort(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        if(result.size()==0) System.out.print(-1);
        else {
            for (int i = 0; i < result.size(); i++) {
                if(i==result.size()-1){
                    System.out.print(result.get(i));
                }
                else{
                    System.out.println(result.get(i));
                }

            }

        }



    }
    static void dijkstra(ArrayList<Node>[] arr, int start, int[] dist){
        boolean[] visited = new boolean[arr.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curWeight = cur.weight;
            int curNodeNum = cur.end;
            visited[curNodeNum] = true;
            for(Node n:arr[curNodeNum]) {
                if(visited[n.end])continue;

                if((curWeight+n.weight)<dist[n.end]){
                    dist[n.end] = curWeight+n.weight;
                    pq.offer(new Node(n.end,dist[n.end]));
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

        public int compareTo(Node o){
            if(o.weight==weight){
                return end-o.end;
            }
            return weight-o.weight;
        }

    }

}

