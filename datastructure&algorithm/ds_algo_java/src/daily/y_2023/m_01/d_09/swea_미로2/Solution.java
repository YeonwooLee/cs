package daily.y_2023.m_01.d_09.swea_미로2;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static boolean result;
    static boolean[][] visited;

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    static int ss=100;

    public static void main(String[] args) throws Exception{
        for(int i=1;i<=10;i++) {
            init();
            if(bfs()) {
                bw.write("#"+i+" 1\n");
            }else {
                bw.write("#"+i+" 0\n");
            }
        }
        bw.flush();
        bw.close();


    }
    static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        visited[1][1]=true;

        int turn =0;
        while(!q.isEmpty()) {
            turn ++;
//			System.out.println("turn= "+turn);
            int size = q.size();
            while(size-->0) {
                Node cur = q.poll();
                int cr = cur.r;
                int cc = cur.c;
//				System.out.println(cr+" "+cc+" "+map[cr][cc]);
                for(int i=0;i<4;i++) {
                    int nr = cr+dr[i];
                    int nc = cc+dc[i];

                    if(nr<0||nr>=ss||nc<0||nc>=ss) continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc]==1) continue;

                    visited[nr][nc] = true;
                    if(map[nr][nc]==3) {
//						System.out.println("nr="+nr+"nc="+nc);
                        return true;
                    }
                    q.offer(new Node(nr,nc));
                }
            }

        }
        return false;

    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }
    static void init() throws Exception{
        br.readLine();
        map = new int[ss][ss];
        visited = new boolean[ss][ss];
        result = false;

        for(int i=0;i<ss;i++) {
            char[] s = br.readLine().toCharArray();
            for(int j=0;j<ss;j++) {
                map[i][j] = (int)s[j]-'0';
            }
        }

//		printmap();

    }

    static void printmap() {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map.length;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}