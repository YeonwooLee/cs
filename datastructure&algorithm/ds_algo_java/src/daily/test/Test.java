package daily.test;
import java.math.BigInteger;
import java.io.*;
public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        String[] s = br.readLine().split("[a]");
        for(String ss:s){
            System.out.println("ss = " + ss);
        }


    }

}
