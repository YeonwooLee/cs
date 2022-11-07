package daily.y_2022.m_10.w_02.d_2022_10_08.bj_1377_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        for(int i=0;i<N;i++){
            Node n = new Node(Integer.parseInt(br.readLine()),i);
            arr[i]=n;
        }

        Arrays.sort(arr);

        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(arr[i].idx-i,max);
        }
        System.out.println(max+1);
    }

    static class Node implements Comparable<Node>{
        int value;
        int idx;

        public Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }
}
