package queue.bj_11286;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);

                if(a<b){
                    return -1;
                }else if(a==b){
                    return o1-o2;
                }else{
                    return 1;
                }
            }
        });

        int cur;
        for(int i=0;i<N;i++){
            cur = Integer.parseInt(br.readLine());
            if(cur==0){
                if(pq.isEmpty()) bw.write("0\n");
                else{
                    bw.write(Integer.toString(pq.poll())+"\n");
                }
            }else{
                pq.offer(cur);
            }
        }

        bw.flush();
        bw.close();

    }

}
