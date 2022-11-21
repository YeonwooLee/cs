package daily.y_2022.m_11.w_03.d_2022_11_16.bj_3055;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] split = br.readLine().split(" ");

        int R = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);
        char[][] map = new char[R][C];

        boolean[][] visited = new boolean[R][C];
        int sr=0,sc=0,ddr=0,ddc=0;
        ArrayList<int[]> waters=new ArrayList<>();

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                char cur = s.charAt(j);
                map[i][j]=cur;
                if(cur=='.')continue;
                if(cur=='*') waters.add(new int[] {i,j});
                else if(cur=='D') {
                    ddr=i;
                    ddc=j;
                }
                else if(cur=='S') {
                    sr = i;
                    sc = j;
                }
            }
        }
        //같으면 0리턴후 종료
        if(sr==ddr && sc==ddc){
            System.out.println(0);
            return;
        }
        int  res = bfs(sr,sc,ddr,ddc,map,visited,waters,R,C);
        if (res==-1)System.out.println("KAKTUS");
        else System.out.println(res);
        // pirntArr(map);

    }
    static int bfs(int sr, int sc, int Dr, int Dc, char[][] map, boolean[][] visited, ArrayList<int[]> waters,int R,int C){
        Queue<int[]> gq = new LinkedList<>();
        Queue<int[]> wq = new LinkedList<>();
        for(int[] arr:waters){
            wq.offer(arr);
        }

        gq.offer(new int[] {sr,sc});
        visited[sr][sc] = true;
        int turn=0;

        while(!gq.isEmpty()){
            int size = gq.size();
            int waterSize = wq.size();
            turn++;
            //waterSpread
            while(waterSize-->0){
                int[] curWater = wq.poll();
                int r= curWater[0];
                int c = curWater[1];

                for(int i=0;i<4;i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(nr<0||nr>=R||nc<0||nc>=C) continue;
                    if(map[nr][nc]=='.'){
                        map[nr][nc]='*';
                        wq.offer(new int[] {nr,nc});
                    }
                }
            }

            //고슴도치 이동
            while(size-->0){
                int[] curHedge = gq.poll();
                int r = curHedge[0];
                int c = curHedge[1];

                for(int i=0;i<4;i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];

                    if(nr<0||nr>=R||nc<0||nc>=C) continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc]=='D') return turn;

                    visited[nr][nc]=true;
                    if(map[nr][nc]!='.') continue;
                    gq.offer(new int[] {nr,nc});
                }
            }

        }
        return -1;
    }

    static void pirntArr(char[][] map){
        System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%c ",map[i][j]);
            }
            System.out.println();
        }
    }
}
