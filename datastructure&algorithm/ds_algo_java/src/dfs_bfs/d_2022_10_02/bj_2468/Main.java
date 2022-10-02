package dfs_bfs.d_2022_10_02.bj_2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

//35분
//printArr 항상 만들기
//영역 셀 때 dfs에 초기화 코드 넣지 말기
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int finalResult=1;
    static int highest=1;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    //모든높이1인경우테스트
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
                highest=Math.max(highest,map[i][j]);
            }
        }

        for(int k=0;k<highest;k++) {
            init();

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]--;
                }
            }
//            printArr(map);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if(map[i][j]<1) continue;
//                    System.out.println("i="+i+" j="+j);
                    result++;
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
            finalResult = Math.max(result,finalResult);

        }

        System.out.println(finalResult);
    }
    static void dfs(int sr,int sc){
        int nr,nc;

        for(int i=0;i<4;i++){
            nr = sr+dr[i];
            nc = sc+dc[i];

            if(nr<0||nr>=N||nc<0||nc>=N) continue; //범위
            if(visited[nr][nc]) continue;
            if(map[nr][nc]<1) continue;

            visited[nr][nc] = true;
            dfs(nr,nc);
        }
    }

    private static void init()throws IOException{
        visited = new boolean[N][N];
        result = 0;
    }
    static void printArr(int[][] map){
        System.out.println();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf("%2d",map[i][j]);
            }
            System.out.println();
        }

    }
}
