package daily.y_2022.m_10.w_02.d_2022_10_07.pg_게임_맵_최단거리;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    public int solution(int[][] maps) {
        return bfs(maps);
    }
    static int bfs(int[][] map){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});

        int R = map.length;
        int C = map[0].length;

        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                int nt = t+1;

                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]==0) continue;
                if(visited[nr][nc]) continue;

                if(nr==R-1 && nc==C-1) return nt;
                visited[nr][nc] = true;
                q.offer(new int[] {nr,nc,nt});
            }
        }
        return -1;

    }
}