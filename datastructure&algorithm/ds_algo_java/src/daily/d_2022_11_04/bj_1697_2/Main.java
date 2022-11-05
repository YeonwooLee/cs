package daily.d_2022_11_04.bj_1697_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] dirs = new int[3];

    public static void main(String[] args)throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr[K]=1;

        System.out.println(bfs());

    }

    static int bfs(){
        if(N==K) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N,0});
        visited[N] = true;
        int result = -1;

        int tt = 1;
        while(!q.isEmpty()){
            // System.out.printf("%d회차 \n",tt++);
            int size = q.size();
            while(size-->0) {
                int[] cur = q.poll();
                int posi = cur[0];
                int time = cur[1];

                dirs[0] = posi + 1;
                dirs[1] = posi - 1;
                dirs[2] = posi * 2;

                for (int i = 0; i < 3; i++) {

                    int next = dirs[i];

                    if (next < 0 || next > 100000) continue;
                    if (visited[next]) continue;
                    if (next == K) return time + 1;
                    // System.out.printf("%s -> %s \n",posi,next);
                    visited[next] = true;
                    q.offer(new int[]{next, time + 1});
                }
            }
        }

        return result;
    }
}
