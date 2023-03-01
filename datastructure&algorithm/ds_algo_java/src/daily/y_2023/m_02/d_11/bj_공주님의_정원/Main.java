package daily.y_2023.m_02.d_11.bj_공주님의_정원;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int sm,sd,em,ed;
    static int left = Integer.MAX_VALUE;
    static int right = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Flower[] flowers = new Flower[n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            sm = Integer.parseInt(st.nextToken());
            sd = Integer.parseInt(st.nextToken());
            em = Integer.parseInt(st.nextToken());
            ed = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower();
            // pq.offer(new Flower());
        }
        Arrays.parallelSort(flowers);

        left = 301;
        right = 1201;


        int count = 0;
        int max =0;
        int index = 0;

        while(left<right){
            boolean find = false;
            for(int i=index;i<n;i++){
                if(flowers[i].l > left){
                    break;
                }
                if(max<flowers[i].r){
                    find = true;
                    max = flowers[i].r;
                    index=i+1;
                }
            }
            if(find){
                left =max;
                count++;
            }else{
                break;
            }
        }


        if(max<right){
            System.out.println(0);
        }else{
            System.out.println(count);
        }

    }

    static class Flower implements Comparable<Flower>{
        int l,r;
        public Flower(){
            this.l = Math.max(sm*100+sd,301);
            this.r = Math.min(em*100+ed,1201);
        }
        // 1) 시작일 낮은 순
        // 2) 종료일 높은 순
        @Override
        public int compareTo(Flower f) {
            if(this.l < f.l) {
                return -1;
            }
            else if(this.l == f.l) {
                if(this.r > f.r) {
                    return -1;
                }
                else if(this.r == f.r) {
                    return 0;
                }
                return 1;
            }
            else {
                return 1;
            }
        }

    }
}
