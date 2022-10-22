package daily.d_2022_10_20.bj_2644;
import java.io.*;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//총 인원

        //촌수를 계산할 두 사람 a와 b
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //그래프
        ArrayList<Integer>[] fam = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            fam[i] = new ArrayList<>();
        }

        int nodeNum = Integer.parseInt(br.readLine());//촌수
        for(int i=0;i<nodeNum;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());//시작
            int e = Integer.parseInt(st.nextToken());//끝
            fam[s].add(e);
            fam[e].add(s);
        }

        boolean[] visited = new boolean[n+1];
        int result = bfs(fam,visited, a,b);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    static int bfs(ArrayList<Integer>[] fam, boolean[] visited, int start, int end){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nowMan = cur[0];//현재 가족
            int chon = cur[1];//현재 촌수

            ArrayList<Integer> nodes = fam[nowMan];//현재가족의 노드들
            for(int n:nodes){
                if(visited[n]) continue;
                if(n==end) return chon+1;
                visited[n]=true;
                q.offer(new int[]{n,chon+1});

            }
        }
        return -1;


    }
}
