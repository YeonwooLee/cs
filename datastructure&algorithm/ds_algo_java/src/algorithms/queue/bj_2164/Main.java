package algorithms.queue.bj_2164;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++){
            q.offer(i);
        }

        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        bw.write(Integer.toString(q.poll()));
        bw.flush();
        bw.close();


    }

}
