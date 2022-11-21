package algorithms.dfs.bj_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] split;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static boolean flag = true;

    public static void main(String[] args) throws IOException{
        split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map =new int[n][m];
        Queue<Node> pq = new LinkedList<>();


        for(int i=0;i<n;i++){
            split = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(split[j]);

                if(Integer.parseInt(split[j])!=0){
                    pq.offer(new Node(i,j,Integer.parseInt(split[j])));
                }
            }
        }
        System.out.println(meltDown(pq,map));





    }
    static class Node{
        int r;
        int c;
        int w;
        public Node(int r, int c, int w){
            this.r= r;
            this.c=c;
            this.w=w;
        }
    }
    //녹이기구현
    private static int meltDown(Queue<Node> pq,int[][] map){
        Queue<Node>nq = new LinkedList<>();
        // System.out.println("멜트다운");
        int turn = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            turn ++;
            //한 회차
            while(size-->0){
                Node cur = pq.poll();
                if(cur.w==0) continue;
                else if(cur.w<0){
                    System.out.println("Err1");

                }else{
                    int r = cur.r;
                    int c = cur.c;
                    int w = cur.w;

                    //녹인값 반영
                    int zero = zeroCnt(r,c,map);
                    int val = Math.max(map[r][c]-zero,0);
                    nq.offer(new Node(r,c,val));
                }
            }
            while(!nq.isEmpty()){
                Node cur = nq.poll();
                int r = cur.r;
                int c = cur.c;
                int w = cur.w;
                map[r][c] = w;
                if(w>0){
                    pq.offer(cur);
                }
            }
            int part = parts(map);
            // System.out.println("part = " + part);
            // printMap(map);
            if(part>1) return turn;
        }
        return 0;

    }
    static int zeroCnt(int r, int c, int[][] map){
        // System.out.println("제로카운트");
        int count = 0;
        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0||nr>=map.length||nc<0||nc>=map[0].length) continue;
            if(map[nr][nc]==0) count++;
        }
        return count;
    }

    //덩어리 체크
    static int parts(int[][] map){
        // System.out.println("parts");
        int count =0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    // System.out.printf("i=%d, j=%d, count=%d\n",i,j,count);
                    count++;
                    dfs(map,visited,i,j);
                }
            }
        }
        return count;
    }

    static void dfs(int[][] map,boolean[][] visited, int sr, int sc){
        // System.out.printf("dfs sr=%d, sc=%d\n",sr,sc);
        visited[sr][sc] = true;
        int nr,nc;
        for(int i=0;i<4;i++){
            nr = sr+dr[i];
            nc = sc+dc[i];

            if(nr<0||nr>=map.length||nc<0||nc>=map[0].length) continue; //범위초과
            if(visited[nr][nc]) continue;
            if(map[nr][nc]==0)continue;

            dfs(map,visited,nr,nc);
        }



    }


    static void printMap(int[][] map){
        System.out.println();
        for(int i=0;i< map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }

    }
}
