

package daily.y_2022.m_11.w_03.d_2022_11_15.bj_1717;
        import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] split;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);

        //초기부모값 = 자기자신
        arr = new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }

        int m = Integer.parseInt(split[1]);
        for(int i=0;i<m;i++){
            split = br.readLine().split(" ");
            int work = Integer.parseInt(split[0]);
            int a = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            if(work==0){
                int pa = findParent(a,arr);
                int pb= findParent(b,arr);

                if(pa>pb) arr[pa]=pb;
                else arr[pb]=pa;
            }
            else if(work==1){
                if(findParent(a,arr)==findParent(b,arr)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();


    }
    static int findParent(int n,int[] arr){
        if(arr[n]==n){
            return n;
        }
        return arr[n] = findParent(arr[n],arr);
    }


    static void printArr(){
        for(int i : arr){
            System.out.printf("%d ",i);
        }
        System.out.println();
    }
}
