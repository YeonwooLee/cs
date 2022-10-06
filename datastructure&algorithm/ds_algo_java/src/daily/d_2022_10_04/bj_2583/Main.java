package daily.d_2022_10_04.bj_2583;

import java.io.*;
import java.util.*;

public class Main {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static ArrayList<Integer> list;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = 1;
        for(int t=0;t<T;t++){
            init();
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1) continue;
                    list.add(bfs(i,j));
                }
            }
            Collections.sort(list);

            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
        }
    }
    static int bfs(int r, int c){
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        map[r][c] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            result++;
            int sr = now[0];
            int sc = now[1];

            for(int i=0;i<4;i++){
                int nr = sr+dr[i];
                int nc = sc+dc[i];
                if(nr<0||nr>=M||nc<0||nc>=N) continue;
                if(map[nr][nc]==1) continue;
                map[nr][nc]=1;
                q.offer(new int[]{nr,nc});
            }
        }
        return result;

    }
    static void init() throws IOException{
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            fill(r1,c1,r2,c2);
        }
    }
    static void fill(int r1,int c1,int r2,int c2){
        for(int i=r1;i<r2;i++){
            for(int j=c1;j<c2;j++){
                map[j][i] = 1;
            }
        }
    }

    static void printArr(){
        System.out.println();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j]+ " ");
            }System.out.println();
        }
    }
}
