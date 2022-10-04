package exhaustive_search.d_2022_10_02.bj_7562;
import java.util.*;
import java.io.*;

//20분
public class Main {
    static int tc;
    static int N;
    static int[][] map;
    static int[] dr = {-2,-1,1,2,2,1,-1,-2};
    static int[] dc = {-1,-2,-2,-1,1,2,2,1};


    static int sr,sc,er,ec;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            init();
            int res = bfs(sr,sc);// 출발지1, 도착지-1
            System.out.println(res);
        }

    }
    private static int bfs(int sr, int sc){
        if(sr==er&&sc==ec) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr,sc});
        map[sr][sc] = 1;
        int result =-1;
        int nr,nc;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i=0;i<8;i++){
                nr = r+dr[i];
                nc = c+dc[i];

                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                if(map[nr][nc]!=0) continue;
                map[nr][nc] =map[r][c]+1;
                if(nr==er&&nc==ec) return map[nr][nc]-1;
                q.offer(new int[] {nr,nc});
            }
        }
        return result;

    }

    private static void init() throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        String[] temp = br.readLine().split(" ");
        sr = Integer.parseInt(temp[0]);
        sc = Integer.parseInt(temp[1]);


        temp = br.readLine().split(" ");
        er = Integer.parseInt(temp[0]);
        ec = Integer.parseInt(temp[1]);





    }

    private static void printArr(int[][] arr){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.printf("%2d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
