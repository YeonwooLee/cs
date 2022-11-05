package algorithms.two_pointer.a;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int sum = 0;
        int end = 1;
        for(int i=1;i<=N;i++){
            while(sum<N){
                sum+=end;
                end++;
            }
            if(sum==N){
                result ++;
            }
            sum-=i;
        }
        System.out.println(result);
    }
}
