package daily.y_2023.m_01.d_05.swea_최적경로;
import java.io.*;
public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T;// 테스트케이스 수

    static int N;// 고객 수

    static Customer[] customers;// 고객집 좌표 배열

    static boolean[] visited; // 방문

    static Company com;// 내 회사

    static Home home;// 내 집

    static int curR; // 현재 Row

    static int curC; // 현재 Col

    static int result;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int res = cal();
            bw.write("#"+tc+" "+res+"\n");
//			System.out.println(res);
        }
        bw.flush();
        bw.close();

    }

    static int cal() throws Exception {

        init();

        dfs(curR, curC, 0, 0, "0,0");

        return result;

    }

    static void dfs(int sr, int sc, int depth, int dist, String logs) {
        if(dist>=result) return;

        if (depth == N) {

            dist += calDist(sr, sc, home.r, home.c);

            result = Math.min(result, dist);

//			System.out.println(logs + " " + dist);

            return;

        }

        for (int i = 0; i < N; i++) {

            if (visited[i])
                continue;

            visited[i] = true;

            Customer curCustomer = customers[i];

            int nowR = curCustomer.r;

            int nowC = curCustomer.c;

            dfs(nowR, nowC, depth + 1, dist + calDist(sr, sc, nowR, nowC), logs + "-> " + nowR + "," + nowC);

            visited[i] = false;

        }

    }

    static int calDist(int r1, int c1, int r2, int c2) {

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);

    }

    static void init() throws Exception {

        result = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());

        customers = new Customer[N];

        visited = new boolean[N];

        String[] input = br.readLine().split(" ");

        int comR = Integer.parseInt(input[0]);

        int comC = Integer.parseInt(input[1]);

        int homeR = Integer.parseInt(input[2]);

        int homeC = Integer.parseInt(input[3]);

        com = new Company(comR, comC);

        home = new Home(homeR, homeC);

        int idx = 4;

        for (int i = 0; i < N; i++) {

            int r = Integer.parseInt(input[idx]);

            int c = Integer.parseInt(input[idx + 1]);

            customers[i] = new Customer(r, c);
            idx+=2;

        }

        curR = comR;

        curC = comC;

    }

    static class Customer {

        int r;

        int c;

        public Customer(int r, int c) {

            this.r = r;

            this.c = c;

        }

    }

    static class Company extends Customer {

        public Company(int r, int c) {

            super(r, c);

        }

    }

    static class Home extends Customer {

        public Home(int r, int c) {

            super(r, c);

        }

    }

}