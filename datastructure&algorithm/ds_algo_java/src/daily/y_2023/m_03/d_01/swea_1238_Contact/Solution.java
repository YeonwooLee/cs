package daily.y_2023.m_03.d_01.swea_1238_Contact;
import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static int n, start;
    static HashSet<Integer>[] link = new HashSet[101];
    static int max;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=10;i++){
            sb = new StringBuilder();
            sb.append("#");
            sb.append(i);
            cal();
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.close();



    }
    static void cal() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken())/2;//간선 수
        // Arrays.fill(link,new HashSet());

        for(int i=1;i<=100;i++){
            link[i] = new HashSet<>();
        }

        start = Integer.parseInt(st.nextToken());//시작사람넘버

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            link[s].add(e);
        }
        // for(int i=0;i<=100;i++){
        //     System.out.print(i+"= ");
        //     System.out.println(link[i]);
        // }
        sb.append(" ");
        sb.append(bfs(start));
        // System.out.println(bfs(start));
    }

    static int bfs(int s){
        max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[101];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = true;

        int turn = -1;


        while(!q.isEmpty()){
            turn ++;
            int size=q.size();
            max = Integer.MIN_VALUE;
            // System.out.printf("turn%d ========\n",turn);
            while(size-->0){
                int cur = q.poll();
                // System.out.println(cur);
                max = Math.max(cur,max);
                for(int next:link[cur]){
                    // System.out.print(next);
                    if(visited[next]) {
                        continue;
                    }

                    visited[next]=true;
                    q.offer(next);
                }
            }
            // System.out.println();
        }
        return max;

    }
}
