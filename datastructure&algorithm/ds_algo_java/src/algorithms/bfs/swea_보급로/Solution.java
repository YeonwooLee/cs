package algorithms.bfs.swea_보급로;
import java.io.*;
import java.util.PriorityQueue;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int n;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            //초기화
            for(int i=0;i<n;i++) {
                String s = br.readLine();
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(s.substring(j,j+1));
                }
            }

            int result = bfs(0,0);
            bw.write("#"+tc+" "+result+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int sr, int sc) {
        PriorityQueue<Land> pq = new PriorityQueue<>();

        Land land = new Land(sr,sc,0);


        visited[sr][sc] = true;
        pq.offer(land);

        while(!pq.isEmpty()) {
            Land cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            int ct = cur.time;
            if(cr==n-1 && cc==n-1) return ct;


            for(int i=0;i<4;i++) {
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=n) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                pq.offer(new Land(nr,nc,ct+map[nr][nc]));
            }

        }

        return -1;
    }

    static class Land implements Comparable<Land>{
        int r;
        int c;
        int time;
        public Land(int r,int c,int time) {
            this.r =r;
            this.c =c;
            this.time=time;
        }
        @Override
        public int compareTo(Land o) {
            return this.time - o.time;
        }

    }

}