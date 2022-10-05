package exhaustive_search.d_2022_10_04.bj_11725;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i, j;

        // 연결 정보
        ArrayList<Integer>[] list = new ArrayList[n+1];
        // 초기화
        for(i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 연결
        for(i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 결과 값(부모값)
        // 예: parents[i] = j (i의 부모 : j)
        int[] parents = new int[n+1];

        // dfs
        dfs(list, parents, 1, 0);

        // 결과 출력
        for(j=2;j<=n; j++) System.out.println(parents[j]);
    }

    private static void dfs(ArrayList<Integer>[] list, int[] parents, int start, int parent) {
        parents[start] = parent;
        for(int item : list[start]) {
            if(item != parent) dfs(list, parents, item, start);
        }
    }
}