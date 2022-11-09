package daily.y_2022.m_11.w_02.d_2022_11_09.bj_1377_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];

        for(int i=0;i<n;i++){
            Node node = new Node(Integer.parseInt(br.readLine()),i);
            arr[i] = node;
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(arr[i].idx-i,max);

        }
        System.out.println(max+1);
    }

    static class Node implements Comparable<Node>{
        int val;
        int idx;
        public Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Node o){
            return val-o.val;
        }
    }
}
