package daily.y_2023.m_01.d_20.bj_11053_가장_긴_증가하는_부분_수열;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());//String[] input = split(" ")과 속도 비교
        int arr[] = new int[n+1]; //수열 배열
        int dp[] = new int[n +1];//여기까지 오는 최대 길이

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] =1; //1까지 오는 최대길이 무조건 1
        int ans = 1; //최소 정답 1
        for(int i=2; i<=n;i++){ // 나
            dp[i] =1; //나는 1
            //나까지 오는 최대길이 구하기
            for(int j=1;j<i;j++){//이전것부터 나까지
                if(arr[i] > arr[j] && dp[i] <= dp[j]){//내가 이전것보다 크고, 이전것까지 오는 최대길이가 나까지 오는 최대길이보다 크거나 같다면
                    dp[i] =dp[j]+1;//나까 지오는 최대길이 = {이전 것까지 오는 최대길이 +1}
                }
            }
            ans = Math.max(dp[i],ans);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

}
