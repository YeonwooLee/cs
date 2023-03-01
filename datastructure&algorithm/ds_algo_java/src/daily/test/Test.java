package daily.test;
import java.math.BigInteger;
import java.io.*;
public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int k = 3;
        for(int i=0;i<5;i++){
            int t = k<<i;
            System.out.println(t);
        }

    }

}
