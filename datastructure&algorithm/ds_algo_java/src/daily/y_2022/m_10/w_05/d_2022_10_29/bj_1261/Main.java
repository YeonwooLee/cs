package daily.y_2022.m_10.w_05.d_2022_10_29.bj_1261;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int r,c,p;
    public Node(int r, int c, int p){
        this.r = r;
        this.c = c;
        this.p = p;
    }
    @Override
    public int compareTo(Node o){
        return p-o.p;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = {0,1,0,-1};
    static int[] dc ={1,0,-1,0};
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//열
        int N = Integer.parseInt(st.nextToken());//행
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        System.out.println(bfs(map,N-1,M-1));
    }

    private static int bfs(int[][] map, int r,int c){
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[map.length][map[0].length];

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cp = cur.p;
            for(int i=0;i<4;i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr<0||nr>r||nc<0||nc>c) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] =true;
                if(nr==r&&nc==c){
                    return cp;
                }
                q.offer(new Node (nr,nc,cp+map[nr][nc]));
            }

        }
        return 0;
    }
}
