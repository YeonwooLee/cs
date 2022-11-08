package daily.y_2022.m_11.w_02.d_2022_11_08.bj_1707;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static int[][] graph;
    public static int[] visited;

    public static ArrayList <Integer>[] graphA = new ArrayList [20001];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = new String();

        int testCase = Integer.parseInt(br.readLine());
        boolean rst = true;

        for (int t = 1; t <= testCase; t++)
        {
            s = br.readLine();

            StringTokenizer st = new StringTokenizer(s, " ");

            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());

            for (int i = 1 ; i <= nodeCnt; i++)
            {
                graphA[i] = new ArrayList<Integer>();
            }

            int sv;
            int ev;
            for (int i = 0 ; i < edgeCnt; i++)
            {
                s = br.readLine();

                StringTokenizer stt = new StringTokenizer(s, " ");
                sv = Integer.parseInt(stt.nextToken());
                ev = Integer.parseInt(stt.nextToken());

                graphA[sv].add(ev);
                graphA[ev].add(sv);
            }

            visited = new int[nodeCnt+1];
            rst=true;

            for (int i = 1 ; i <= nodeCnt; i++)
            {
                if (visited[i] == 0)
                {
                    rst = DFS(i, nodeCnt, 1);
                    if (!rst) break;
                }

            }

            if (rst)
                System.out.println("YES");
            else
                System.out.println("NO");

        }


    }

    public static boolean DFS(int startVertex, int nodeCnt, int colored)
    {
        boolean rst = true;

        int newColor;
        if (colored == 1)
        {
            visited[startVertex] = 2;
            newColor = 2;
        }
        else
        {
            visited[startVertex] = 1;
            newColor = 1;
        }

        int node;
        for (int i=0; i< graphA[startVertex].size(); i++)
        {
            node = graphA[startVertex].get(i);

            if (visited[node] == newColor)
            {
                return false;
            }
            else
            {
                if (visited[node] == 0)
                {
                    rst = DFS(node, nodeCnt, newColor);
                    if (!rst) return rst;
                }
            }
        }

        return rst;
    }


}