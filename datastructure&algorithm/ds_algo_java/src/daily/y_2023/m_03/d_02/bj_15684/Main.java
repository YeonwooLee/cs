package daily.y_2023.m_03.d_02.bj_15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5:35~5:45
5:45~

사다리 조작

사다리 표현
1인덱스 2차원배열 H+1,N+1
M = 이미있는연결
true와 true로 연결 확인

사다리 시뮬
아래로이동
트루면 옆으로 이동

사다리 추가
1,1 ~ n,m-1까지 추가 가능, 놨으면 r,c와 r,c+1 트루처리
중복순열

 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // C
    static int M; //연결 수
    static int H; //R
    static boolean[][] ladder;


    static int simulate(int sc){
        int sr = 1;

        int nr = sr;
        int nc = sc;
        while(isIn(nr,nc)){
            if(ladder[nr][nc]){//선발견
                //우측이동
                if(isIn(nr,nc+1) && ladder[nr][nc+1]){
                    nc++;
                }//좌측이동
                else if(isIn(nr,nc-1) && ladder[nr][nc-1]){
                    nc--;
                }//불가능케이스
                else{
                    throw new RuntimeException();
                }
            }

            nr++;
        }
        return nc;

    }
    static boolean isIn(int r, int c){
        return r>=1 && r<=H && c>=0 && c<=N;
    }
    static void dfs(){

        for(int r=1;r<=H;r++){
            for(int c=1;c<N;c++){
                if(ladder[r][c]) continue;//못놈 - 존재하는 선
                if(!isIn(r,c+1)) continue;//못놈 - 우측없음
                if(ladder[r][c+1]) continue;// 못놈 - 우측존재


            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//C
        M = Integer.parseInt(st.nextToken());//연결
        H = Integer.parseInt(st.nextToken());//R
        //사다리 생성
        ladder = new boolean[H+1][N+1];

        for(int i=0;i<M;i++){
            //st로 써도 메모리 안놔줌
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(edge.nextToken());
            int b = Integer.parseInt(edge.nextToken());
            ladder[a][b] = true;
            ladder[a][b+1] = true;

        }
        // printArr(ladder);


        // simulate(1);
        // for(int i=1;i<=N;i++){
        //     System.out.println(i+" "+simulate(i));
        // }

    }



    //디버깅 함수
    static void printArr(boolean[][] map){
        System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //
}
