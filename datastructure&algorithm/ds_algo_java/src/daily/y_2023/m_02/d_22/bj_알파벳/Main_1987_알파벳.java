package daily.y_2023.m_02.d_22.bj_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int reuslt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        // ?System.out.println((int)'A'); 65
        // System.out.println((int)'Z'); 90
        int R, C;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
        }
        boolean[] used = new boolean[26]; //65~ 90
        used[(int)map[0][0]-65] = true;
        dfs(1,0,0,used,map);
        System.out.println(reuslt);
    }
    static void dfs(int depth, int sr, int sc, boolean[] used, char[][] map){
        int nr, nc;

        for(int i=0;i<4;i++){
            nr = sr+dr[i];
            nc = sc+dc[i];

            if(nr<0 || nr>=map.length || nc<0 || nc>=map[0].length) continue; //범위초과
            if(used[(int)map[nr][nc]-65]) continue; //이미사용

            used[(int)map[nr][nc]-65] = true;
            dfs(depth+1,nr,nc,used,map);
            used[(int)map[nr][nc]-65] = false;
        }

        reuslt = Math.max(depth,reuslt);
    }

}
