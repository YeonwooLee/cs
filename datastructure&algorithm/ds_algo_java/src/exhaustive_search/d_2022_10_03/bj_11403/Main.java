package exhaustive_search.d_2022_10_03.bj_11403;
import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<N;k++){//거쳐가는노드
            for(int i=0;i<N;i++){//현재노드
                for(int j=0;j<N;j++){//도달노드
                    if(arr[i][k]==1 && arr[k][j]==1){//i->j 가능?
                        arr[i][j]=1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}