package dfs.bj_2023;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;


    public static void main(String[] args) throws IOException{
        // System.out.println(sosu("7331"));
        N = Integer.parseInt(br.readLine());
        dfs("",0);
        bw.flush();
        bw.close();
    }
    static void dfs(String result, int depth) throws IOException {
        if(depth==N){
            if(sosu(result)){
                bw.write(result+"\n");
            }
            return;
        }
        if(depth==0){
            for(int i=1;i<10;i++){
                dfs(result+Integer.toString(i),depth+1);
            }
        }else {
            if(!sosu(result)) return;
            for (int i = 0; i < 10; i++) {
                dfs(result + Integer.toString(i), depth + 1);
            }
        }
    }
    static boolean sosu(String n){
        for(int i=0;i<n.length();i++){
            String cur = n.substring(0,i+1);
            // System.out.println("cur is "+cur);
            if(!sosu(Integer.parseInt(cur))) return false;
        }
        return true;
    }
    static boolean sosu(int n){
        if(n==0) return false;
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;

    }
}
