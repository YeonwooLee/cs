package sort.bubble_sort.bj_1377;
import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];

        for(int i=0;i<n;i++){
            A[i] = new mData(Integer.parseInt(br.readLine()),i);
        }

        Arrays.sort(A);

        int max = 0;
        for(int i=0;i<n;i++){
            if(max<A[i].index-i){
                max = A[i].index-i;
            }
        }

        System.out.println(max+1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){
        return this.value-o.value;
    }
}
