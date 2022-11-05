package algorithms.sort.bubble_sort.bj_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(map[j]>map[j+1]){
                    int temp = map[j];
                    map[j] = map[j+1];
                    map[j+1] = temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(map[i]);
        }
    }
}
