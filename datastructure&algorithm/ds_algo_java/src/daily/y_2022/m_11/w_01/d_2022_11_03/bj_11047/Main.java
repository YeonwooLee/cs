package daily.y_2022.m_11.w_01.d_2022_11_03.bj_11047;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=N-1;i>=0;i--){
            if(arr[i]>K) continue;
            if(K/arr[i]>0){
                count += K/arr[i];//count에 k를 나눈 몫 입력
                K%=arr[i];//k는 arr[i]로 나눈 나머지
            }
        }

        System.out.println(count);
    }
}
