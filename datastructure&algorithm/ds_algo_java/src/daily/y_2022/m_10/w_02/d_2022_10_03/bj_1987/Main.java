package daily.y_2022.m_10.w_02.d_2022_10_03.bj_1987;
import java.util.*;
import java.io.*;

//30분
public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static char[] used = new char[100];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int result;
    public static void main(String[] args) throws IOException{
        init();

        //result = algorithms.algorithms.bfs.bj_2644_2.bfs();
        used[map[0][0]-0]='*';
        dfs(0,0,1, ""+map[0][0]);

        System.out.println(result);
    }
    static void dfs(int r,int c,int depth,String temp){

        if(result<depth){
            result = depth;
//            System.out.println(depth);
//            System.out.println(temp);
        }
        int nr,nc;
        for(int i=0;i<4;i++){
            nr = r+dr[i];
            nc = c+dc[i];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(visited[nr][nc]) continue;
            if(used[map[nr][nc]-0]=='*') continue;

            visited[nr][nc] = true;
            used[map[nr][nc]-0]='*';

            dfs(nr,nc,depth+1,temp+map[nr][nc]);

            visited[nr][nc]=false;
            used[map[nr][nc]-0]='5';
        }
    }
    static int bfs(){
        int res = 1;
        Queue<int[]> q = new LinkedList<>();

        //초기값
        q.offer(new int[] {0,0,1});
        visited[0][0] = true;
        used[map[0][0]]='*';

        int r,c,d, nr, nc;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            d = cur[2];

            for(int i=0;i<4;i++){
                nr = r+dr[i];
                nc = c+dc[i];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(visited[nr][nc]) continue;
                if(used[map[nr][nc]-0]=='*') continue;

                q.offer(new int[] {nr,nc,d+1});
                visited[nr][nc] = true;
                used[map[nr][nc]-0]='*';
                res = Math.max(res,d+1);
            }
        }
        return res;
    }

    static void init() throws IOException{
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
        }

        result = 0;
    }

    static void printArr(char[][] map){
        System.out.println();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.printf("%2c",map[i][j]);
            }
            System.out.println();
        }
    }
}
