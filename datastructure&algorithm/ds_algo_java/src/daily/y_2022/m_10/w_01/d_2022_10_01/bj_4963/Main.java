package daily.y_2022.m_10.w_01.d_2022_10_01.bj_4963;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,-1,-1,-1,0,1,1,1};

    static int R;
    static int C;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException{
        while(true){
            init();//R,C,map,visited 초기화
            if(R==0 && C==0){
                bw.flush();
                bw.close();
                break;
            }
            //메인로직
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(visited[i][j]) continue;
                    if(map[i][j]!=1)continue;
                    visited[i][j] = true;
                    count++;
                    dfs(i,j);
                }
            }
            bw.write(Integer.toString(count)+"\n");

        }

    }
    private static void dfs(int sr, int sc){
        int nr,nc;
        for(int i=0;i<8;i++){
            nr = sr+dr[i];
            nc = sc+dc[i];

            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]!=1) continue;//땅인지 확인!

            visited[nr][nc] = true;
            dfs(nr,nc);
        }

    }
    private static void printArr(int[][] map){
        System.out.println();
        System.out.println("R="+R+" C="+C);
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%2d",map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void init() throws IOException{
        count = 0;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        if(C==0&&R==0) return;

        map = new int[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

