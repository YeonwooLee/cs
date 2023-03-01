package daily.y_2023.m_02.d_16.bj_17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
    //배열의 값은 각 행의 합의 최솟값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    static int[][] temp;
    static int result =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] roteMap = new int[k][3];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            // printArr(map);
            // rotate(map,r,c,s);
            // printArr(map);
            roteMap[i]=new int[]{r,c,s};

        }
        int resultLen = roteMap.length;
        int[] resultSeq = new int[resultLen];
        boolean[] visited = new boolean[resultLen];

        dfs(0,resultLen,resultSeq,visited,map,roteMap);

        System.out.println(result);

    }
    static void dfs(int idx,int resultLen, int[] resultSeq,boolean[] visited,int[][] map,int[][] roteMap){
        if(idx==resultLen){
            //복사배열만들고
            temp = new int[map.length][map[0].length];
            for(int i=0;i<map.length;i++){
                temp[i] = map[i].clone();
            }

            //순서에맞게회전
            for(int i=0;i<resultSeq.length;i++){
                int num = resultSeq[i];
                int r = roteMap[num][0];
                int c = roteMap[num][1];
                int s = roteMap[num][2];
                rotate(temp,r,c,s);
            }
            //마딱수추출
            int min = getMin(temp);
            result = Math.min(min,result);
        }
        
        for(int i=0;i<resultLen;i++){
            if(visited[i]) continue;//방문처리
            
            //사용
            visited[i] = true;
            resultSeq[idx]=i;
            dfs(idx+1,resultLen, resultSeq, visited, map, roteMap);
            
            //사용해제
            visited[i] =false;
            
        }

    }
    static int getMin(int[][] map){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<map.length;i++){
            int sum = 0;
            for(int j=0;j<map[0].length;j++){
                sum += map[i][j];
            }
            min = Math.min(min,sum);
        }
        return min;
    }

    static void rotate(int[][] map, int r, int c, int s){
        //복사배열 생성
        int[][] temp = new int[map.length][map[0].length];
        for(int i=0;i<temp.length;i++){
            temp[i] = map[i].clone();
        }

        for(int i=1;i<=s;i++){
            //시작값
            int sr = r-i;
            int sc = c-i;
            int er = r+i;
            int ec = c+i;

            int nr = sr;
            int nc = sc;

            for(int d=0;d<4;d++){
                while(nr+dr[d]>=sr && nr+dr[d]<=er && nc+dc[d]>=sc && nc+dc[d]<=ec){
                    temp[nr+dr[d]][nc+dc[d]] = map[nr][nc];
                    nr += dr[d];
                    nc += dc[d];
                }
            }

        }
        for(int i=0;i<map.length;i++){
            map[i] = temp[i].clone();
        }


    }

    static void printArr(int[][]map){
        System.out.println();
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%2d",map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
