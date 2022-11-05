package daily.d_2022_11_05.bj_1026;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] A;
    static int[] B;
    static int N,S;

    static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        //A 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //B 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<N;i++){
            S+= A[i]*B[N-1-i];
        }
        System.out.println(S);




    }
}
