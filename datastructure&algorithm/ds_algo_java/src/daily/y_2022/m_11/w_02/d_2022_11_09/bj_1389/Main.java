package daily.y_2022.m_11.w_02.d_2022_11_09.bj_1389;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);//정점 수
        int M = Integer.parseInt(split[1]);//간선 수
        int result = Integer.MAX_VALUE;
        int resultMan =0;

        HashSet<Integer>[] map = new HashSet[N+1];
        for(int i=1;i<=N;i++){
            map[i] = new HashSet<>();
        }

        for(int i=0;i<M;i++){
            split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);

            map[s].add(e);
            map[e].add(s);
        }

        for(int i=1;i<=N;i++){
            int bacon = bfs(map,i);
            if(result>=bacon){
                if(result==bacon){
                    resultMan = Math.min(i,resultMan);
                }else{
                    result = bacon;
                    resultMan = i;
                }
            }
        }

        System.out.println(resultMan);
    }

    static int bfs(HashSet<Integer>[]map,int start){
        boolean[] visited = new boolean[map.length];
        Queue<int[]>q = new LinkedList<>();

        //시작값
        q.offer(new int[]{start,0});
        visited[start]=true;

        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                int curNode = cur[0];
                int curWeight = cur[1];
                result +=curWeight;

                for(int i : map[curNode]){
                    if(visited[i]) continue;

                    visited[i] = true;
                    q.offer(new int[] {i,curWeight+1});
                }
            }

        }
        return result;



    }

}
